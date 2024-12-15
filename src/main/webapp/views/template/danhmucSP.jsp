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
	href="<%=request.getContextPath()%>/views/assets/styles/danhmucSP.css" />
<title>Danh mục sản phẩm</title>
</head>
<body>
	<div class="catalog-cont">
		<!-- Header -->
		<jsp:include page="/views/fragment/header.jsp">
			<jsp:param name="HoTen" value="${nguoiDung.tenND}" />
			<jsp:param name="Anh" value="${nguoiDung.anhND}" />
		</jsp:include>

		<!-- BEGIN CONTENT -->
		<div class="category-product-container">
			<!-- Sidebar Menu -->
			<aside class="category-sidebar">
				<ul>
					<li><a href="DanhMucSanPham?id=0">Tất Cả</a></li>
					<c:forEach var="list" items="${listLoaiSP}">
						<li><a href="DanhMucSanPham?id=${list.maLoaiSP}">${list.tenLoaiSP}</a></li>
					</c:forEach>
				</ul>
			</aside>

			<!-- Product Display Section -->

			<section class="products">
				<div class="product-card-grid">
					<c:choose>
						<c:when test="${not empty listSanPham}">
							<c:forEach var="product" items="${listSanPham}">
								<div class="product-card">
									<a
										href="ChiTietSanPhamServlet?id=${product.maSP}&type=${product.maLoaiSP}">
										<img
										src="<%=request.getContextPath()%>/views/assets/images/HinhSanPham/${product.anhSP}"
										alt="${product.tenSP}" />
										<h2>${product.tenSP}</h2>
										<p>${product.getPriceFormat()}</p>
									</a>
								</div>
							</c:forEach>
						</c:when>


						<c:otherwise>
							<c:forEach var="productList" items="${listToanBoSP}">

								<c:if test="${not empty productList.value}">
									<h2>${productList.value[0].tenLoaiSP}</h2>
									<div class="product-card-grid">
										<c:forEach var="product" items="${productList.value}">
											<div class="product-card">
												<a
													href="ChiTietSanPhamServlet?id=${product.maSP}&type=${product.maLoaiSP}">
													<img
													src="<%=request.getContextPath()%>/views/assets/images/HinhSanPham/${product.anhSP}"
													alt="${product.tenSP}" />
													<h2>${product.tenSP}</h2>
													<p>${product.getPriceFormat()}</p>
												</a>
											</div>
										</c:forEach>
									</div>
								</c:if>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
			</section>

		</div>

		<!-- END CONTENT -->

		<!-- Footer -->
		<jsp:include page="/views/fragment/footer.jsp" />
	</div>


</body>
</html>