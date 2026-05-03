<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage</title>
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
                width: 400px;
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
                    <c:if test="${sessionScope.customerMail ==null }">
                    <form class="d-flex mb-2 mb-lg-0 ms-lg-2" action="${pageContext.request.contextPath}/common/login">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi bi-person-circle me-1"></i>
                            MyPage
                            <span class="badge bg-dark text-white ms-1 rounded-pill"></span>
                        </button>
                    </form>
                    </c:if>
                    <c:if test="${sessionScope.customerMail !=null }">
                    <form class="d-flex mb-2 mb-lg-0 ms-lg-2" action="${pageContext.request.contextPath}/customer/customerOne">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi bi-person-circle me-1"></i>
                            MyPage
                            <span class="badge bg-dark text-white ms-1 rounded-pill"></span>
                        </button>
                    </form>
                    </c:if>
                    <c:if test="${sessionScope.customerMail ==null }">
                    <form class="d-flex mb-2 mb-lg-0 ms-lg-2" action="${pageContext.request.contextPath}/common/login">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill"></span>
                        </button>
                    </form>
                    </c:if>
                    <c:if test="${sessionScope.customerMail !=null }">
                    <form class="d-flex mb-2 mb-lg-0 ms-lg-2" action="${pageContext.request.contextPath}/customer/ordersList">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill"></span>
                        </button>
                    </form>
                    </c:if>
                </div>
            </div>
        </nav>

        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">GDShop</h1>
                    <p class="lead fw-normal text-white-50 mb-0">Find the best products here!</p>
                </div>
            </div>
        </header>

        <!-- Main Content -->
        <div class="container main-content my-2">
            <!-- Left Sidebar: Category list -->
            <div class="sidebar">
                <div class="list-group =">
                    <h4 class="list-group-item active bg-dark">Categories</h4>
                    <c:forEach items="${categoryList}" var="category">
                        <a href="${pageContext.request.contextPath}/common/home?categoryNo=${category.categoryNo}" class="list-group-item list-group-item-action">
                            ${category.categoryTitle}
                        </a>
                    </c:forEach>
                </div>
            </div>

            <!-- Right Main Content: Product listings and Search -->
            <div class="product-area">
                <!-- Search Form -->
                <form id="formSearchTitle" action="${pageContext.request.contextPath}/common/home" class="mb-4 search-form">
                    <div class="row">
                        <div class="col-md-2">
                            <select id="categoryNo" name="categoryNo" class="form-select">
                                <option value="">:::전체:::</option>
                                <c:forEach items="${categoryList}" var="category">
                                    <option value="${category.categoryNo}">${category.categoryTitle}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-8">
                            <input type="text" name="searchTitle" id="searchTitle" value="${searchTitle}" class="form-control" placeholder="Search for products..." />
                        </div>
                        <div class="col-md-2">
                            <button id="btnSearchTitle" type="button" class="btn btn-primary w-100">검색</button>
                        </div>
                    </div>
                </form>
                <!-- Product Table -->
                <div class="row gx-4 gx-lg-5">
                    <c:forEach items="${goodsList}" var="goods">
                        <div class="col-md-3 mb-5">
                            <div class="card h-100">
                                <img class="card-img-top" src="${pageContext.request.contextPath}/upload/${goods.goodsFileName}.${goods.goodsFileExt}" alt="Product Image" />
                                <div class="card-body text-center">
                                    <h5 class="fw-bolder">${goods.goodsTitle}</h5>
                                    <p>${goods.goodsMemo}</p>
                                    <a href="${pageContext.request.contextPath}/common/goodsOne?goodsNo=${goods.goodsNo}" class="btn btn-outline-dark mt-auto">View Details</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <!-- 페이지네이션 -->
					<div class="pagination-container text-center mt-5">
					    <ul class="pagination justify-content-center">
					        <c:if test="${startPage > numPerPage}">
					            <li class="page-item">
					                <a class="page-link" href="${pageContext.request.contextPath}/common/home?categoryNo=${categoryNo}&searchTitle=${searchTitle}&currentPage=${cstartPage-numPerPage}" aria-label="Previous">
					                    <span aria-hidden="true">&laquo;</span>
					                </a>
					            </li>
					        </c:if>
					        <!-- 페이지 번호들 -->
					        <c:forEach var ="i" begin="${startPage}" end="${endPage}">
					            <c:if test="${i <= lastPage}">
					                <li class="page-item <c:if test="${i == currentPage}">active</c:if>">
					                    <a class="page-link" href="${pageContext.request.contextPath}/common/home?categoryNo=${categoryNo}&searchTitle=${searchTitle}&currentPage=${i}">${i}</a>
					                </li>
					            </c:if>
					        </c:forEach>
					
					        <!-- 다음 페이지로 이동 -->
					        <c:if test="${startPage + numPerPage <= lastPage}">
					            <li class="page-item">
					                <a class="page-link" href="${pageContext.request.contextPath}/common/home?categoryNo=${categoryNo}&searchTitle=${searchTitle}&currentPage=${startPage+numPerPage}" aria-label="Next">
					                    <span aria-hidden="true">&raquo;</span>
					                </a>
					            </li>
					        </c:if>
					
					        <!-- 마지막 페이지로 이동 -->
					        <c:if test="${currentPage < lastPage}">
					            <li class="page-item">
					                <a class="page-link" href="${pageContext.request.contextPath}/common/home?categoryNo=${categoryNo}&searchTitle=${searchTitle}&currentPage=${lastPage}" aria-label="Last">
					                    <span aria-hidden="true">&raquo;&raquo;</span>
					                </a>
					            </li>
					        </c:if>
					    </ul>
					</div>
                </div>
            </div>
        </div>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; GD 86Website 2024</p></div>
        </footer>
    </body>
      <script>
            $('#btnSearchTitle').click(function() {
                if ($('#searchTitle').val().trim() === '') {
                    alert('검색어를 입력해주세요');
                    return;
                }
                $('#formSearchTitle').submit();
            });
        </script>
</html>