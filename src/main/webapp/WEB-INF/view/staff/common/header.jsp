<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">


<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.button-group a.btn-custom {
    width: 100px; /* 버튼의 고정 너비 설정 */
    margin-right: 10px; /* 버튼 간의 간격 */
    text-align: center; /* 텍스트 가운데 정렬 */
}

.button-group a.btn-custom:last-child {
    margin-right: 0; /* 마지막 버튼의 오른쪽 여백 제거 */
}




</style>

</head>
<body>
	<header class="bg-dark text-white py-3">
    <div class="container d-flex justify-content-between">
        <h1 class="h4">관리자 페이지</h1>
        <div class="d-flex align-items-center">
        <a href="${pageContext.request.contextPath}/staff/login#" class="btn btn-outline-light btn-sm btn-custom">home</a>
    <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-light btn-sm btn-custom">로그아웃</a>
        </div>
    </div>
</header>
</body>
</html>