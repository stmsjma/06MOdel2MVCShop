package com.model2.mvc.web.product;

import java.sql.PreparedStatement;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.user.UserService;


//==> 상품관리  Controller
@Controller
public class ProductController {
	
	///Field
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	//setter Method 구현 않음
		
	public ProductController(){
		System.out.println(this.getClass());
	}
	
	//==> classpath:config/common.properties  ,  classpath:config/commonservice.xml 참조 할것
	//==> 아래의 두개를 주석을 풀어 의미를 확인 할것
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	//@Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;
	
	
	@RequestMapping("/addProductView.do")
	public ModelAndView addProductView() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("/addProductView.do");
		
		modelAndView.setViewName("redirect:/product/addProductView.jsp");
	
		return modelAndView;
	}
	
	@RequestMapping("/addProduct.do")
	public ModelAndView addProduct( @ModelAttribute("product") Product product ) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		
		String mandate1 = "";
		String mandate2 = "";
		String mandate3 = "";
		
		mandate1 =  product.getManuDate().substring(0,4);
		mandate2 =  product.getManuDate().substring(5,7);
		mandate3 =  product.getManuDate().substring(8,10);
		
		mandate1 = mandate1 + mandate2 + mandate3;
				
		product.setManuDate(mandate1);
		
		System.out.println("/addProduct.do");
		
		productService.addProduct(product);
		
		modelAndView.setViewName("/product/registerProductView.jsp");
		//Business Logic

		return modelAndView;
	}
	
	@RequestMapping("/getProduct.do")
	public ModelAndView getUser( @RequestParam(value="menu", required=true)  String menu, 
								 @RequestParam(value="prodNo", required=true) Integer prodNo , 
								 Model model ) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("/getProduct.do");
		//Business Logic
		
		Product product = productService.getProduct(prodNo);
		// Model 과 View 연결
		model.addAttribute("product", product);
		
		if (menu.equals("managed")) {
			System.out.println("updateProduct.jsp called");
			System.out.println(product+"겟프로덕액션");
			modelAndView.setViewName("/product/updateProduct.jsp");
			
			return modelAndView;
		} else {
			System.out.println(product+"겟프로덕액션");
			modelAndView.setViewName("/product/readProduct.jsp");
			
			return modelAndView;
		}
		
	}
	
	@RequestMapping("/updateProductView.do")
	public ModelAndView updateProductView( @RequestParam("prodNo") Integer prodNo , Model model ) throws Exception{

		System.out.println("/updateProductView.do");
		//Business Logic
		ModelAndView modelAndView = new ModelAndView();
		
		Product product = productService.getProduct(prodNo);
		// Model 과 View 연결
		model.addAttribute("product", product);
		
		modelAndView.setViewName("/product/updateProductView.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("/updateProduct.do")
	public ModelAndView updateProduct( @ModelAttribute("product") Product product , Model model , HttpSession session) throws Exception{

		System.out.println("/updateProduct.do");
		ModelAndView modelAndView = new ModelAndView();
		
		//Business Logic
		productService.updateProduct(product);
		
		modelAndView.setViewName("/updateProductView.do");
				
		return modelAndView;
	}
	
	@RequestMapping("/listProduct.do")
	public ModelAndView listProduct( @ModelAttribute("search") Search search, 
								  Model model , HttpServletRequest request) 
								  throws Exception{
		
		System.out.println("/listProduct.do");
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		// Business logic 수행
		Map<String , Object> map=productService.getProductList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		
		
		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		System.out.println("list show ::"  + map.get("list"));
		
		
		if(request.getParameter("menu").equals("search")) {
			System.out.println("listProduct.jsp called");
			modelAndView.setViewName("/product/listProduct.jsp"); 
			return modelAndView;
		}
		else  { 
			System.out.println("manageProduct.jsp called");
			modelAndView.setViewName("/product/manageProduct.jsp");
			return modelAndView;
	   }
	}
}