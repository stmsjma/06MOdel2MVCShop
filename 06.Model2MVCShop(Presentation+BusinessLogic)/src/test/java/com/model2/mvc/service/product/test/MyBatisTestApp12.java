package com.model2.mvc.service.product.test;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.impl.ProductDaoImpl;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

/*
 * FileName : MyBatisTestApp12.java
  * :: Business Layer unit Test : Service + Persistence (MyBatis + DAO)
  */
public class MyBatisTestApp12 {
	
	///main method
	public static void main(String[] args) throws Exception{

		//==> SqlSessionFactoryBean.getSqlSession()�� �̿� SqlSession instance GET
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		
		//==> UserDaoImpl11 ���� �� sqlSession instance setter injection
		ProductDaoImpl productDao = new ProductDaoImpl();
		productDao.setSqlSession(sqlSession);
		
		//==> MyBatisTestApp12 ���� �� productDao instance setter injection
		ProductServiceImpl productService = new  ProductServiceImpl();
		productService.setProductDao(productDao);
				
		System.out.println("\n");
		
		//==> Test �� User instance ����  
		Product product = new Product("imafile","20030202",20000,"�˶���","�ڵ���",10023,new Date(20160202),"001",3,"001");
			
		//1. addUser Test  
		System.out.println(":: 1. addProduct(INSERT)  ? ");
		System.out.println(":: "+ productService.addProduct(product));
		System.out.println("\n");
		
		
		//2. getUser Test :: �ָ� inert Ȯ�� 
		System.out.println(":: 2. getProduct(SELECT)  ? ");
		
		System.out.println(":: "+ productService.getProduct(product.getProdNo()));
		System.out.println("\n");
     
		
		//3. uadateUser Test  :: �ָ� ==> �´� ����
				
		product.setProdName("�߰��ڵ���");
		product.setQuanity(2);
		product.setPrice(30000);
		System.out.println(":: 3. update(UPDATE)  ? ");
		System.out.println(":: "+ productService.updateProduct(product));
		System.out.println("\n");
		
		//4. getUserList Test ::
		
		System.out.println(":: 4. getProductList(SELECT)  ? ");
		Search search = new Search();
		
		//search.setSearchCondition("0");
		search.setCurrentPage(1);
		search.setPageSize(3);

		//search.setSearchCondition("0");
		//search.setSearchKeyword("1000");
		
		System.out.println(":: List<User> ���� : "+ productService.getProductList(search) );
		System.out.println("\n");
		
		
	
		//END::SqlSession  close
		System.out.println("::END::SqlSession �ݱ�..");
		sqlSession.close();
		
	}//end of main
}//end of class