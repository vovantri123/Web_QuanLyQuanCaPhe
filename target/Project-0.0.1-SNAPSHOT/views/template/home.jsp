<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/views/fragment/head.html"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/home.css" />
<script src="<%=request.getContextPath()%>/views/assets/js/home.js"
	type="text/javascript"></script>
<title>Trang chủ</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="/views/fragment/header.jsp">
		<jsp:param name="HoTen" value="${nguoiDung.tenND}" />
		<jsp:param name="Anh" value="${nguoiDung.anhND}" />
	</jsp:include>
	<!-- Slider -->
	<div class="sliders-container">
		<div class="slider">
			<div class="slides">
				<c:forEach var="slide" items="${listSlide}">
					<div class="slide">
						<img
							src="<%=request.getContextPath()%>/views/assets/images/Slide/${slide.anhSlide}"
							alt="${slide.tenSlide}" />
					</div>
				</c:forEach>
			</div>
			<!-- Nút điều hướng -->
			<button class="prev" onclick="changeSlide(-1)">&#10094;</button>
			<button class="next" onclick="changeSlide(1)">&#10095;</button>
		</div>
	</div>
	
	<!-- Danh mục loại sản phẩm -->
	<section class="category-container">
		<h1>DANH MỤC</h1>
		<section class="grid-container">
			<c:forEach var="list" items="${listLoaiSP}">
				<article class="grid-item">
					<a href="DanhMucSanPham?id=${list.maLoaiSP}"> <img
						src="<%=request.getContextPath()%>/views/assets/images/HinhSanPham/${list.hinhLoaiSP}"
						alt="${list.tenLoaiSP}">
						<p>${list.tenLoaiSP}</p>
					</a>
				</article>
			</c:forEach>
		</section>
	</section>
	
	<!-- Begin more information -->
	<div class="infor-container">
		<div class="infor-row">
			<div class="infor-image">
				<img src="<%=request.getContextPath()%>/views/assets/images/Slide/slide15.jpg" alt="Tea Leaf"
					class="custom-img">
			</div>
			<div class="infor-content">
				<p class="infor-label">Tiểu sử</p>
				<h2 class="infor-title">Lịch sử của cà phê</h2>
				<div class="infor-divider">
					<hr class="divider-line">
					<span class="divider-dot">•</span>
					<hr class="divider-line">
				</div>
				<p class="infor-text">Cà phê có một lịch sử lâu đời và đầy thú vị, 
				bắt nguồn từ vùng cao nguyên Ethiopia vào khoảng thế kỷ thứ 9, 
				nơi truyền thuyết kể rằng một người chăn dê phát hiện 
				ra hạt cà phê khi nhận thấy đàn dê của mình trở nên năng động sau khi ăn loại quả này</p>
				<p class="infor-text">Ngày nay, cà phê là thức uống toàn cầu, biểu tượng của sự sáng tạo 
				và kết nối con người qua mọi nền văn hóa.</p>
				<a href="DanhMucSanPham" class="infor-button">Tìm hiểu</a>
			</div>
		</div>
	</div>
	<!-- End more information -->
	

	<!-- Danh mục sản phẩm hot -->
	<div class="catalog-product-container">
		<div class="catalog-product-title">
			<h1>Sản phẩm HOT</h1>
		</div>

		<section class="product-grid">
			<c:forEach var="product" items="${listProduct}">
				<a
					href="ChiTietSanPhamServlet?id=${product.maSP}&type=${product.maLoaiSP}">
					<article class="product-card">
						<img
							src="<%=request.getContextPath()%>/views/assets/images/HinhSanPham/${product.anhSP}"
							alt="${product.tenSP}">
						<div class="product-info">
							<h3 class="product-name">${product.tenSP}</h3>
							<p class="product-price">${product.getPriceFormat()}</p>
							<div class="custom-product-rating">
								<span class="custom-rating-stars"> <c:forEach var="i"
										begin="1" end="${product.trungBinhSoSao}">
										<span class="custom-star">⭐</span>
									</c:forEach>
								</span> <span>${product.trungBinhSoSao}</span>
							</div>
						</div>
					</article>
				</a>
			</c:forEach>
		</section>
	</div>
	<!-- Danh mục toàn bộ sản phẩm -->
	<div class="catalog-product-container">
		<div class="catalog-product-title">
			<h1>Toàn bộ sản phẩm</h1>
		</div>

		<section class="product-grid">
			<c:forEach var="product" items="${listSP}" varStatus="status">
				<a
					href="ChiTietSanPhamServlet?id=${product.maSP}&type=${product.maLoaiSP}">
					<article class="product-card ${status.index >= 10 ? 'hidden' : ''}">
						<img
							src="<%=request.getContextPath()%>/views/assets/images/HinhSanPham/${product.anhSP}"
							alt="${product.tenSP}">
						<div class="product-info">
							<h3 class="product-name">${product.tenSP}</h3>
							<p class="product-price">${product.getPriceFormat()}</p>
						</div>
					</article>
				</a>
			</c:forEach>
		</section>
		<button id="showMoreBtn" onclick="showMoreProducts()">Hiển
			thị thêm sản phẩm</button>
	</div>
	
		<!-- Begin About -->
	<jsp:include page="/views/fragment/about_us.jsp" />
	<!-- End About -->

	<!-- Toast để thông bao  -->
	<jsp:include page="/views/fragment/toast.jsp">
		<jsp:param name="msg" value="${msg}" />
		<jsp:param name="type" value="${typeMess}" />
	</jsp:include>
	<!-- Footer -->
	<jsp:include page="/views/fragment/footer.jsp" />
</body>
<script>
	function showMoreProducts() {
		// Lấy tất cả các sản phẩm có class 'hidden'
		let hiddenItems = document.querySelectorAll('.product-card.hidden');
		// Hiển thị tối đa 5 sản phẩm mỗi lần nhấn
		for (let i = 0; i < 10 && i < hiddenItems.length; i++) {
			hiddenItems[i].classList.remove('hidden');
		}
		// Ẩn nút nếu không còn sản phẩm ẩn
		if (document.querySelectorAll('.product-card.hidden').length === 0) {
			document.getElementById('showMoreBtn').style.display = 'none';
		}
	}
</script>
</html>