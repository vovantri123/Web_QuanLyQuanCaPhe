<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/views/fragment/head.html"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/style.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/breadcrumb.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/chitietSP.css" />
<script src="<%=request.getContextPath()%>/views/assets/js/review.js"></script>
<title>Chi tiết sản phẩm</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="/views/fragment/header.jsp">
		<jsp:param name="HoTen" value="${nguoiDung.tenND}" />
		<jsp:param name="Anh" value="${nguoiDung.anhND}" />
	</jsp:include>

	<div class="product-detail-container">
		<nav aria-label="breadcrumb">
			<ul class="breadcrumb">
				<li><a href="TrangChuServlet">Home</a></li>
				<li><a href="#">Products</a></li>
			</ul>
		</nav>
		<div class="product-container">
			<!-- Hình ảnh sản phẩm -->
			<div class="product-image main-image" id="mainImage">
				<img
					src="<%=request.getContextPath()%>/views/assets/images/HinhSanPham/${product.anhSP}"
					alt="Sữa phô mai tươi" />
				<div class="thumbnail-container">
					<img
						src="<%=request.getContextPath()%>/views/assets/images/HinhSanPham/${product.anhSP}"
						alt="Thumbnail" class="thumbnail active"
						onclick="changeImage(this)" />
				</div>
			</div>

			<!-- Chi tiết sản phẩm -->
			<div class="product-details">
				<h1>${product.tenSP}</h1>
				<div class="product-price">${product.getPriceFormat()}</div>
				<p class="product-description">${product.moTaSP}</p>

				<!-- Thêm sản phẩm vào giỏ hàng -->
				<form action="ChiTietSanPhamServlet" method="post">
					<!-- Thiếu mã người dùng -->
					<input type="hidden" name="maSP" value="${product.maSP}" />

					<!-- Thêm id và type -->
					<input type="hidden" name="id" value="${param.id}" /> <input
						type="hidden" name="type" value="${param.type}" />

					<div class="quantity">
						<label for="soLuong">Số lượng:</label> <input type="number"
							id="soLuong" name="soLuong" value="1" min="1" />
					</div>

					<!-- Nút thêm vào giỏ hàng -->
					<button type="submit" class="add-to-cart">Thêm vào giỏ
						hàng</button>
				</form>
			</div>
		</div>
		<!-- Dòng "Customer Review" với dấu cộng -->
		<div class="d-flex  justify-content-center gap-3 mt-5">
			<span class="customer-review" style="font-size: 22px"> Đánh
				giá khách hàng</span> <span class="customer-review" style="font-size: 22px"
				onclick="toggleCommentSection()">+</span>
		</div>
		<div class="container customer-comment-container mt-5">
			<div class="row g-4">
				<!-- Phần comment của khách hàng -->
				<div class="col-md-6">
					<h5 class="text-center">Bình luận</h5>
					<form action="DanhGiaServlet?action=gui" method="post">
						<input type="hidden" name="idNguoiDungHT" value="" id="idNgdung">
						<div class="d-flex flex-row p-4 justify-content-start">
							<div class="d-flex flex-column justify-content-start">
								<!-- Đánh giá sao -->
								<div class="rating-stars mb-3">
									<input type="hidden" name="rating" id="ratingInput" value="0" />
									<label class="star" data-value="1">★</label> <label
										class="star" data-value="2">★</label> <label class="star"
										data-value="3">★</label> <label class="star" data-value="4">★</label>
									<label class="star" data-value="5">★</label>
								</div>
								<!-- Ảnh khách hàng và tên -->
								<div class="text-center flex-start">
									<c:choose>
										<c:when
											test="${sessionScope.nguoiDung.anhND.startsWith('http://') || sessionScope.nguoiDung.anhND.startsWith('https://')}">
											<img
												src="<%=request.getContextPath()%>/imageProxy?url=${sessionScope.nguoiDung.anhND}"
												alt="Customer" class="rounded-circle mb-2" />
											<input type="hidden" name="anhND"
												value="${sessionScope.nguoiDung.anhND != null ? sessionScope.nguoiDung.anhND : ''}"
												class="input-file-name" />
										</c:when>
										<c:otherwise>
											<img
												src="<%=request.getContextPath()%>/views/assets/images/HinhNguoiDung/${sessionScope.nguoiDung.anhND}"
												alt="Customer" class="rounded-circle mb-2" />
											<input type="hidden" name="anhND"
												value="${sessionScope.nguoiDung.anhND != null ? sessionScope.nguoiDung.anhND : ''}"
												class="input-file-name" />
										</c:otherwise>
									</c:choose>

								</div>
								<div class="text-center">
									<label>${sessionScope.nguoiDung.tenND}</label>
								</div>
							</div>
							<div class="comment d-flex flex-column justify-content-center">
								<textarea class="form-control mt-4"
									placeholder="Viết bình luận..." rows="4" name="comment"></textarea>
							</div>
						</div>
						<div class="button-group d-flex justify-content-end me-4 gap-2">
							<button class="btn btn-success w-1" type="submit">Gửi</button>
							<button class="btn btn-success w-1" type="submit">Sửa</button>
						</div>

					</form>
				</div>

				<!-- Phần hiển thị đánh giá -->
				<div class="col-md-6" id="#commentAll">
					<div class="p-4 border rounded shadow-sm">
						<h5 class="text-center mb-4">Toàn bộ đánh giá</h5>
						<c:forEach var="review" items="${listReview}">
							<div class="review position-relative">
								<div class="customer-rate d-flex">
									<div class="customer-img-rate">
										<c:choose>
											<c:when
												test="${review.anhND.startsWith('http://') || review.anhND.startsWith('https://')}">
												<img
													src="<%=request.getContextPath()%>/imageProxy?url=${review.anhND}"
													alt="Customer" class="rounded-circle mb-2" />
											</c:when>
											<c:otherwise>
												<img
													src="<%=request.getContextPath()%>/views/assets/images/HinhNguoiDung/${review.anhND}"
													alt="Customer" class="rounded-circle mb-2" />
											</c:otherwise>
										</c:choose>
									</div>
									<div
										class="customer-infor-rate d-flex flex-column justify-content-center">
										<p class="fw-bold">${review.tenND}</p>
										<input type="hidden" value="${review.maND != null ? review.maND : ''}" name="maNDHT" /> 
										<div class="text-warning w-1">
											<c:forEach var="i" begin="1" end="${review.soSao}" step="1">
					                        ★
					                    	</c:forEach>
										</div>
									</div>

									<!-- Nút setting (hiển thị khi comment là của người dùng hiện tại) -->
									<c:if test="${sessionScope.nguoiDung.maND == review.maND}">
										<div class="setting-button">
											<button class="btn btn-light dropdown-toggle" type="button"
												id="dropdownMenuButton" data-bs-toggle="dropdown"
												aria-expanded="false">
												<i class="bi bi-gear"></i>
											</button>
											<ul class="dropdown-menu"
												aria-labelledby="dropdownMenuButton">
												<li><a class="dropdown-item" href="DanhGiaServlet?id=${review.maND}&action=delete">Xóa</a></li>
											</ul>
										</div>
									</c:if>
								</div>
								<input type="hidden" id="idNg" value="${review.maND}">
								<div class="customer-comment d-flex flex-row">
									<input type="text" id="cmtText"
										class="form-control mb-1 ms-5 border border-success rounded-3 bg-light text-success p-1"
										style="width: fit-content" name="reviewText" disabled
										value="${review.nhanXet != null ? review.nhanXet : ''}" /> 
								</div>

							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>

		<!-- Sản phẩm liên quan -->
		<div class="related-products">
			<h2>Sản phẩm liên quan</h2>
			<div class="related-products-container">
				<c:forEach var="list" items="${listProduct}">
					<div class="related-product-item">
						<a
							href="ChiTietSanPhamServlet?id=${list.maSP}&type=${list.maLoaiSP}">
							<img
							src="<%=request.getContextPath()%>/views/assets/images/HinhSanPham/${list.anhSP}"
							alt="${list.tenSP}" />
							<h3>${list.tenSP}</h3>
							<div class="price">${list.getPriceFormat()}</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- Toast để thông bao  -->
	<jsp:include page="/views/fragment/toast.jsp">
		<jsp:param name="msg" value="${msg}" />
		<jsp:param name="type" value="${typeMess}" />
	</jsp:include>

	<!-- Footer -->
	<jsp:include page="/views/fragment/footer.jsp" />

	<script>
		document.getElementById("idNgdung").value = document.getElementById("idNg").value;
      // Đổi hình ảnh chính khi bấm vào hình nhỏ
      function changeImage(thumbnail) {
        // Thay đổi ảnh chính
        document.getElementById("mainImage").src = thumbnail.src;

        // Xóa lớp "active" khỏi tất cả hình nhỏ
        const thumbnails = document.querySelectorAll(".thumbnail");
        thumbnails.forEach((thumb) => thumb.classList.remove("active"));

        // Thêm lớp "active" vào hình được chọn
        thumbnail.classList.add("active");
      }
</script>
</body>
</html>