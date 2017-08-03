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
public class PurchaseServiceTest {

	//==>@RunWith,@ContextConfiguration �̿� Wiring, Test �� instance DI
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

		purchase.setDivyAddr("����� ������ ���ﵿ 111");
		purchase.setDivyDate("20170220");
		purchase.setDivyRequest("���� ��� �ٶ��ϴ�.");
		purchase.setOrderDate(new Date(20100220));
		purchase.setPaymentOption("001");
		purchase.setPurchaseProd(purchaseProd);
		purchase.setReceiverName("��å");
		purchase.setReceiverPhone("010-444-6666");
		purchase.setTranCode("002");
		
		purchaseService.addPurchase(purchase);
		
		//==> console Ȯ��
		System.out.println(purchase);
		}
	
	//@Test
	public void testGetPurchase() throws Exception {
		
		Purchase purchase = new Purchase();
	
		System.out.println(":: 2. getPurchase(SELECT)  ? ");
		purchase = purchaseService.getPurchase(10023);
	
		System.out.println("\n");
		
		//==> console Ȯ��
		System.out.println(purchase);
		
		//==> API Ȯ��
		
		Assert.assertEquals("user03", purchase.getBuyer().getUserId());
		
	}
	
	//@Test
	public void testUpdatePurchase() throws Exception{
		Purchase purchase = new Purchase();
		
		
		//3. updatePurchase Test  :: 
		purchase.setReceiverName("ȫ�浿");
		purchase.setReceiverPhone("000-111-2222");
		purchase.setDivyAddr("����ּ�");
		purchase.setDivyRequest("�������");
		// purchase.setDivyDate(new Date(20170420));
		purchase.setTranNo(10023);
		
		System.out.println(":: 3. update(UPDATE)  ? ");
		System.out.println(":: "+ purchaseService.updatePurchase(purchase));
		System.out.println("\n");
		
		
		purchase = purchaseService.getPurchase(10023);
		Assert.assertNotNull(purchase);
		
		//==> console Ȯ��
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
		
		//==> console Ȯ��
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
		 	
			//==> console Ȯ��
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
		 	
			//==> console Ȯ��
		 	System.out.println(list);
		 	
		 	Integer totalCount = (Integer)map.get("totalCount");
		 	System.out.println(totalCount);
		 	
		 	System.out.println("=======================================");
	  }
	 

  }
 