package com.model2.mvc.service.product.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDAO;


@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDAO{
	
	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::" + getClass() +" .setSqlsession Call....");
		this.sqlSession = sqlSession;
	}

	//Constructor
	public ProductDaoImpl() {
		System.out.println("::" + getClass() +" default Construcor call....");
	}
	
	//Method
	public int addProduct(Product product) throws Exception {
		System.out.println("ProductDaoImpl Product ===>>>>"  + product);
		return sqlSession.insert("ProductMapper.addProduct",product);		
	}

	public Product getProduct(int prodNo) throws Exception {
		return sqlSession.selectOne("ProductMapper.getProduct",prodNo);
	}
	
	public List<Product> getProductList(Search search) throws Exception {
		
		for(Object p : sqlSession.selectList("ProductMapper.getProductList",search)){
			System.out.println((Product)p);
		}
		return (sqlSession.selectList("ProductMapper.getProductList",search));
	}

	public int  updateProduct(Product product) throws Exception {
		return sqlSession.update("ProductMapper.updateProduct", product);
	}
	
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("ProductMapper.getTotalCount",search);
	}
	
}