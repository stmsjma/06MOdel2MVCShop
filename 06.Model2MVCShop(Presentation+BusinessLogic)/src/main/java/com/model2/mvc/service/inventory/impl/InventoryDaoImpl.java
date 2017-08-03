package com.model2.mvc.service.inventory.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Inventory;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.inventory.InventoryDAO;
import com.model2.mvc.service.purchase.PurchaseDAO;


@Repository("inventoryDaoImpl")
public class InventoryDaoImpl implements InventoryDAO{
	
	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	Map<String , Object>  map = new HashMap<String, Object>();
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::" + getClass() +" .setSqlsession Call....");
		this.sqlSession = sqlSession;
	}

	//Constructor
	public InventoryDaoImpl() {
		System.out.println("::" + getClass() +" default Construcor call....");
	}
	
	
	//Method
	public int addInventory(Inventory inventory) throws Exception {
		
		System.out.println("inventoryDaoImpl ==>> Inventory :: "  + inventory);
		
		return sqlSession.insert("InventoryMapper.addInventory",inventory);		
	}

	public Inventory getInventory(int inventoryNo) throws Exception {
		
		System.out.println(" InventoryDaoImpl 22222 inventoryNo ==>> " + inventoryNo);
		System.out.println(" InventoryDaoImpl 22222 getInventory ==>>" + sqlSession.selectOne("InventoryMapper.getInventory",inventoryNo));
		
		return sqlSession.selectOne("InventoryMapper.getInventory",inventoryNo);
	}
	
	public Map<String, Object>  getInventoryList(Search search) throws Exception {
		Map<String , Object>  map = new HashMap<String, Object>();
		
		System.out.println("InventoryDaoImpl search ::" + search);
		
		
		List<Inventory> list = sqlSession.selectList("InventoryMapper.getInventoryList", search); 
		
		System.out.println("InventoryDaoImpl list :: " + list );
		System.out.println("InventoryDaoImpl list size :: " + list.size());
					
		map.put("totalCount", sqlSession.selectOne("InventoryMapper.getTotalCount", map));
		
		System.out.println("map :: totalCount " + map);
		
		map.put("list", list);
				
		System.out.println("InventoryDaoImpl list final :: " + list );
			
		return map;
	}


	public Map<String, Object> extractInventory(Search search, Inventory inventory) throws Exception {
		Map<String , Object>  map = new HashMap<String, Object>();
		
		map.put("search", search);
		map.put("inventory", inventory);
		
		System.out.println("InventoryDaoImpl search ::"  + search);
		System.out.println("InventoryDaoImpl inventory ::"  + inventory);
		
		List<Inventory> list = sqlSession.selectList("InventoryMapper.extractInventory", map); 
		
		System.out.println("InventoryDaoImpl list :: " + list );
		System.out.println("InventoryDaoImpl list size :: " + list.size());
		
					
		map.put("totalCount", sqlSession.selectOne("InventoryMapper.getTotalCount",map));
		
		System.out.println("map :: totalCount " + map);
		
		map.put("list", list);
		
		
		System.out.println("InventoryDaoImpl list final :: " + list );
		
		
		return map;
	}
	
	public int  updateInventory(Inventory inventory) throws Exception {
		return sqlSession.update("InventoryMapper.updateInventory", inventory);
	}

	
	public int getTotalCount(int inventoryNo) throws Exception {
		return sqlSession.selectOne("InventoryMapper.getTotalCount",inventoryNo);
	}
	
		
}