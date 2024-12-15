<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/breadcrumb.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
	integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav aria-label="breadcrumb">
		<ul class="breadcrumb">
			<li><a href="DangNhapServlet">Đăng nhập</a></li>
			<li><a href="#">Quên mật khẩu</a></li>
		</ul>
	</nav>
	<div class="form-gap" style="margin-top: 80px"></div>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<h3>
								<i class="fa-solid fa-lock fa-4x"></i>
							</h3>
							<h2 class="text-center">Quên mật khẩu</h2>
							<p>Lấy lại mật khẩu</p>
							<div class="card-body">
								<c:url var="url" value="QuenMatKhauServlet?action=forget"></c:url>
								<form id="register-form" role="form" autocomplete="off"
									action="${url}" class="form" method="post"
									action="QuenMatKhauServlet?action=reset">

									<div class="mb-3">
										<label for="email" class="form-label">Nhập thông tin</label>
										<div class="input-group">
											<span class="input-group-text"> <i
												class="fas fa-envelope text-primary"></i>
											</span> <input id="email" name="email" placeholder="Email"
												class="form-control" type="email">

										</div>
									</div>
									<div class="mb-3">
										
										<div class="input-group">
											<span class="input-group-text"> <i
												class="fas fa-user text-primary"></i>
											</span> <input id="username" name="username"
												placeholder="Tên đăng nhập" class="form-control" type="text"
												required>
										</div>
									</div>

									<div class="d-grid">
										<button type="submit" name="recover-submit"
											class="btn btn-primary btn-lg">Lấy lại mật khẩu</button>
									</div>

								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Toast để thông bao  -->
	<jsp:include page="/views/fragment/toast.jsp">
		<jsp:param name="msg" value="${msg}" />
		<jsp:param name="type" value="${typeMess}" />
	</jsp:include>
</body>
</html>