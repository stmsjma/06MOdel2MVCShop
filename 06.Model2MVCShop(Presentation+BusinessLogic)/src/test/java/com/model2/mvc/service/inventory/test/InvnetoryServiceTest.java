package com.model2.mvc.service.inventory.test;

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
import com.model2.mvc.service.domain.Inventory;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.domain.Warehouse;
import com.model2.mvc.service.inventory.InventoryService;
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
public class InvnetoryServiceTest {

	//==>@RunWith,@ContextConfiguration �̿� Wiring, Test �� instance DI
	@Autowired
	@Qualifier("inventoryServiceImpl")
	private InventoryService inventoryService;

	//@Test
	public void testAddInventory() throws Exception {
	
		Inventory inventory = new Inventory();
		Product product = new Product();
		product.setProdNo(10030);
		product.setProdName("��ǳ��");
		inventory.setProduct(product);
		Warehouse wareHouse = new Warehouse();
		wareHouse.setWarehouse_code("001");
		inventory.setWareHouse(wareHouse);
		inventory.setInQuanity(3);
		inventory.setOutQuanity(1);
		inventory.setInventoryQuanity(2);

		inventoryService.addInventory(inventory);
				
		//==> console Ȯ��
		System.out.println(inventory);
		}
	
	//@Test
	public void testGetInventory() throws Exception {
		
		Inventory inventory = new Inventory();
	
		System.out.println(":: 2. getInventory(SELECT)  ? ");
		inventory = inventoryService.getInventory(10024);
	
		System.out.println("\n");
		
		//==> console Ȯ��
		System.out.println(inventory);
		
		//==> API Ȯ��
		
		Assert.assertEquals("MS���콺", inventory.getProduct().getProdName());
		
	}
	
	// @Test
	public void testUpdateInventory() throws Exception{
		Inventory inventory = new Inventory();
		Product product = new Product();
		product.setProdNo(10030);
		inventory.setProduct(product);
		
		//3. updateInventory Test  :: 
		inventory.setOutQuanity(1);
		inventory.setInventoryQuanity(2);
		
		
		System.out.println(":: 3. update(UPDATE)  ? ");
		System.out.println(":: "+ inventoryService.updateInventory(inventory));
		System.out.println("\n");
		
		
		inventory = inventoryService.getInventory(10024);
		Assert.assertNotNull(inventory);
		
		//==> console Ȯ��
		System.out.println(inventory);
	 }
	
	 //@Test
	 public void testGetInventoryListAll() throws Exception {

			Search search = new Search();
			search.setCurrentPage(1);
			search.setPageSize(20);
			
			Map<String,Object> map  = inventoryService.getInventoryList(search);
			
			System.out.println("Client Test ::: map ==>>" + map);
			
			
			List<Object> list = (List<Object>)map.get("list");
	
		 	Assert.assertEquals(3, list.size());
		 	
			//==> console Ȯ��
		 	System.out.println(list);
		 	
		 	Integer totalCount = (Integer)map.get("totalCount");
		 	System.out.println(totalCount);
		 	
		 	System.out.println("=======================================");
	  }
	 
		 
	 @Test
	 public void testExtractInventory() throws Exception {

			Search search = new Search();
			search.setCurrentPage(1);
			search.setPageSize(3);
			Product product = new Product();
			product.setProdNo(10030);
			Inventory inventory = new Inventory();
			inventory.setProduct(product);
					
		
			Map<String,Object> map = inventoryService.extractInventory(search,inventory);
			
			System.out.println("Client Test ::: map ==>>" + map);
					 
			List<Object> list = (List<Object>)map.get("list");
			System.out.println("Client Test ::: list ==>>" + list);
 	
		 	Assert.assertEquals(1, list.size());
		 	
			//==> console Ȯ��
		 	System.out.println(list);
		 	
		 	Integer totalCount = (Integer)map.get("totalCount");
		 	System.out.println(totalCount);
		 	
		 	System.out.println("=======================================");
	  }
	 
 
  }
 