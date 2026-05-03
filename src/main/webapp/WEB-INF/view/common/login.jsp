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
        <link href="${pageContext.request.contextPath}/resources/css/styles2.css" rel="stylesheet" />
        <script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
        
<title>Insert title here</title>
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
	 <!-- LOGIN MODULE -->
        <div class="login">
            <div class="wrap">
                <!-- LOGIN FORM -->
                <div class="user">
                    <div class="actions">
                        <a class="help" href="#signup-tab-content">Sign Up</a><a class="faq" href="#login-tab-content">Login</a>
                    </div>
                    <!-- LOGO -->
                    <div class="logo">
                        <a href="#"><img src="http://res.cloudinary.com/dpcloudinary/image/upload/v1506186248/logo.png" alt=""></a>
                    </div>
                    <!-- TOGGLE -->
                    <div id="toggle-wrap">
                        <div id="toggle-terms">
                            <div id="cross">
                                <span></span>
                                <span></span>
                            </div>
                        </div>
                    </div>
                    <!-- FORM -->
                    <div class="form-wrap">
                        <!-- TABS -->
                      <div class="tabs">
                            <h3 class="login-tab"><a class="log-in active" href="#login-tab-content"><span>Login<span></a></h3>
                        <h3 class="signup-tab"><a class="sign-up" href="#signup-tab-content"><span>Sign Up</span></a></h3>
                      </div>
                        <!-- TABS CONTENT -->
                      <div class="tabs-content">
                            <!-- TABS CONTENT LOGIN -->
                        <div id="login-tab-content" class="active">
                        	<form id="formLogin" class="login-form" method="post" action="${pageContext.request.contextPath}/common/login">
                        		<small class ="text text-white">${msg}</small>
	                            <input id="loginId" type="text" name="loginId" class="input" autocomplete="off" placeholder="Email or Username">
	                            <input id="password" type="password" name="password" class="input"  autocomplete="off" placeholder="Password">
	                            <button id="btnLogin" type="button" class="button">Login</button>
                          	</form>
                        </div>
                            <!-- TABS CONTENT SIGNUP -->
                        <div id="signup-tab-content">
                          <form id="formRegister" class="signup-form" action="${pageContext.request.contextPath}/common/register" method="post">
                            <input type="email" class="input" id="registerId" name="loginId" autocomplete="off" placeholder="Email">
                            <input type="password" class="input" id="registerPassword" name="password" autocomplete="off" placeholder="Password">
                            <input type="date" class="input" id="birth" name="birth" autocomplete="off" placeholder="BirthDay">
								<input id="gender" name="gender" type="radio" value="남자"><span class="text text-white"> Man</span>
								<input id="gender" name="gender" type="radio" value="여자"><span class="text text-white"> Women</span>
                            <button id="btnRegister" type="button" class="button">Register</button>
                          </form>
                        </div>
                      </div>
                  </div>
                </div>
            </div>
        <!-- Footer-->
        </div>
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; GD 86Website 2024</p></div>
        </footer>
</body>
<script>
$('#btnLogin').click(function(){ // 버튼클릭 시 가동
	console.log('클릭 로그'); // 디버깅
	if($('#loginId').val() == ""){ // 만약 loginId값이 비어있다면
		alert('ID를 입력해주세요.');
	} else if ($('#password').val() == ""){ // 만약 password값이 비어있다면
		alert('password를 입력해주세요.');
	} else if ($('#password').val().length < 4){ // 만약 password값이 4자릿수 이하라면
		alert('password는 4글자 이상 입력하셔야합니다.');
	} else {
		$('#formLogin').submit();
	}
});

$('#btnRegister').click(function() {
	if($('#registerId').val() == '' ||$('#registerId').val().indexOf('@')== -1){ 
		alert('이메일을 입력해주세요.');
	} else if ($('#registerPassword').val() == ''){
		alert('password를 입력해주세요.');
	} else if($('#birth').val() == '') {
		alert("생일을 입력해주세요.");
	} else if($('input[name="gender"]:checked').length == 0){ // 성별 입력값검사
		alert("성별을 체크해주세요.");
	} else {
		$('#formRegister').submit();
	}
		
});
</script>
</html>