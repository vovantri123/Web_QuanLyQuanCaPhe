<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/views/fragment/head.html"%>
<!-- toast.css và toast.js -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/toast.css" />
<script src="<%=request.getContextPath()%>/views/assets/js/toast.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/breadcrumb.css" />
<script src="<%=request.getContextPath()%>/views/assets/js/script.js"></script>
<script src="<%=request.getContextPath()%>/views/assets/js/profile.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/signup.css" />
<title>Đăng kí</title>
</head>
<body class="body-container">
	
	<nav aria-label="breadcrumb">
			<ul class="breadcrumb">
				<li><a href="DangNhapServlet">Đăng nhập</a></li>
				<li><a href="#">Đăng kí</a></li>
			</ul>
		</nav>
	<div class="profile-container">
		<h1>Đăng kí</h1>
		<hr />
		<div class="profile-container-feature">
			<div class="profile-form">

				<form action="DangKyServlet?action=register"
					class="profile-form-control" method="post"
					enctype="multipart/form-data" onclick="setTextValues()">
					<div class="profile-image" style="border: none">
						<img src="https://via.placeholder.com/150" alt="" /> 
						<input type="file" class="custom-file-input" id="anhND" name="filename" />
						<input type="hidden" name="anhND" value="" class="input-file-name"/>
					</div>
					<div class="profile-group-control">
						<div class="profile-form-group-account">
							<label for="">Thông tin tài khoản</label>
							<hr />
							<div class="profile-form-group">


								<div class="profile-form-user">
									<label for="">Tên đăng nhập</label>
									<div class="form-group-user">
										<i class="fa-solid fa-user"></i> <input type="text"
											placeholder="" name="tenDangNhap" required />
									</div>
								</div>
								<div class="profile-form-user">
									<label for="">Mật khẩu</label>
									<div class="form-group-user">
										<input type="password" placeholder="" name="matKhau" required />
									</div>
								</div>
								<div class="profile-form-user">
									<div class="profile-form-user">
										<label for="">Nhập lại mật khẩu</label>
										<div class="form-group-user">
											<input type="password" placeholder="" name="matKhauRetry"
												required />
										</div>
									</div>
								</div>
							</div>
						</div>
						<label for="">Thông tin cá nhân</label>
						<hr />
						<div class="profile-form-group">
							<div class="profile-form-user">
								<label for="">Họ và tên</label>
								<div class="form-group-user">
									<i class="fa-solid fa-user"></i> <input type="text"
										placeholder="" name="hoTen" required />
								</div>
							</div>
							<div class="profile-form-user">
								<label for="">Năm sinh</label>
								<div class="form-group-user">
									<input type="text" name="ngay" required />
								</div>
							</div>
						</div>
						<div class="profile-form-group">
							<div class="profile-form-user">
								<label for="">Số điện thoại</label>
								<div class="form-group-user">
									<i class="fa-solid fa-phone"></i> <input type="text" name="sdt"
										required />
								</div>
							</div>
							<div class="profile-form-user">
								<label for="">Giới tính</label>
								<div class="form-group-user">
									<select name="gioiTinh" required id="">
										<option value="Nam">Nam</option>
										<option value="Nữ">Nữ</option>
										<option value="Khác">Khác</option>
									</select>
								</div>
							</div>
						</div>
						<div class="profile-form-group">
							<div class="profile-form-user">
								<label for="">Email</label>
								<div class="form-group-user">
									<i class="fa-solid fa-envelope"></i> <input type="email"
										name="email" required />
								</div>
							</div>
						</div>
						<div class="profile-form-group">
							<div class="profile-form-user">
								<label for="">Địa chỉ</label>
								<div class="form-group-country number-house">
									<input type="text"
										name="diaChi" required />
								</div>
							</div>
						</div>
						<div class="profile-button-control">
							<button type="submit">Lưu</button>
						</div>
					</div>

				</form>
			</div>
		</div>
		<!-- Toast để thông bao  -->
		<jsp:include page="/views/fragment/toast.jsp" >
			<jsp:param name="msg" value="${msg}" />
			<jsp:param name="type" value="${typeMess}" />
		</jsp:include>
	</div>
	
</body>
</html>