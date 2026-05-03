<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>My Page</title>
         <!-- Bootstrap core JS-->
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" />
        <style>
            /* Flexbox layout for the main content area */
            .main-content {
                display: flex;
                justify-content: space-between;
                margin-top: 20px;
            }
            /* Left Sidebar */
            .sidebar {
                width: 300px;
                background-color: #f8f9fa;
                padding-top: 20px;
                border-right: 1px solid #ddd;
                margin-right: 20px;
            }
            .sidebar .list-group-item {
                cursor: pointer;
            }
            .sidebar .list-group-item:hover {
                background-color: #f1f1f1;
            }
            /* Main product area */
            .product-area {
                flex-grow: 1;
                padding: 20px;
            }
            /* Search form styling */
            .search-form .row {
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-90 px-lg-4">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/common/home">Shop</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/common/home">Home</a></li>
                        <c:if test="${sessionScope.customerMail !=null }">
	                        <li class="nav-item">
	                         	<a class="nav-link" href="${pageContext.request.contextPath}/common/logout">Logout</a>
	                        </li>
                        </c:if>
                        <c:if test="${sessionScope.customerMail ==null }">
	                        <li class="nav-item">
	                        	<a class="nav-link" href="${pageContext.request.contextPath}/common/login">Login</a>
	                        </li>
                        </c:if>
                    </ul>
                    <div>
                    <form class="d-flex mb-2 mb-lg-0 ms-lg-2" action="${pageContext.request.contextPath}/customer/customerOne">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi bi-person-circle me-1"></i>
                            MyPage
                            <span class="badge bg-dark text-white ms-1 rounded-pill"></span>
                        </button>
                    </form>
                    </div>
                    <form class="d-flex mb-2 mb-lg-0 ms-lg-2" action="${pageContext.request.contextPath}/customer/ordersList">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill"></span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        <%@ include file="inc/header.jsp" %>
    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-md-3 mt-3" >
	            <!-- Left Sidebar: Category list -->
	            <div class="sidebar">
	                <div class="list-group">
	                    <h4 class="list-group-item active bg-dark">마이 페이지</h4>
	                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="${pageContext.request.contextPath}/customer/customerOne">회원 정보</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/customer/addressList">배송지 목록</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/customer/ordersList">주문 상세 내역</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/customer/cartList?customerMail=${customerMail}">장바구니</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/customer/reviewsList?customerMail=${customerMail}">리뷰 목록</a>
                        </li>
                    </ul>
	                </div>
	            </div>
            </div>
            <!-- Main Content -->
 			<div class="col-md-6 mt-3"  style= "margin-bottom: 150px;">
 			
				<table class="table">
					<tr>
						<td>paymentNo</td>
						<td>ordersNo</td>
						<td>goodsNo</td>
						<td>goodsFileName.goodsFileExt</td>
						<td>goodsTitle</td>
						<td>goodsMemo</td>
						<td>ordersAmount</td>
						<td>totalPrice</td>
						<td>후기 작성</td>
					</tr>
					<c:forEach items="${deliveryList}" var="d">
						<tr>
							<td>${d.paymentNo}</td>
							<td>${d.ordersNo}</td>
							<td>${d.goodsNo}</td>
							<td><img src="${pageContext.request.contextPath}/upload/${d.goodsFileName}.${d.goodsFileExt}" width="100" height="100"></td>
							<td>${d.goodsTitle}</td>
							<td>${d.goodsMemo}</td>
							<td>${d.ordersAmount}</td>
							<td>${d.totalPrice}</td>
							<td>
								<c:if test="${d.paymentState == '배송완료'}">
									<a href="${pageContext.request.contextPath}/customer/reviews?ordersNo=${d.ordersNo}&paymentNo=${d.paymentNo}">후기 작성</a>				
								</c:if>
							
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
				<hr>
    <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; GD 86Website 2024</p></div>
        </footer>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>