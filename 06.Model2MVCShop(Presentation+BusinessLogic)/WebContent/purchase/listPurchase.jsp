<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <%--  EL/JSTL Replace
<%@ page import="java.util.*"  %>
<%@ page import="com.model2.mvc.service.domain.*" %>
<%@ page import="com.model2.mvc.common.Search" %>
<%@page import="com.model2.mvc.common.Page"%>
<%@page import="com.model2.mvc.common.util.CommonUtil"%> 
--%>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>구매 목록조회</title>

<%--  EL/JSTL Replace
<%
	List<Purchase> list= (List<Purchase>)request.getAttribute("list");
	Page resultPage=(Page)request.getAttribute("resultPage");
	
		
	Search search = (Search)request.getAttribute("search");
	//==> null 을 ""(nullString)으로 변경
	String searchCondition = CommonUtil.null2str(search.getSearchCondition());
	String searchKeyword = CommonUtil.null2str(search.getSearchKeyword());
%>
--%>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script type="text/javascript">

	function fncGetPageList(currentPage) {
	document.getElementById("currentPage").value = currentPage;
   	document.detailForm.submit();		
}
	
</script>
</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width: 98%; margin-left: 10px;">

<form name="detailForm" action="/listPurchase.do" method="post">

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"width="15" height="37"></td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left: 10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">구매 목록조회</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37"><img src="/images/ct_ttl_img03.gif"	width="12" height="37"></td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top: 10px;">
	<tr>
		<td colspan="11">전체 ${resultPage.totalCount} 건수, 현재 ${resultPage.currentPage} 페이지 > </td>
		
	</tr>
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">회원ID</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">상품명</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="100">주문수량</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">주문날짜</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">배송주소</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">배송현황</td>
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>

<%--  EL/JSTL Replace	
	<%
	    System.out.println("JSP Execute ===>>>>" );
		int no=list.size();
		System.out.println("list size ===>>>>" + no);
		for(int i=0; i<list.size(); i++) {
		Purchase purchase = (Purchase)list.get(i);
		System.out.println("buyer ===>>>>" + purchase.getBuyer());
	%> 
--%>
	
	<c:set var="i" value="0" />
		<c:forEach var="purchase" items="${list}">
			<c:set var="i" value="${ i+1 }" />
	
	<tr class="ct_list_pop">
		<td align="center">
			<a href="/getPurchase.do?tranNo=${purchase.tranNo}">${ i } </a>
		</td>
		<td></td>
		<td align="left">
			<a href="/getUser.do?userId=${purchase.buyer.userId}">${purchase.buyer.userId}</a>
		</td>
		<td></td>
		<td align="left">${purchase.purchaseProd.prodName}</td>
		<td></td>
		<td align="left">${purchase.purchaseProd.quanity}</td>
		<td></td>
		<td align="left">${purchase.orderDate}</td>
		<td></td>
		<td align="left">${purchase.divyAddr}</td>
		<td></td>
		
				
		<c:if test="${purchase.tranCode == '002'}">
		<td align="left">현재구매완료상태입니다.</td>
		<td></td>		
		</c:if>
		
		<c:if test="${purchase.tranCode == '003'}">
		<td align="left">현재	 배송중 상태 입니다.</td>
		<td></td>
		<td align="left">
			
			<a href="/updateTranCode.do?tranNo=${purchase.tranNo}&tranCode=${purchase.tranCode}">물건도착</a>
			
		</td>
		</c:if>
		
		<c:if test="${purchase.purchaseProd.proTranCode == '004'}">
		<td align="left">현재 배송완료상태 입니다..</td>
		<td></td>		
		</c:if>
		

</c:forEach>
	
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 10px;">
	<tr>
		<td align="center">
		 
			<a href="/listPurchase.do? currentPage=${resultPage.currentPage}"></a> 
		
		</td>
	</tr>
</table>


<!-- PageNavigation Start... -->
<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top:10px;">
	<tr>
		<td align="center">
		   <input type="hidden" id="currentPage" name="currentPage" value=""/>
				<jsp:include page="../common/pageNavigator.jsp"/>	
	
    	</td>
	</tr>
</table>
<!-- PageNavigation End... -->

</form>

</div>

</body>
</html>