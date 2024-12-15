<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="/views/fragment/head.html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<!-- Header -->
	<jsp:include page="/views/fragment/header.jsp">
		<jsp:param name="HoTen" value="${nguoiDung.tenND}" />
		<jsp:param name="Anh" value="${nguoiDung.anhND}" />
	</jsp:include>
	<!-- About Section -->
	<div class="custom-container-fluid custom-page-header py-5 mb-5 fadeIn"
		data-wow-delay="0.1s">
		<div class="custom-container text-center py-5">
			<h1 class="custom-display-2 text-light mb-4 slideInDown">About
				Us</h1>
			<nav aria-label="breadcrumb slideInDown">
				<ol class="custom-breadcrumb justify-content-center mb-0">
					<li class="custom-breadcrumb-item text-light"><a href="<%=request.getContextPath()%>/TrangChuServlet">Trang
							chủ</a></li>
					<li class="custom-breadcrumb-item text-light" aria-current="page">Giới
						thiệu</li>
				</ol>
			</nav>
		</div>
	</div>
	<jsp:include page="/views/fragment/about_us.jsp"/>
	<!-- About End -->
	<!-- Footer -->
	<jsp:include page="/views/fragment/footer.jsp"/>

</body>
</html>