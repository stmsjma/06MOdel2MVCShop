package com.model2.mvc.service.product.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDAO;
import com.model2.mvc.service.product.ProductService;


@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{
	
	///Field
	@Autowired
	@Qualifier("productDaoImpl")
	
	private ProductDAO productDao;
	
	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}
	
	///Constructor
	public ProductServiceImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public int addProduct(Product product) throws Exception {
		return productDao.addProduct(product);
	}
	
	public Product getProduct(int prodNo) throws Exception {
		return productDao.getProduct(prodNo);
	}

	public Map<String , Object > getProductList(Search search) throws Exception {
		
		System.out.println("Search ::" + search);
		
		
		List<Product> list= productDao.getProductList(search);
		
		System.out.println("list ::" + list);
		
		
		int totalCount = productDao.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}

	public int updateProduct(Product product) throws Exception {
		return productDao.updateProduct(product);
	}
	
	
	
}