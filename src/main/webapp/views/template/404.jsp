<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/views/fragment/head.html"%>
</head>
<body>

	<!-- Header -->
	<jsp:include page="/views/fragment/header.jsp">
		<jsp:param name="HoTen" value="${nguoiDung.tenND}" />
		<jsp:param name="Anh" value="${nguoiDung.anhND}" />
	</jsp:include>
	
	<!-- 404 Start -->
    <div class="container-xxl py-5 wow fadeInUp mt-5" data-wow-delay="0.1s">
        <div class="container text-center">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <i class="bi bi-exclamation-triangle display-1 text-primary"></i>
                    <h1 class="display-1">404</h1>
                    <h1 class="mb-4">Page Not Found</h1>
                    <p class="mb-4">Chúng tôi xin lỗi bạn không thể vào trang này vì lý do bảo mật</p>
                    <a class="btn btn-primary rounded-pill py-3 px-5" href="TrangChuServlet">Quay lại trang chủ</a>
                </div>
            </div>
        </div>
    </div>
    <!-- 404 End -->
    
    <!-- Footer -->
	<jsp:include page="/views/fragment/footer.jsp" />
</body>
</html>