package com.model2.mvc.service.purchase.test;

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
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductDAO;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;

/*
 *	FileName :  ProductServiceTest.java
 * ㅇ JUnit4 (Test Framework) 과 Spring Framework 통합 Test( Unit Test)
 * ㅇ Spring 은 JUnit 4를 위한 지원 클래스를 통해 스프링 기반 통합 테스트 코드를 작성 할 수 있다.
 * ㅇ @RunWith : Meta-data 를 통한 wiring(생성,DI) 할 객체 구현체 지정
 * ㅇ @ContextConfiguration : Meta-data location 지정
 * ㅇ @Test : 테스트 실행 소스 지정
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/context-common.xml",
									"classpath:config/context-aspect.xml",
									"classpath:config/context-mybatis.xml",
									"classpath:config/context-transaction.xml"})
public class PurchaseServiceTest {

	//==>@RunWith,@ContextConfiguration 이용 Wiring, Test 할 instance DI
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;


	//@Test
	public void testAddPurchase() throws Exception {
		
		Purchase purchase = new Purchase();
		User buyer = new User(); 
		buyer.setUserId("user07");
		purchase.setBuyer(buyer); 
		Product purchaseProd = new Product();
		purchaseProd.setProdNo(10020);

		purchase.setDivyAddr("서울시 강남구 역삼동 111");
		purchase.setDivyDate("20170220");
		purchase.setDivyRequest("빠른 배송 바랍니다.");
		purchase.setOrderDate(new Date(20100220));
		purchase.setPaymentOption("001");
		purchase.setPurchaseProd(purchaseProd);
		purchase.setReceiverName("공책");
		purchase.setReceiverPhone("010-444-6666");
		purchase.setTranCode("002");
		
		purchaseService.addPurchase(purchase);
		
		//==> console 확인
		System.out.println(purchase);
		}
	
	//@Test
	public void testGetPurchase() throws Exception {
		
		Purchase purchase = new Purchase();
	
		System.out.println(":: 2. getPurchase(SELECT)  ? ");
		purchase = purchaseService.getPurchase(10023);
	
		System.out.println("\n");
		
		//==> console 확인
		System.out.println(purchase);
		
		//==> API 확인
		
		Assert.assertEquals("user03", purchase.getBuyer().getUserId());
		
	}
	
	//@Test
	public void testUpdatePurchase() throws Exception{
		Purchase purchase = new Purchase();
		
		
		//3. updatePurchase Test  :: 
		purchase.setReceiverName("홍길동");
		purchase.setReceiverPhone("000-111-2222");
		purchase.setDivyAddr("배송주소");
		purchase.setDivyRequest("빠른배송");
		// purchase.setDivyDate(new Date(20170420));
		purchase.setTranNo(10023);
		
		System.out.println(":: 3. update(UPDATE)  ? ");
		System.out.println(":: "+ purchaseService.updatePurchase(purchase));
		System.out.println("\n");
		
		
		purchase = purchaseService.getPurchase(10023);
		Assert.assertNotNull(purchase);
		
		//==> console 확인
		System.out.println(purchase);
	 }
	
	//@Test
	public void testUpdateTranCode() throws Exception{
		Purchase purchase = new Purchase();
		
		
		//3. updatePurchase Test  :: 
		purchase.setTranCode("002");
		purchase.setTranNo(10023);
		
		System.out.println(":: 3. update(UPDATE)  ? ");
		System.out.println(":: "+ purchaseService.updateTranCode(purchase));
		System.out.println("\n");
		
		
		purchase = purchaseService.getPurchase(10023);
		Assert.assertNotNull(purchase);
		
		//==> console 확인
		System.out.println(purchase);
	 }

	 @Test
	 public void testGetPurchaseListAll() throws Exception {

			Search search = new Search();
			search.setCurrentPage(1);
			search.setPageSize(20);
			String buyerId = "user03";
			//String buyerId = null;
			
			Map<String,Object> map = purchaseService.getPurchaseList(search, buyerId);
			
			System.out.println("Client Test ::: map ==>>" + map);
					 
			List<Object> list = (List<Object>)map.get("list");
 	
		 	Assert.assertEquals(13, list.size());
		 	
			//==> console 확인
		 	System.out.println(list);
		 	
		 	Integer totalCount = (Integer)map.get("totalCount");
		 	System.out.println(totalCount);
		 	
		 	System.out.println("=======================================");
	  }
	 
	 @Test
	 public void testGetSaleList() throws Exception {

			Search search = new Search();
			search.setCurrentPage(1);
			search.setPageSize(20);
			String buyerId = null;
		
			Map<String,Object> map = purchaseService.getPurchaseList(search, buyerId);
			
			System.out.println("Client Test ::: map ==>>" + map);
					 
			List<Object> list = (List<Object>)map.get("list");
 	
		 	Assert.assertEquals(6, list.size());
		 	
			//==> console 확인
		 	System.out.println(list);
		 	
		 	Integer totalCount = (Integer)map.get("totalCount");
		 	System.out.println(totalCount);
		 	
		 	System.out.println("=======================================");
	  }
	 

  }
 