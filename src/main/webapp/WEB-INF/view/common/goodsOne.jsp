<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
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
                width: 250px;
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
        <!-- Navigation End-->
        
       <!-- Product section-->
		<section class="py-5">
		    <div class="container px-4 px-lg-5 my-5">
		        <div class="row gx-4 gx-lg-5 align-items-center">
		            <div id="productCarousel" class="carousel slide col-md-6" data-bs-ride="carousel">
		                <div class="carousel-inner">
		                    <c:forEach var="gf" items="${goodsFileList}" varStatus="status">
		                        <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
		                            <img src="${pageContext.request.contextPath}/upload/${gf.goodsFileName}.${gf.goodsFileExt}" class="d-block w-100" alt="상품 이미지 ${status.index + 1}" />
		                        </div>
		                    </c:forEach> 
		                </div>
		                <!-- 이전/다음 버튼 -->
		                <button class="carousel-control-prev" type="button" data-bs-target="#productCarousel" data-bs-slide="prev">
		                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		                    <span class="visually-hidden">Previous</span>
		                </button>
		                <button class="carousel-control-next" type="button" data-bs-target="#productCarousel" data-bs-slide="next">
		                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		                    <span class="visually-hidden">Next</span>
		                </button>
		            </div>
		
		            <!-- 상품 설명 -->
		            <div class="col-md-6">
		                <div class="small mb-1">${goods.categoryTitle}</div>
		                <h1 class="display-5 fw-bolder">${goods.goodsTitle}</h1>
		                <div class="fs-5 mb-5">
		                    <span>$${goods.goodsPrice}</span>
		                </div>
		                <p class="lead">${goods.goodsMemo}</p>
		                <c:if test="${goods.goodsState == '재고있음'}">
			                <form id = "formAddCart" method="post" action="${pageContext.request.contextPath}/customer/addCart">
			                <input type="hidden" name = "goodsNo" value="${goods.goodsNo}">
			                <div class="d-flex">
			                    <input class="form-control text-center me-3" id="addCartAmount" name="cartAmount" type="num" value="1" min="1" style="max-width: 3rem" />
			                    <button id="btnAddCart" class="btn btn-outline-dark flex-shrink-0" type="button">
			                        <i class="bi-cart-fill me-1"></i>
			                        Add to cart
			                    </button>
		                    </form>
	                    </c:if>
	                    <c:if test="${goods.goodsState == '재고없음'}">
					    	<button id="btnAddCart" class="btn btn-outline-dark flex-shrink-0" type="button">
		                        <i class="bi-cart-fill me-1"></i>
		                        품절
		                    </button>
					    </c:if>
		                </div>
		            </div>
		        </div>
		</section>
    <div>
    <hr>
    	<section class="py-5">
		    <div class="container px-4 px-lg-5 my-5">
		        <h2>후기</h2>
		        <div class="row">
		            <c:forEach items="${reviewsList}" var="r">
		                <div class="col-md-4 mb-4">
		                    <div class="card h-100 shadow-sm">
		                        <div class="card-body">
		                            <h5 class="card-title">주문번호: ${r.ordersNo}</h5>
		                            <p class="card-text">${r.boardContent}</p>
		                        </div>
		                        <div class="card-footer text-muted text-end">
		                            ${r.updateDate}
		                        </div>
		                    </div>
		                </div>
		            </c:forEach>
		        </div>
		    </div>
		</section>
    </div>
    	<!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; GD 86Website 2024</p></div>
        </footer>
</body>
	<script>
        $('#btnAddCart').click(function() {
        	let customerMail = '${sessionScope.customerMail}';
        	let login = '${pageContext.request.contextPath}/common/login'
        	if(!customerMail){
        		alert('로그인 후 이용해주세요');
        		location.href = login;
        	} else if($('#cartAmount').val() == ''){
        		alert('수량을 입력해주세요');
        	} else {
				$('#formAddCart').submit();
        	}
		});
    </script>
</html>