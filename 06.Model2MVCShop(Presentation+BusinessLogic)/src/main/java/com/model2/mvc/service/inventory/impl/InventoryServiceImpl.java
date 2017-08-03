package com.model2.mvc.service.inventory.impl;

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
import com.model2.mvc.service.domain.Inventory;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.inventory.InventoryDAO;
import com.model2.mvc.service.inventory.InventoryService;
import com.model2.mvc.service.purchase.PurchaseDAO;
import com.model2.mvc.service.purchase.PurchaseService;


@Service("inventoryServiceImpl")
public class InventoryServiceImpl implements InventoryService{
	
	///Field
	@Autowired
	@Qualifier("inventoryDaoImpl")
	
	private InventoryDAO inventoryDao;
	private SqlSession sqlSession;
	
	public void setInventoryDao(InventoryDAO inventoryDAO) {
		this.inventoryDao = inventoryDao;
	}
	
	///Constructor
	public InventoryServiceImpl() {
		System.out.println(this.getClass());
	}

	///Method
	public int addInventory(Inventory inventory) throws Exception {
		return inventoryDao.addInventory(inventory);
	}
	
	public Inventory getInventory(int inventoryNo) throws Exception {
		return inventoryDao.getInventory(inventoryNo);
	}

	public Map<String, Object> getInventoryList(Search search ) throws Exception{
		return  (Map<String, Object>)   inventoryDao.getInventoryList(search);
	}

	public Map<String, Object> extractInventory(Search search, Inventory inventory) throws Exception {
		return  (Map<String, Object>)  inventoryDao.extractInventory(search, inventory);
	}
	

	public int updateInventory(Inventory inventory) throws Exception {
		return inventoryDao.updateInventory(inventory);
	}
	
		
	public int getTotalCount(int inventoryNo) throws Exception {
		return inventoryDao.getTotalCount(inventoryNo);
	}
	

		
}
	