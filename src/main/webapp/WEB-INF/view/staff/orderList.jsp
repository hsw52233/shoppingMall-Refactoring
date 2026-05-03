<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>배송 상태</h1>
	<table class="table table-bordered">
		<tr>
			<td>paymentNo</td>
			<td>addressNo</td>
			<td>paymentPrice</td>
			<td>paymentMethod</td>
			<td>addressDetail</td>
			<td>paymentState</td>
			<td>상품목록</td>
		</tr>
		<c:forEach items="${orderList}" var="o">
			<tr>
				<td>${o.paymentNo}</td>
				<td>${o.addressNo}</td>
				<td>${o.paymentPrice}</td>
				<td>${o.paymentMethod}</td>
				<td>${o.addressDetail}</td>
				<td>
					<c:if test="${o.paymentState == '배송중' }">
					<a href="${pageContext.request.contextPath}/staff/paymentComplete?paymentNo=${o.paymentNo}">
						${o.paymentState}<!-- 배송중일때 배송완료로 바꾸면서 페이지 이동 -->
					</a>
					</c:if>
					<c:if test="${o.paymentState == '결제완료' || o.paymentState == '배송완료'}">
						${o.paymentState}
					</c:if>
				</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>