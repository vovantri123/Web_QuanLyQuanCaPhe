<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@ include file="/views/fragment/head.html"%>  --%>
 
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"  %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>admin</title>
	 
	 
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >  <!--  Bootstrap 4 từ CDN -->

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Icon trên trang font-awesome -->
     
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/assets/styles/admin.css"/>  <!-- admin.css và admin.js-->
	<script src="<%=request.getContextPath()%>/views/assets/js/admin.js"></script> 
	
	<script src="ckeditor/ckeditor.js"></script> <!-- CKEditor là một trình soạn thảo WYSIWYG cho phép người dùng tạo và chỉnh sửa nội dung văn bản một cách dễ dàng, với giao diện trực quan. -->
 	
 	<script src="<%=request.getContextPath()%>/views/assets/js/adminUploadAnh.js"></script> 
 	
 	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script> <!-- nhúng Chart.js, một thư viện JavaScript phổ biến dùng để tạo các biểu đồ tương tác trên trang web. -->
 	
 	
 	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/assets/styles/themeDark.css"/> 
  	<script src="<%=request.getContextPath()%>/views/assets/js/theme.js"></script> 
	
 	
	<style>   
		 
	@media print {

	    /* Ẩn hoàn toàn drawer nhưng không chiếm không gian */
	    #drawer {
	        display: none !important;
	    }
	}

 
	</style>
</head>
<body>
	<script>
	    // Phát sự kiện "contentLoaded" khi nội dung JSP được thêm
	    document.dispatchEvent(new Event("contentLoaded"));
	</script> 

  	<!-- Fullscreen -->
	<div class="container-fluid">
		<div class="row">
			<!-- Drawer Menu nằm bên trái, chiếm col-3, còn lại là của content sẽ chiếm 9 hoặc 12 -->
		 	<div id="drawer" class="col-3 bg-light p-3">
			    <img src="<%=request.getContextPath()%>/views/assets/favicon/logo2.png" 
			         alt="Coffee Logo" 
			         class="drawer-logo img-fluid rounded-circle mb-3"/>
			    <ul class="list-group">
			        <li class="list-group-item list-group-item-action" id="dashboard">
			            <a href="<%=request.getContextPath()%>/DashBoardServlet" class="d-flex align-items-center"><i class="fas fa-tachometer-alt icon mr-2"></i><span class="menu-text">Dashboard</span></a>
			        </li>
			        <li class="list-group-item list-group-item-action" id="ingredients">
			            <a href="<%=request.getContextPath()%>/NguyenLieuServlet" class="d-flex align-items-center"><i class="fas fa-cogs icon mr-2"></i><span class="menu-text">Ingredients</span></a>
			        </li>
			        <li class="list-group-item list-group-item-action" id="units">
			            <a href="<%=request.getContextPath()%>/DonViServlet" class="d-flex align-items-center"><i class="fas fa-ruler icon mr-2"></i><span class="menu-text">Units</span></a>
			        </li>
			        <li class="list-group-item list-group-item-action" id="categories">
			            <a href="<%=request.getContextPath()%>/LoaiSanPhamServlet" class="d-flex align-items-center"><i class="fas fa-th-large icon mr-2"></i><span class="menu-text">Categories</span></a>
			        </li>
			        <li class="list-group-item list-group-item-action" id="products">
			            <a href="<%=request.getContextPath()%>/SanPhamServlet" class="d-flex align-items-center"><i class="fas fa-box icon mr-2"></i><span class="menu-text">Products</span></a>
			        </li>
			        <li class="list-group-item list-group-item-action" id="vouchers">
			            <a href="<%=request.getContextPath()%>/VoucherServlet" class="d-flex align-items-center"><i class="fas fa-gift icon mr-2"></i><span class="menu-text">Vouchers</span></a>
			        </li>
			        <li class="list-group-item list-group-item-action" id="shipping">
			            <a href="<%=request.getContextPath()%>/KhuVucServlet" class="d-flex align-items-center"><i class="fas fa-truck icon mr-2"></i><span class="menu-text">Shipping</span></a>
			        </li>
			        <li class="list-group-item list-group-item-action" id="orders">
			            <a href="<%=request.getContextPath()%>/DonHangServlet" class="d-flex align-items-center"><i class="fas fa-clipboard-list icon mr-2"></i><span class="menu-text">Orders</span></a>
			        </li>
			        <li class="list-group-item list-group-item-action" id="accounts">
			            <a href="<%=request.getContextPath()%>/NguoiDungServlet" class="d-flex align-items-center"><i class="fas fa-users icon mr-2"></i><span class="menu-text">Accounts</span></a>
			        </li> 
			        <li class="list-group-item list-group-item-action" id="slides">
			            <a href="<%=request.getContextPath()%>/SlideServlet" class="d-flex align-items-center"><i class="fas fa-images icon mr-2"></i><span class="menu-text">Slides</span></a>
			        </li> 
			       <!--  <li class="list-group-item list-group-item-action" id="logOut">
			            <a href="#" class="d-flex align-items-center" onclick="return confirm('Bạn có chắc muốn đăng xuất?');"><i class="fas fa-sign-out-alt icon mr-2"></i><span class="menu-text">Log out</span></a>
			        </li> -->
			    </ul>
			</div>
		
			<!-- Content nằm bên phải-->
			<div id="content" class="col bg-white p-3">  
				<div class="row" >  
					<!-- Header -->
					<jsp:include page="/views/template/adminContents/headerAdmin.jsp"/> 
				</div> 
				<div class="row" style="margin-top:63px">
					<div class="col-12"> <!-- Chiếm hết màn hình bên phải -->
					 
						<%-- <p>Thông báo: ${msg}</p>  --%> 
					  	<%-- <div onclick="showInformationToast('${msg}');" class="custom-btn custom-btn--success">Show Information toast</div>  --%>
		 					
		 				<jsp:include page="/views/fragment/toast.jsp">
							<jsp:param name="msg" value="${msg}" />
						</jsp:include>
						   
						<%--  <jsp:include page="adminContents/slideEdit.jsp"></jsp:include>   --%>
						<!-- Include page -->   
						<div id="content-page">
							<c:if test="${!(empty param.page)}"> 
								<jsp:include page="adminContents/${param.page}.jsp"></jsp:include>
							</c:if>  
						</div> 
					</div>
				</div>
			</div>
		</div>
	</div>

	 <!-- Thêm các tệp JavaScript của Bootstrap từ CDN -->
 	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>  
</body>
</html>