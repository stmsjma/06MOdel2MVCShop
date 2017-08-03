<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- EL / JSTL 
<%@ page import="com.model2.mvc.service.domain.*" %>
<%@ page import="com.model2.mvc.common.Search" %>
<%@page import="com.model2.mvc.common.Page"%>
<%@page import="com.model2.mvc.common.util.CommonUtil"%>
<%
	Purchase purchase = (Purchase)request.getAttribute("purchase");

	System.out.println("purhase contents :: "+ purchase);
	Product product = (Product)purchase.getPurchaseProd();
	System.out.println("product contents :: "+ product);
	User user = (User)purchase.getBuyer();
	System.out.println("user contents :: "+ user);

%>
--%>

<html>
<head>
<title>구매 등록</title>
</head>

<body>

<form name="updatePurchase" action="/updatePurchaseView.do?tranNo=${purchase.tranNo}" method="post">

다음과 같이 구매가 되었습니다.

<table border=1>
	<tr>
		<td>물품번호</td>
		<td>${product.prodNo}</td>
		<td></td>
	</tr>
	<tr>
		<td>상품명</td>
		<td>${product.prodName}</td>
		<td></td>
	</tr>
	<tr>
		<td>상품수량</td>
		<td>${product.quanity}</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자아이디</td>
		<td>${user.userId}</td>
		<td></td>
	</tr>
	<tr>
		<td>구매방법</td>
		<td>
			${purchase.paymentOption}
		</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자이름</td>
		<td>${purchase.receiverName}</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자연락처</td>
		<td>${purchase.receiverPhone}</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자주소</td>
		<td>${purchase.divyAddr}</td>
		<td></td>
	</tr>
		<tr>
		<td>구매요청사항</td>
		<td>${purchase.divyRequest}</td>
		<td></td>
	</tr>
	<tr>
		<td>배송희망일자</td>
		<td>${purchase.divyDate}</td>
		<td></td>
	</tr>
</table>
</form>

</body>
</html>
