package com.model2.mvc.service.product.test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDAO;
import com.model2.mvc.service.product.ProductService;


/*
 *	FileName :  ProductServiceTest.java
 * �� JUnit4 (Test Framework) �� Spring Framework ���� Test( Unit Test)
 * �� Spring �� JUnit 4�� ���� ���� Ŭ������ ���� ������ ��� ���� �׽�Ʈ �ڵ带 �ۼ� �� �� �ִ�.
 * �� @RunWith : Meta-data �� ���� wiring(����,DI) �� ��ü ����ü ����
 * �� @ContextConfiguration : Meta-data location ����
 * �� @Test : �׽�Ʈ ���� �ҽ� ����
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/context-common.xml",
									"classpath:config/context-aspect.xml",
									"classpath:config/context-mybatis.xml",
									"classpath:config/context-transaction.xml"})
public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration �̿� Wiring, Test �� instance DI
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;


	//@Test
	public void testAddProduct() throws Exception {
		
		Product product = new Product();
		
		product.setFileName("imafile"); 
		product.setManuDate("20030202");
		product.setPrice(20000);
		product.setProdDetail("�˶���");
		product.setProdName("�ڵ��");
		product.setProdNo(10033);
		product.setRegDate(new Date(20160202));
		product.setWareHouseCode("001");
		product.setQuanity(10);
		product.setProTranCode("001");
		
		productService.addProduct(product);
		
		product = productService.getProduct(product.getProdNo());
		//==> console Ȯ��
		System.out.println(product);
		
		//==> API Ȯ��
		Assert.assertEquals("imafile", product.getFileName());
		Assert.assertEquals("20030202", product.getManuDate());
		Assert.assertEquals(20000, product.getPrice());
		Assert.assertEquals("�˶���", product.getProdDetail());
		Assert.assertEquals("�ڵ��", product.getProdName());
		Assert.assertEquals(10033, product.getProdNo());
		Assert.assertEquals("001", product.getWareHouseCode());
		Assert.assertEquals("001", product.getProTranCode());
		Assert.assertEquals(10, product.getQuanity());
		Assert.assertEquals(20160202, product.getRegDate());
		
	}
	
	@Test
	public void testGetProduct() throws Exception {
		
		 Product product = new Product();
		//==> �ʿ��ϴٸ�...
//		user.setUserId("testUserId");
//		user.setUserName("testUserName");
//		user.setPassword("testPasswd");
//		user.setSsn("1111112222222");
//		user.setPhone("111-2222-3333");
//		user.setAddr("��⵵");
//		user.setEmail("test@test.com");
		System.out.println(":: 2. getProduct(SELECT)  ? ");
		System.out.println(":: "+ productService.getProduct(10033));
		System.out.println("\n");
		 
		
		//==> console Ȯ��
		System.out.println(product);
		
		//==> API Ȯ��
		
	
		//Assert.assertEquals("20030202", product.getManuDate());
		//Assert.assertEquals(20000, product.getPrice());
		//Assert.assertEquals("�˶���", product.getProdDetail());
		Assert.assertEquals("�ڵ��", product.getProdName());
		Assert.assertEquals(10033, product.getProdNo());
		Assert.assertEquals("001", product.getWareHouseCode());
		Assert.assertEquals("001", product.getProTranCode());
		//Assert.assertEquals(20160202, product.getRegDate());
		
		
	}
	
	//@Test
	public void testUpdateProduct() throws Exception{
		Product product = new Product();
		
		//3. updateProduct Test  :: 
		product.setProdName("�����ڵ���");
		product.setQuanity(5);
		product.setPrice(25000);
		product.setProdNo(10030);
		System.out.println(":: 3. update(UPDATE)  ? ");
		System.out.println(":: "+ productService.updateProduct(product));
		System.out.println("\n");
		
		
		product = productService.getProduct(product.getProdNo());
		Assert.assertNotNull(product);
		
		//==> console Ȯ��
		System.out.println(product);
			
		//==> API Ȯ��

		Assert.assertEquals("�����ڵ���", product.getProdName());
		Assert.assertEquals(5, product.getQuanity());
		Assert.assertEquals(25000, product.getPrice());
		
	 }
	 

	 //@Test
	 public void testGetProductListAll() throws Exception {

			Search search = new Search();
			search.setCurrentPage(1);
			search.setPageSize(20);

			
			Map<String,Object> map = productService.getProductList(search);
					 
			List<Object> list = (List<Object>)map.get("list");
		 			 	
		 	Assert.assertEquals(13, list.size());
		 	
			//==> console Ȯ��
		 	System.out.println(list);
		 	
		 	Integer totalCount = (Integer)map.get("totalCount");
		 	System.out.println(totalCount);
		 	
		 	System.out.println("=======================================");
  
	  }
	
	//@Test
	public void testGetProductListByProductNo() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
		search.setSearchCondition("0");
		search.setSearchKeyword("1000");
	
	 	 	
		Map<String,Object> map = productService.getProductList(search);
		List<Object> list = (List<Object>)map.get("list");

		System.out.println(list);
	 
	 	Assert.assertEquals(1, list.size());
	 	
		//==> console Ȯ��
	 	System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword(""+System.currentTimeMillis());
	 	
	 }
	 
	 //@Test
	 public void testGetProductListByProductName() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("1");
	 	search.setSearchKeyword("LGŰ����");

	 	Map<String,Object> map = productService.getProductList(search);
		List<Object> list = (List<Object>)map.get("list");

		System.out.println(list);
	 
	 	Assert.assertEquals(1, list.size());
	 	
	 	//==> console Ȯ��
	 	System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 }
	//@Test
		 public void testGetProductListByProductPrice() throws Exception{
			 
		 	Search search = new Search();
		 	search.setCurrentPage(1);
		 	search.setPageSize(3);
		 	search.setSearchCondition("2");
		 	search.setSearchKeyword("10000");

		 	Map<String,Object> map = productService.getProductList(search);
			List<Object> list = (List<Object>)map.get("list");

			System.out.println(list);
		 
		 	Assert.assertEquals(1, list.size());
		 	
		 	//==> console
		 	
		 	System.out.println(list);
		 	
		 	Integer totalCount = (Integer)map.get("totalCount");
		 	System.out.println(totalCount);
		 	
		 	System.out.println("=======================================");
	}	 	
  }
 