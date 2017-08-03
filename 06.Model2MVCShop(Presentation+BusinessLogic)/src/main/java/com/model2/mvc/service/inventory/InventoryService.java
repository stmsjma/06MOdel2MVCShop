package com.model2.mvc.service.inventory;

import java.util.List;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Inventory;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;

public interface InventoryService {
	
	public int addInventory(Inventory inventory) throws Exception;
	
	public int updateInventory(Inventory inventory) throws Exception;

	public Inventory getInventory(int inventoryNo) throws Exception;
	
	public Map<String, Object> extractInventory(Search search, Inventory inventory) throws Exception;

	public Map<String, Object> getInventoryList(Search search) throws Exception;
	
	public int getTotalCount(int inventoryNo) throws Exception;
	
}

