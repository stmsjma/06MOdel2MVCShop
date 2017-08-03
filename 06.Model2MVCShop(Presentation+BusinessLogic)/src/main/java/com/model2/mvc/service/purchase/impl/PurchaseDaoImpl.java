package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDAO;


@Repository("purchaseDaoImpl")
public class PurchaseDaoImpl implements PurchaseDAO{
	
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
	public PurchaseDaoImpl() {
		System.out.println("::" + getClass() +" default Construcor call....");
	}
	
	//Method
	public int addPurchase(Purchase purchase) throws Exception {
		
		
		
		return sqlSession.insert("PurchaseMapper.addPurchase",purchase);		
	}

	public Purchase getPurchase(int tranNo) throws Exception {
		
		System.out.println(" PurchaseDaoImpl 22222 tranNo ==>> " + tranNo);
		System.out.println(" PurchaseDaoImpl 22222 getPurchase ==>>" + sqlSession.selectOne("PurchaseMapper.getPurchase",tranNo));
		
		return sqlSession.selectOne("PurchaseMapper.getPurchase",tranNo);
	}
	
	public Map<String, Object>  getPurchaseList(Search search,String buyerId) throws Exception {
		Map<String , Object>  map = new HashMap<String, Object>();
		
		
		System.out.println("PurchaseServieDAo 333333====>");
		System.out.println("Search ==>> " + search);
		System.out.println("BuyerId ===>" + buyerId);
			
		map.put("search", search);
		map.put("buyerId", buyerId);
		
		System.out.println("PurchaseServiceImpl map :: " + map);
				
		List<Purchase> list = sqlSession.selectList("PurchaseMapper.getPurchaseList", map); 
		
		System.out.println("PurchaseServiceImpl list :: " + list );
		System.out.println("PurchaseServiceImpl list size :: " + list.size());
		
		
		//for (int i = 0; i < list.size(); i++) {
			//System.out.println("list.get(i)  ==>>"  + list.get(i));	
			//list.get(i).setBuyer(sqlSession.selectOne("UserMapper.getUser", list.get(i).getBuyer().getUserId()));
			//System.out.println("setBuyer execution ==>>> ");
			//list.get(i).setPurchaseProd(sqlSession.selectOne("ProductMapper.getProduct", list.get(i).getPurchaseProd().getProdNo()));
				
		//}
			
		map.put("totalCount", sqlSession.selectOne("PurchaseMapper.getTotalCount", map));
		
		System.out.println("map :: totalCount " + map);
		
		map.put("list", list);
		
		
		System.out.println("PurchaseServiceImpl list final :: " + list );
		
		
		return map;
	}

	public Map<String, Object> getSaleList(Search search,String buyerId) throws Exception {
		Map<String , Object>  map = new HashMap<String, Object>();
		
		System.out.println("Search ==>> " + search);
		System.out.println("BuyerId ===>" + buyerId);
			
		map.put("search", search);
		map.put("buyerId", buyerId);
		
		System.out.println("PurchaseServiceImpl map :: " + map);
				
		List<Purchase> list = sqlSession.selectList("PurchaseMapper.getSaleList", map); 
		
		System.out.println("PurchaseServiceImpl list :: " + list );
		System.out.println("PurchaseServiceImpl list size :: " + list.size());
		
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list.get(i)  ==>>"  + list.get(i));	
			list.get(i).setBuyer(sqlSession.selectOne("UserMapper.getUser", list.get(i).getBuyer().getUserId()));
			System.out.println("setBuyer execution ==>>> ");
			list.get(i).setPurchaseProd(sqlSession.selectOne("ProductMapper.getProduct", list.get(i).getPurchaseProd().getProdNo()));
				
		}
			
		map.put("totalCount", sqlSession.selectOne("PurchaseMapper.getTotalCount", buyerId));
		
		System.out.println("map :: totalCount " + map);
		
		map.put("list", list);
		
		
		System.out.println("PurchaseServiceImpl list final :: " + list );
		
		
		return map;
	}
	
	public int  updatePurchase(Purchase purchase) throws Exception {
		return sqlSession.update("PurchaseMapper.updatePurchase", purchase);
	}
	
	public int  updateTranCode(Purchase purchase) throws Exception {
		return sqlSession.update("PurchaseMapper.updateTranCode", purchase);
	}
	
	public int getTotalCount(String buyerId) throws Exception {
		return sqlSession.selectOne("PurchaseMapper.getTotalCount",buyerId);
	}
	
		
}