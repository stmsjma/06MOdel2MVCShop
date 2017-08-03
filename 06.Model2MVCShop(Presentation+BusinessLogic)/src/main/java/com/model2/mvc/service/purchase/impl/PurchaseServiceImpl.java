package com.model2.mvc.service.purchase.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDAO;
import com.model2.mvc.service.purchase.PurchaseService;


@Service("purchaseServiceImpl")
public class PurchaseServiceImpl implements PurchaseService{
	
	///Field
	@Autowired
	@Qualifier("purchaseDaoImpl")
	
	private PurchaseDAO purchaseDao;
	private SqlSession sqlSession;
	
	public void setPurchaseDao(PurchaseDAO purchaseDao) {
		this.purchaseDao = purchaseDao;
	}
	
	///Constructor
	public PurchaseServiceImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public int addPurchase(Purchase purchase) throws Exception {
		purchase.setTranCode("002");
		
		return purchaseDao.addPurchase(purchase);
	}
	
	public Purchase getPurchase(int tranNo) throws Exception {
		System.out.println("PurchaseServiceImpl 00000===>>");
		System.out.println("PurchaseServiceImpl 11111===>>" + purchaseDao.getPurchase(tranNo));
		return purchaseDao.getPurchase(tranNo);
	}

	public Map<String, Object> getPurchaseList(Search search,String buyerId ) throws Exception{
		
		System.out.println("PurchaseServiceImpl Started 111111 ::::");
		System.out.println("PurchaseServiceImpl 22222===>>" + purchaseDao.getPurchaseList(search,buyerId));
		System.out.println("PurchaseSEervieImpl 44444====>");
		System.out.println(" +++" + purchaseDao.getPurchaseList(search,buyerId));
		return  (Map<String, Object>)  purchaseDao.getPurchaseList(search,buyerId);
	}

	public Map<String,Object> getSaleList(Search search,String buyerId) throws Exception {
		
		System.out.println("Search ::" + search);
		
		return  (Map<String, Object>)  purchaseDao.getSaleList(search,buyerId);
	}
	
	public int updatePurchase(Purchase purchase) throws Exception {
		return purchaseDao.updatePurchase(purchase);
	}
	
	public int updateTranCode(Purchase purchase) throws Exception {
		return purchaseDao.updateTranCode(purchase);
	}
	
	
	public int getTotalCount(String buyerId) throws Exception {
		return purchaseDao.getTotalCount(buyerId);
	}
	

		
}
	