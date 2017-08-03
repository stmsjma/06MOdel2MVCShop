package com.model2.mvc.service.product.test;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.impl.ProductDaoImpl;


/*
 * FileName : MyBatisTestApp11.java 
 *  :: Persistence Layer unit Test : MyBatis + DAO
  */
public class MyBatisTestApp11 {
	
	///main method
	public static void main(String[] args) throws Exception{

		//==> SqlSessionFactoryBean.getSqlSession()�� �̿� SqlSession instance GET
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		
		//==> UserDaoImpl11 ���� �� sqlSession instance setter injection
		ProductDaoImpl productDao = new ProductDaoImpl();
		productDao.setSqlSession(sqlSession);
		System.out.println("\n");
		Search search = new Search();
		
		//search.setSearchCondition("0");
		search.setCurrentPage(1);
		search.setPageSize(3);
		
		//==> Test �� User instance ����  
		
		//Product product = new Product("imafile","20030202",20000,"�˶���","�ڵ���",10020,new Date(20160202),"001",3,"001");
		
		/*1. addProduct Test  
		System.out.println(":: 1. addProduct (INSERT)  ? ");
		System.out.println(":: "+ productDao.addProduct(product));
		System.out.println("\n");
		*/
		
		
		//2. getProduct  Test ::  inert Ȯ�� 
		//System.out.println(":: 2. getUser(SELECT)  ? ");
		//System.out.println(":: "+ productDao.getProduct(product.getProdNo()));
		//System.out.println("\n");

		//3. uadateProduct  Test  ::  ==> �´� ����
		/*
		product.setProdName("�߰��ڵ���");
		product.setQuanity(2);
		product.setPrice(30000);
		System.out.println(":: 3. update(UPDATE)  ? ");
		System.out.println("::" + productDao.updateProduct(product));
		
		System.out.println("\n");
		*/
		
		//4. getUserList Test ::
		System.out.println(":: 4. getProductList(SELECT)  ? ");
		//Search search = new Search();
		search.setSearchCondition("0");
		search.setSearchKeyword("1000");
		
		System.out.println(":: List<User> ���� : "+ productDao.getProductList(search) );
		for(Product pr : productDao.getProductList(search)){
			System.out.println(pr);
		}
		System.out.println("\n");
		
		
		/*5. removeUser Test
		System.out.println(":: 5. removeUser (DELETE)  ? ");
		System.out.println(":: "+userDao.removeUser(user.getUserId()) );
		System.out.println("\n");
		
		*/
		
		//6. getUserList Test 
		System.out.println(":: 6. getUserList(SELECT)  ? ");
		System.out.println("List<Product> ���� : "+ productDao.getProductList(search) );
		System.out.println("\n");
		
		
		//END::SqlSession  close
		System.out.println("::END::SqlSession �ݱ�..");
		
		
		
		sqlSession.close();
	}//end of main
}//end of class