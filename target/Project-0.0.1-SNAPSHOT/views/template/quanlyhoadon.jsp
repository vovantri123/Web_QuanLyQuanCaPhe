<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >  <!--  Bootstrap 4 từ CDN -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Icon trên trang font-awesome -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/assets/styles/style.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
	.content {
		margin-top: 100px;
	}
</style>
</head>
<body>
	<!-- Header -->
	<jsp:include page="/views/fragment/header.jsp">
		<jsp:param name="HoTen" value="${nguoiDung.tenND}" />
		<jsp:param name="Anh" value="${nguoiDung.anhND}" />
	</jsp:include>

	<div style="margin-left: 20px; margin-right: 20px" class="content">
		<div class="d-flex align-items-center justify-content-between">  
		    <form class="input-group ml-auto mb-2 mt-1" method="get" style="width: auto;">  
		        <!-- <input type="hidden" name="action" value="search" /> -->
		        <div class="d-flex align-items-center">
		            <label for="fromDate" class="mr-2 font-weight-bold">Từ ngày:</label>
		            <input type="date" class="form-control mr-3" id="fromDate" name="fromDate">
		            
		            <label for="toDate" class="mr-2 font-weight-bold">Đến ngày:</label>
		            <input type="date" class="form-control mr-3" id="toDate" name="toDate">
		            
		            <!-- Combobox lọc theo trạng thái -->
                    <label for="trangThai" class="mr-2 font-weight-bold">Trạng thái:</label>
                    <select class="form-control mr-3" id="trangThai" name="trangThai">
                        <option value="">Tất cả</option>
                        <option value="Đang giao">Đang giao</option>
                        <option value="Đã giao">Đã giao</option>
                        <option value="Đã hủy">Đã hủy</option>
                    </select>
		            
		            <input class="btn btn-primary rounded" type="submit" value="Lọc">
		        </div>
		    </form>
		</div>
		
		<table class="table table-bordered table-hover table-striped">
		    <thead>
		        <tr style="background-color: #edf3f9; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);">
		            <th>Mã số</th>
		            <th>Giá trị đơn</th>
		            <th>Ngày mua</th>
		            <th>Tên khu vực</th> 
		            <th>Trạng thái</th>  
		            <th>Chức năng</th>
		        </tr>
		    </thead>
		
		    <tbody> 
		        <c:forEach items="${donHangList}" var="dh">
		            <tr>
		                <td>${dh.maDH}</td> 
		                <td><fmt:formatNumber value='${dh.giaTriDH}'/></td>  
		                <td>
		                    <fmt:formatDate value='${dh.ngayMua}' pattern="dd/MM/yyyy"/>
		                </td>  
		                <td>${dh.tenKV}</td>  
		                <td>${dh.trangThai}</td> 
		                <td>
		                    <a href="<%=request.getContextPath()%>/BillServlet?maDH=${dh.maDH}&role=user" class="text-primary mr-3">
		                        <i class="fas fa-eye"></i>
		                    </a>
		                </td>
		            </tr>
		        </c:forEach>
		    </tbody> 
		</table>
	</div>
</body>
</html>