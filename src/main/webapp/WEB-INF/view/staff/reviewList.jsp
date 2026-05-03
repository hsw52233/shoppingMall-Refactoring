<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>
    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="/assets/favicon.ico">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom Styles -->
    <style>
body {
	font-family: 'Arial', sans-serif;
}

.sidebar {
	background-color: #f8f9fa;
	padding: 20px;
	border-right: 1px solid #ddd;
}

.sidebar .nav-link {
	font-size: 16px;
	color: #343a40;
}

.sidebar .nav-link.active {
	font-weight: bold;
}

.profile-info {
	margin-bottom: 30px;
}

.order-table th, .order-table td {
	text-align: center;
}

.container {
	display: flex; /* Flexbox 사용 */
	gap: 10px; /* 요소 간 간격 */
}

.sidebar {
	width: 250px; /* 사이드바 너비 */
}

.main-content {
	flex-grow: 1; /* 나머지 공간을 차지 */
}
</style>
</head>
<body >
 <header class="bg-dark text-white py-3">
    <div class="container d-flex justify-content-between">
        <h1 class="h4">리뷰 리스트</h1>
        <div class="d-flex align-items-center">
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-light btn-sm">로그아웃</a>
        </div>
    </div>
</header>
   
      <div class="container-fluid p-3">
    <div class="row">
        <!-- Sidebar -->
        <div class="col-md-3">
            <div class="sidebar">
                
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="${pageContext.request.contextPath}/staff/profile">${loginStaff.staffId}님</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/staff/goodsList">상품 리스트</a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/staff/categoryList">카테고리 리스트</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/staff/customerList">회원 리스트</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/staff/reviewList">리뷰 관리 리스트</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/staff/staffList">스태프 리스트</a>
                    </li>
                </ul>
            </div>
        </div>

        <!-- Main Content -->
        <div class="col-md-9">
           
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ordersNo</th>
                        <th>boardContent</th>
                        <th>updateDate</th>
                        <th>createDate</th>  
                        <th>리뷰 삭제</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="s" items="${reviewList}">
                        <tr>
                            <td>${s.ordersNo}</td>
                            <td>${s.boardContent}</td>
                            <td>${s.updateDate}</td>
                            <td>${s.createDate}</td>
                            <td><a href="${pageContext.request.contextPath}/staff/removeReview?ordersNo=${s.ordersNo}" class="btn btn-outline-primary">리뷰 삭제</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp" %>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


