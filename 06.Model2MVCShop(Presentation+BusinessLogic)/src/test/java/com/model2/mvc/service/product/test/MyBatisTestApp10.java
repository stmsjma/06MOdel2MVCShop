package com.model2.mvc.service.product.test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

/*
 * FileName : MyBatisTestApp101.java
  */
public class MyBatisTestApp10 {
	
	///main method
	public static void main(String[] args) throws Exception{
	
		//==> SqlSessionFactoryBean.getSqlSession()�� �̿� SqlSession instance GET
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		
		System.out.println("\n");
		
		
		Product product = new Product("imafile","20030202",20000,"�˶���","�ڵ���",10020,new Date(20160202),"001",3,"001");
				
				
		//1. ProductMapper10.addUser Test  :: users table age/grade/redDate �Է°� Ȯ���Ұ� : OK 
		//System.out.println(":: 1. addProduct(INSERT)  ? ");
		//System.out.println(":: "+ sqlSession.insert("ProductMapper10.addProduct",product));
		//System.out.println("\n");
		
		/*
		//2. ProductMapper10.getProduct Test :: �ָ� inert Ȯ�� 
		System.out.println(":: 2. getProduct(SELECT)  ? ");
		System.out.println(":: "+sqlSession.selectOne("ProductMapper10.getProduct",product.getProdNo()));
		System.out.println("\n");
		
		
		//3. ProductMapper10.updateProduct Test  :: product table prod_name/prod_quanity/redDate �Է°� Ȯ���Ұ� : OK
		//                                                    :: �ڵ��� ==> �߰��ڵ��� ����
		product.setProdName("�߰��ڵ���");
		product.setQuanity(2);
		product.setPrice(30000);
		System.out.println(":: 3. update(UPDATE)  ? ");
		System.out.println(":: "+ sqlSession.update("ProductMapper10.updateProduct",product));
		System.out.println("\n");
		
		
		//4. UserMapper10.getProductList Test  :: Dynamic Query Ȯ�� id=user04/name=�´� �˻�
		System.out.println(":: 4. getProduct(SELECT)  ? ");
		System.out.println(":: "+sqlSession.selectOne("ProductMapper10.getProduct",product.getProdNo()));
		System.out.println("\n");
		
		/*
		//5. UserMapper10.removeUser Test
		System.out.println(":: 5. Use10.removeUser (DELETE)  ? ");
		System.out.println(":: "+sqlSession.delete("UserMapper10.removeUser", 
																						   user.getUserId()) );
		System.out.println("\n");
		System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("\n");
		*/
		
		//==> Test �� Search instance ���� 
		Search search = new Search();
		//ProductService productService = new ProductServiceImpl12();
		
		//search.setSearchCondition("0");
		search.setCurrentPage(1);
		search.setPageSize(3);
		// Map<String,Object> map = productService.getProductList(search);
	
		/* List<Object> list = (List<Object>)map.get("list");
		
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println("Product List ===>> " + list.get(i));
		}
		
		Integer totalCount = (Integer)map.get("totalCount");
		System.out.println(totalCount); */
		
		System.out.println("================================================");

		
		/*
		1. ProductMapper10.getProduct Test 
		System.out.println(":: 1. getProductList01(SELECT)  ? ");
		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper10.getProductList",search));
		*/
		
		/*
		3. UserMapper10.getUserList Test 
		search.setSearchCondition("userName");
		search.setUserName( new String[]{ "�̼���"} );
		*/
		
		System.out.println(":: 3. getUserList01(SELECT)  ? ");
		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper10.getProductList",search) );

		search.setSearchCondition("0");
		search.setSearchKeyword("1000");
		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper10.getProductList",search) );

		
		
			//END::SqlSession  close
		System.out.println("::END::SqlSession �ݱ�.."); 
		sqlSession.close();
		
	}//end of main
}//end of classSqlSessionFactoryBean.java