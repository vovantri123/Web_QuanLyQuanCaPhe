<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/fragment/head.html"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="<%=request.getContextPath()%>/views/assets/js/profile.js"></script>
<title>Thông tin cá nhân</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="/views/fragment/header.jsp">
		<jsp:param name="HoTen" value="${nguoiDung.tenND}" />
		<jsp:param name="Anh" value="${nguoiDung.anhND}" />
	</jsp:include>

	<!-- Begin profile -->
	<div class="profile-container" style="margin-top: 81px">
		<h1>Thông tin cá nhân</h1>
		<hr />
		<div class="profile-container-feature">
			<div class="profile-form">
				<form action="ThongTinCaNhanServlet?action=luu"
					class="profile-form-control" method="post"
					enctype="multipart/form-data" onclick="setTextValues()">
					<div class="profile-image">
						<c:choose>
							<c:when
								test="${sessionScope.nguoiDung.anhND.startsWith('http://') || sessionScope.nguoiDung.anhND.startsWith('https://')}">
								<img id="userImage"
									src="<%=request.getContextPath()%>/imageProxy?url=${sessionScope.nguoiDung.anhND}"
									alt="" />
								<input type="file" class="custom-file-input" id="anhND" name="filename" />
								<input type="hidden" name="anhND" value="${sessionScope.nguoiDung.anhND != null ? sessionScope.nguoiDung.anhND : ''}" class="input-file-name" />
							</c:when>
							<c:otherwise>
								<img id="userImage"
									src="<%=request.getContextPath()%>/views/assets/images/HinhNguoiDung/${sessionScope.nguoiDung.anhND}"
									alt="" />
								<input type="file" class="custom-file-input" id="anhND" name="filename" />
								<input type="hidden" name="anhND" value="${sessionScope.nguoiDung.anhND != null ? sessionScope.nguoiDung.anhND : ''}" class="input-file-name" />
							</c:otherwise>
						</c:choose> 
					</div>
					<div class="profile-group-control">
						<div class="profile-form-group-account">
							<label for="">Thông tin tài khoản</label>
							<hr />
							<div class="profile-form-group">


								<div class="profile-form-user">
									<label for="">Tên đăng nhập</label>
									<div class="form-group-user">
										<i class="fa-solid fa-user"></i> 
										<input type="text"
											placeholder="" name="tenDangNhap"
											value="${sessionScope.nguoiDung.tenDangNhap != null ? sessionScope.nguoiDung.tenDangNhap : ''}"
											 disabled />
										<input type="hidden"
											placeholder="" name="tenDangNhapA"
											value="${sessionScope.nguoiDung.tenDangNhap != null ? sessionScope.nguoiDung.tenDangNhap : ''}"
											 />
											
									</div>
								</div>
								<div class="profile-form-user">
									<label for="">Mật khẩu</label>
									<div class="form-group-user">
										<input type="password" placeholder="" name="matKhau"
											value="${sessionScope.nguoiDung.matKhau != null ? sessionScope.nguoiDung.matKhau : ''}"
											disabled />
										<input type="hidden" placeholder="" name="matKhauA"
											value="${sessionScope.nguoiDung.matKhau != null ? sessionScope.nguoiDung.matKhau : ''}"
											/>
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
										placeholder="" name="hoTen"
										value="${sessionScope.nguoiDung.tenND != null ? sessionScope.nguoiDung.tenND : ''}"
										required />
								</div>
							</div>
							<div class="profile-form-user">
								<label for="">Năm sinh</label>
								<div class="form-group-user">
									<input type="text" name="nam"
										value="${sessionScope.nguoiDung.namSinh != null ? sessionScope.nguoiDung.namSinh : ''}"
										required />
								</div>
							</div>
						</div>
						<div class="profile-form-group">
							<div class="profile-form-user">
								<label for="">Số điện thoại</label>
								<div class="form-group-user">
									<i class="fa-solid fa-phone"></i> <input type="text" name="sdt"
										value="${sessionScope.nguoiDung.sdt != null ? sessionScope.nguoiDung.sdt : ''}"
										required />
								</div>
							</div>
							<div class="profile-form-user">
								<label for="">Giới tính</label>
								<div class="form-group-user">
									<select name="gioiTinh" required id="gioiTinh">
										<option value="Nam" ${sessionScope.nguoiDung.gioiTinh == 'Nam' ? 'selected' : ''}>Nam</option>
										<option value="Nữ" ${sessionScope.nguoiDung.gioiTinh == 'Nữ' ? 'selected' : ''}>Nữ</option>
										<option value="Khác" ${sessionScope.nguoiDung.gioiTinh == 'Khác' ? 'selected' : ''}>Khác</option>
									</select>
								</div>
							</div>
						</div>
						<div class="profile-form-group">
							<div class="profile-form-user">
								<label for="">Email</label>
								<div class="form-group-user">
									<i class="fa-solid fa-envelope"></i> <input type="email"
										name="email" required value="${sessionScope.nguoiDung.email != null ? sessionScope.nguoiDung.email : ''}" />
								</div>
							</div>
						</div>
						<div class="profile-form-group">
							<div class="profile-form-user">
								<label for="">Địa chỉ</label>
								<div class="form-group-country number-house">
									<input type="text" name="diaChi" required value="${sessionScope.nguoiDung.diaChi != null ? sessionScope.nguoiDung.diaChi : ''}" />
								</div>
							</div>
						</div>
						<div class="profile-button-control">
							<button type="submit">Cập nhật</button>
							<a href="TrangChuServlet">Quay lại</a>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>

	<!-- End profile -->

	<!-- Toast để thông bao  -->
	<jsp:include page="/views/fragment/toast.jsp">
		<jsp:param name="msg" value="${msg}" />
		<jsp:param name="type" value="${typeMess}" />
	</jsp:include>

	<!-- Footer -->
	<jsp:include page="/views/fragment/footer.jsp" />
</body>
</html>