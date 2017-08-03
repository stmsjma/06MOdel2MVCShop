package com.model2.mvc.service.product.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

/*
 * FileName : MyBatisTestApp13.java
  * :: Business Layer unit Test : Service + Persistence (Spring +mybatis + DAO)
  */
public class MyBatisTestApp13 {
	
	///main method
	public static void main(String[] args) throws Exception{

		ApplicationContext context =
			new ClassPathXmlApplicationContext(
					new String[] {	"/config/commonservice.xml",
									"/config/userservice13.xml" }
	    );
		System.out.println("\n");

		//==> Bean/IoC Container 로 부터 획득한 UserService 인스턴스 획득
		ProductService productService = (ProductService)context.getBean("productServiceImpl");
		
		System.out.println("\n");
		
		//==> Test 용 Product instance 생성  
		Product product = new Product("imafile","20030202",20000,"알뜰폰","핸드폰",10025,new Date(20160202),"001",3,"001");

		//1. addProduct Test  
		System.out.println(":: 1. addProduct(INSERT)  ? ");
		System.out.println(":: "+ productService.addProduct(product) ); 
		System.out.println("\n");
		
		//2. getUser Test :: product inert 확인 
		System.out.println(":: 2. getProduct(SELECT)  ? ");
		System.out.println(":: "+ productService.getProduct(product.getProdNo()));
		System.out.println("\n");

		//3. updateProduct Test  :: 
		product.setProdName("중고핸드폰");
		product.setQuanity(2);
		product.setPrice(30000);
		System.out.println(":: 3. update(UPDATE)  ? ");
		System.out.println(":: "+ productService.updateProduct(product));
		System.out.println("\n");
		
		//4. getUserList Test ::
		Search search = new Search();
		
		search.setCurrentPage(1);
		search.setPageSize(3);
		
		Map<String,Object> map = productService.getProductList(search);
					
		List<Object> list = (List<Object>)map.get("list");

		System.out.println(list);
		search.setSearchCondition("0");
		search.setSearchKeyword("1000");
		
		System.out.println(":: List<Product> 내용 : "+ productService.getProductList(search) );
		System.out.println("\n");
		
			
	}//end of main
}//end of class