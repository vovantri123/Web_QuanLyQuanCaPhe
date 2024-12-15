<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/views/fragment/head.html"%>
<title>Đăng nhập</title>
</head>
<body>

	<div class="login-container">
		<div class="login-container-group">
			<div class="login-images">
			<img src="<%=request.getContextPath()%>/views/assets/images/Slide/slide6.jpg"/>
		</div>
		<div class="login-form-control">
			<div class="login-form">
			<h2>Đăng nhập</h2>
			<form method="post" action="DangNhapServlet?action=login">
				<input type="text" placeholder="Tên đăng nhập" name="username" required /> 
				<input
					type="password" placeholder="Mật khẩu" name="password" required />
				<div class="login-forget-pass">
					<a class="forget-pass" href="QuenMatKhauServlet">Quên mật khẩu</a>
				</div>

			<div class="sign-up">
				<label>Nếu chưa có tài khoản? <a href="DangKyServlet?action=signup">Đăng kí</a></label>
				<center>
					<label for="">Hoặc đặng nhập với</label>
				</center>
			</div>
				<div class="login-action">
					<button type="submit">Đăng nhập</button>
				</div>
			</form>
			
			<div class="social-login">
				<a class="google-login"
					href="https://accounts.google.com/o/oauth2/auth?scope=email profile openid&redirect_uri=http://localhost:8080/Project/GoogleLoginServlet&response_type=code&client_id=955034230388-n9bs7ftul2g2n230qp4hko3j7dug4b0k.apps.googleusercontent.com&approval_prompt=force">
					<i class="fa-brands fa-google"></i>Google
				</a>
			</div>
		</div>
		</div>
		</div>
		
	</div>
	<!-- Toast để thông bao  -->
		<jsp:include page="/views/fragment/toast.jsp" >
			<jsp:param name="msg" value="${msg}" />
			<jsp:param name="type" value="${typeMess}" />
		</jsp:include>
</body>

</html>