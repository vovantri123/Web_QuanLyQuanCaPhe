<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<header id="header">
		<div class="container header-container">
			<img
				src="<%=request.getContextPath()%>/views/assets/favicon/logo.png"
				alt="Logo" />
			<nav class="nav-link-feature">
				<ul class="nav-links">
					<li><a href="TrangChuServlet">Trang chủ</a></li>
					<li><a href="TrangChuServlet?action=about">Giới thiệu</a></li>
					<li><a href="DanhMucSanPham">Danh mục sản phẩm</a></li>
					<li><a href="TrangChuServlet?action=contact">Liên hệ</a></li>
					<li><a href="DonHangServlet">Quản Lý Đơn Hàng</a></li>
				</ul>
			</nav>
			<nav class="nav-feature">
				<ul class="feature">
					<li class="nav-item dropdown"><a class="nav-link"
						href="ThongTinCaNhanServlet" data-bs-toggle="dropdown"
						aria-expanded="false"> <i class="fa-solid fa-user"></i>
					</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item"
								href="ThongTinCaNhanServlet">Profile</a></li>
							<li><a class="dropdown-item" href="DangNhapServlet">Đăng
									nhập</a></li>
							<li><a class="dropdown-item"
								href="DangKyServlet?action=signup">Đăng kí</a></li>
							<li><a class="dropdown-item"
								href="LogoutServlet">Log out</a></li>
						</ul></li>
						
					<li class="feature-cart"><a href="HoaDonServlet" class="cart"><i
							class="fa-solid fa-cart-shopping"></i> <span
							class="position-absolute top-10 translate-middle badge rounded-pill bg-danger" style="color: white;">
								${sessionScope.soSPDat > 0 ? sessionScope.soSPDat : '0'}<span class="visually-hidden"></span>
						</span></a>
					</li>					
				</ul>
			</nav>
			<nav class="nav-profile">
				<div class="profile">
					<div class="profile-images">
						<c:choose>
							<c:when
								test="${param.Anh.startsWith('http://') || param.Anh.startsWith('https://')}">
								<img id="userImage"
									src="${pageContext.request.contextPath}/imageProxy?url=${param.Anh}"
									alt="" />
							</c:when>
							<c:otherwise>
								<img id="userImage"
									src="${pageContext.request.contextPath}/views/assets/images/HinhNguoiDung/${param.Anh}"
									alt="" />
							</c:otherwise>
						</c:choose>
					</div>
					<div class="profile-names">
						<p>${param.HoTen}</p>
					</div>

				</div>

			</nav>

		</div>
	</header>
	<script>
		function setImageSrc(imgId, imageUrl) {
			// Gán trực tiếp URL vào thẻ <img> nếu URL tồn tại
			if (imageUrl && imageUrl.trim() !== '') {
				document.getElementById(imgId).src = imageUrl;
			}
		}
	</script>
</body>
</html>