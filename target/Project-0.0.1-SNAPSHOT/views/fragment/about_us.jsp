<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/about.css" />
<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Playfair+Display:wght@700;900&display=swap"
	rel="stylesheet">

<style>
.custom-page-header {
	background: linear-gradient(rgba(255, 220, 80, 0.35),
		rgba(102, 45, 0, 0.35)), url(<%=request.getContextPath()%>/views/assets/images/Slide/slide14.jpg)
		center center no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<!-- About Section -->
	<div class="custom-container-xxl py-5">
		<div class="custom-container">
			<div class="row g-5">
				<div class="col-lg-6">
					<div class="row g-3">
						<div class="col-6 text-end">
							<img class="img-fluid custom-bg-white w-100 mb-3 fadeIn"
								data-wow-delay="0.1s"
								src="<%=request.getContextPath()%>/views/assets/images/Slide/slide13.jpg"
								alt=""> <img class="img-fluid custom-bg-white w-50 fadeIn"
								data-wow-delay="0.2s"
								src="<%=request.getContextPath()%>/views/assets/images/Slide/slide12.jpg"
								alt="">
						</div>
						<div class="col-6">
							<img class="img-fluid custom-bg-white w-50 mb-3 fadeIn"
								data-wow-delay="0.3s"
								src="<%=request.getContextPath()%>/views/assets/images/Slide/slide10.jpg"
								alt=""> <img
								class="img-fluid custom-bg-white w-100 fadeIn"
								data-wow-delay="0.4s"
								src="<%=request.getContextPath()%>/views/assets/images/Slide/slide11.jpg"
								alt="">
						</div>
					</div>
				</div>
				<div class="col-lg-6 fadeIn" data-wow-delay="0.5s">
					<div class="custom-section-title">
						<p class="custom-fs-5 custom-fw-medium fst-italic text-primary">Về chúng tôi</p>
						<h1 class="custom-display-6">25 năm phát triển trong lĩnh vực cà phê</h1>
					</div>
					<div class="row g-3 mb-4">
						<div class="col-sm-4">
							<img class="img-fluid custom-bg-white w-100"
								src="<%=request.getContextPath()%>/views/assets/images/Slide/slide9.jpg"
								alt="">
						</div>
						<div class="col-sm-8">
							<h5>Cà phê của chúng tôi là sản phẩm ưa chuộng nhất Việt Nam</h5>
							<p class="mb-0">Hương vị Việt, đậm đà bản sắc.</p>
						</div>
					</div>
					<div class="custom-border-top mb-4"></div>
					<div class="row g-3">
						<div class="col-sm-8">
							<h5>Mỗi ngày một tách cà phê sức khỏe của bạn sẽ được cả thiện</h5>
							<p class="mb-0">Thưởng thức cà phê – Tận hưởng cuộc sống.</p>
						</div>
						<div class="col-sm-4">
							<img class="img-fluid custom-bg-white w-100"
								src="<%=request.getContextPath()%>/views/assets/images/Slide/slide8.jpg"
								alt="">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- About End -->
</body>
</html>