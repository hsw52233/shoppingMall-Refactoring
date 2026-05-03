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
        <h1 class="h4">상품 페이지</h1>
        <div class="d-flex align-items-center">
        	<div class="button-group">
    <a href="${pageContext.request.contextPath}/staff/main" class="btn btn-outline-light btn-sm btn-custom">home</a>
    <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-light btn-sm btn-custom">로그아웃</a>
</div>
        </div>
    </div>
</header>
<div class="container-fluid mt-5">
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
            <form id="formGoodsAdd" method="post" action="${pageContext.request.contextPath}/staff/goodsAdd" enctype="multipart/form-data">
               
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="goodsTitle" class="form-label">Goods Title</label>
                        <input type="text" class="form-control" name="goodsTitle" id="goodsTitle">
                    </div>
                    <div class="col-md-6">
                        <label for="goodsMemo" class="form-label">Goods Memo</label>
                        <input type="text" class="form-control" name="goodsMemo" id="goodsMemo">
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="goodsPrice" class="form-label">Goods Price</label>
                        <input type="number" class="form-control" name="goodsPrice" id="goodsPrice">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Goods State</label>
                        <div>
                            <label class="form-check-label">
                                <input name="goodsState" type="radio" value="재고있음" class="form-check-input"> 재고있음
                            </label>
                            <label class="form-check-label ms-3">
                                <input name="goodsState" type="radio" value="재고없음" class="form-check-input"> 재고없음
                            </label>
                        </div>
                    </div>
                </div>
               <div class="col-md-6">
    <label for="categoryNo" class="form-label">Goods Category</label>
    <select class="form-select" name="categoryNo" id="categoryNo">
        <option value="">:::선택:::</option>
        <c:forEach items="${categoryList}" var="c">
            <option value="${c.categoryNo}">${c.categoryTitle}</option>
        </c:forEach>
    </select>
</div>

<!-- 여백 추가 -->
<div class="my-4"></div> <!-- 추가: 수직 여백 -->

<div class="mb-3 d-flex justify-content-between align-items-center">
	<div>
   	<input type="file" name="goodsFile" class="form-control goodsFile mb-2">
	</div>
    <div id="fileDiv" class="d-flex gap-2">
        <button type="button" id="btnAddFile" class="btn btn-primary">파일 추가</button>
        <button type="button" id="btnRemoveFile" class="btn btn-primary">파일 삭제</button>
    </div>
    <button id="btnGoodsAdd" type="submit" class="btn btn-primary">상품추가</button>
</div>
            </form>

        </div>
    </div>
</div>
</body>
<script type>
	$('#btnGoodsAdd').click(function() {
		if($('#goodsTitle').val() == ''){
			alert('상품제목 입력');
		} else if($('#goodsMemo').val() == '') {
			alert('goodsMemo 입력');
		} else if($('#goodsPrice').val() == '') {
			alert('goodsPrice 입력');
		} else if(!$('input[name="goodsState"]:checked').val()) {
			alert('goodsState 선택');
		} else if(!$('#categoryNo').val()) {
			alert('categoryTitle 선택');
		} else if($('.goodsFile').length > 0 && $('.goodsFile').last().val() == '') {
			alert('첨부되지 않은 파일 존재');
		} else {
			$('#formGoodsAdd').submit();
		}
	});
	
	$('#btnAddFile').click(function() {
        if ($('.goodsFile').last().val() == '') {
            alert('첨부하지 않은 파일이 존재합니다');
        } else {
            let html = '<input type="file" name="goodsFile" class="form-control goodsFile mb-2">';
            $('#fileDiv').append(html);
        }
    });

    $('#btnRemoveFile').click(function() {
        if ($('.goodsFile').length == 0) {
            alert('삭제할 빈 input=file이 존재하지 않습니다');
        } else {
            $('.goodsFile').last().remove();
        }
    });
</script>
    <%@ include file="common/footer.jsp" %>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
