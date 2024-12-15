<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<%@ include file="/views/fragment/head.html"%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/style.css" />
	
<style>
.contact-introduce-background {
	background-image:
		url('<%=request.getContextPath()%>/views/assets/images/roivnrg.png');
}
</style>
<title>Contact us</title>
</head>
<body>

	<!-- Header -->
		<jsp:include page="/views/fragment/header.jsp">
			<jsp:param name="HoTen" value="${nguoiDung.tenND}" />
			<jsp:param name="Anh" value="${nguoiDung.anhND}" />
		</jsp:include>
	<!-- Nội dung -->
	<div class="contact-container">
		<div class="contact-introduce">
			<div class="contact-introduce-background">
				<h1>Liên lạc với chúng tôi</h1>
				<p>Có những người không thể bắt đầu ngày mới nếu không uống một
					tách cà phê mới pha và chúng tôi hiểu họ.</p>
			</div>
		</div>
		<div class="contact-content">
			<div class="contact-image">
				<img
					src="<%=request.getContextPath()%>/views/assets/images/kgbngk.png"
					alt="Hình ảnh quán cà phê" />
			</div>
			<div class="contact-info">
				<div class="contact-info-introduce">
					<h2>Đến với cửa hàng chúng tôi</h2>
					<p>Bạn sẽ được trải nghiệm nhiều loại đồ uống hảo hạn</p>
				</div>
				<div class="contact-info-method">
					<div class="contact-info-phone">
						<img
							src="<%=request.getContextPath()%>/views/assets/images/phone-call.png"
							alt="" />
						<p>0949617948</p>
					</div>

					<div class="contact-info-message">
						<img
							src="<%=request.getContextPath()%>/views/assets/images/messenger.png"
							alt="" />
						<p>anhkhoaxn11@gmail.com</p>
					</div>
				</div>

				<div class="contact-info-calender">
					<div class="working-hours">
						<h2>Giờ làm việc</h2>
						<ul>
							<li><strong>Thứ Hai:</strong>
								<hr />
								<p>10:00 AM - 07:00 PM</p></li>
							<li><strong>Thứ Ba:</strong>
								<hr />
								<p>10:00 AM - 07:00 PM</p></li>
							<li><strong>Thứ Tư:</strong>
								<hr />
								<p>10:00 AM - 07:00 PM</p></li>
							<li><strong>Thứ Năm:</strong>
								<hr />
								<p>10:00 AM - 07:00 PM</p></li>
							<li><strong>Thứ Sáu:</strong>
								<hr />
								<p>10:00 AM - 07:00 PM</p></li>
							<li><strong>Thứ Bảy:</strong>
								<hr />
								<p>10:00 AM - 07:00 PM</p></li>
							<li><strong>Chủ Nhật:</strong>
								<hr />
								<p>Đóng cửa</p></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="contact-location">
			<h2>Địa chỉ</h2>
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.391594929717!2d106.76437767487086!3d10.857791089295961!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175279c462ad2af%3A0x4006c07f1b01a928!2zMjIvMiDEkC4gU-G7kSA3LCBQaMaw4budbmcgTGluaCBUcnVuZywgVGjhu6cgxJDhu6ljLCBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1730560139986!5m2!1svi!2s"
				width="600" height="450" style="border: 0" allowfullscreen=""
				loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
		</div>
	</div>
	<!-- Footer -->
	<jsp:include page="/views/fragment/footer.jsp" />

</body>
</html>