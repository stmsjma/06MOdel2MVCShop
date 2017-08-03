
package com.model2.mvc.service.purchase.test;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;

/*
 *	FileName :  UserServiceTest.java
 * �� JUnit4 (Test Framework) �� Spring Framework ���� Test( Unit Test)
 * �� Spring �� JUnit 4�� ���� ���� Ŭ������ ���� ������ ��� ���� �׽�Ʈ �ڵ带 �ۼ� �� �� �ִ�.
 * �� @RunWith : Meta-data �� ���� wiring(����,DI) �� ��ü ����ü ����
 * �� @ContextConfiguration : Meta-data location ����
 * �� @Test : �׽�Ʈ ���� �ҽ� ����
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:config/commonservice14.xml" })
public class PurchaseServiceTestYN{
	
	///main method
	public static void main(String[] args) throws Exception{

		ApplicationContext context =
			new ClassPathXmlApplicationContext(
																new String[] {	"/config/commonservice.xml" }
								                                  );
		System.out.println("\n");

		//==> Bean/IoC Container �� ���� ȹ���� UserService �ν��Ͻ� ȹ��
		PurchaseService purchaseService = (PurchaseService)context.getBean("purchaseServiceImpl");
		
		System.out.println("\n");
		
		//==> Test �� User instance ����  
		Purchase purchase = new Purchase();
		User user = new User();
		user.setUserId("user07");
		Product product = new Product();
		product.setProdNo(10020);
		purchase.setTranNo(0);
		purchase.setBuyer(user);
		purchase.setPurchaseProd(product);
			

		//1. addUser Test  
		System.out.println(":: 1. addPurchase(INSERT)  ? ");
		System.out.println("::"+purchaseService.addPurchase(purchase) ); 
		System.out.println("\n");
		
		//2. getPurcahse Test
		int tranNo = 10050;
		System.out.println(":: 2. getPurchase(SELECT)  ? ");
		System.out.println(":: "+ purchaseService.getPurchase(tranNo) );
		System.out.println("\n");

		
		//3. updatePurchase Test
		System.out.println(":: 3. updatePurchase(UPDATE)  ? ");
		purchase.setReceiverName("���");
		purchase.setTranNo(10023);
		System.out.println("show me product name =>"+purchase.getReceiverName());
		System.out.println(":: "+ purchaseService.updatePurchase(purchase));
		System.out.println("\n");
/*
		//4. getPurchaseList Test ::
		System.out.println(":: 4. getPurchasetList(SELECT)  ? ");
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);		
		
		System.out.println(":: 6. getPurchaseList(SELECT)  ? ");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("search", search);
		map2.put("buyerId", purchase.getBuyer().getUserId());
		System.out.println("List<Product> ���� : "+  purchaseService.getPurchaseList(search, purchase.getBuyer().getUserId()));
		System.out.println("\n");

		((ClassPathXmlApplicationContext) context).close();
		System.out.println(":: context close ::");
*/	
	}//end of main
}//end of class