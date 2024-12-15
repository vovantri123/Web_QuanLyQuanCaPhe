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
			<li><a href="QuenMatKhauServlet">Quên mật khẩu</a></li>
			<li><a href="QuenMatKhauServlet?action=confirm">Xác nhận OTP</a></li>
		</ul>
	</nav>
	<div class="form-gap" style="margin-top: 80px"></div>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header text-center">
						<h5 class="card-title">Nhập mã OTP</h5>
					</div>
					<div class="card-body">
						<p class="text-center">Hãy nhập mã OTP được gửi đến email của
							bạn</p>
						<div class="row justify-content-center">
							<div class="col-6 timer p-3"
								style="font-size: 3rem; font-weight: bold; text-align: center;">
								<span id="minutes">05</span>:<span id="seconds">00</span>
							</div>
						</div>
						<c:url var="url" value="QuenMatKhauServlet?action=confirm"></c:url>
						<form id="otp-form" action="${url}" method="post">
							<div class="mb-3">
								<label for="otp" class="form-label">OTP</label> <input id="otp"
									name="otp" type="text" class="form-control"
									placeholder="Enter OTP" required>
							</div>
							<div class="d-grid">
								<button type="submit" class="btn btn-success btn-lg">Xác
									nhận OTP</button>
							</div>
						</form>
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
<script>
	const timerMinutes = document.getElementById('minutes');
	const timerSeconds = document.getElementById('seconds');
	
	let time = 5 * 60; // 5 minutes in seconds
	
	const countdown = setInterval(() => {
	    const minutes = Math.floor(time / 60);
	    const seconds = time % 60;
	
	    timerMinutes.textContent = minutes.toString().padStart(2, '0');
	    timerSeconds.textContent = seconds.toString().padStart(2, '0');
	
	    time--;
	
	    if (time < 0) {
	        clearInterval(countdown);
	        alert("Time's up!");
	    }
	}, 1000);
</script>
</html>