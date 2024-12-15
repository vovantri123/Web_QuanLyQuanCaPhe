<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"  %>
  
  
<h3 class="mb-3 mt-3 text-center font-weight-bold">Quản lý người dùng</h3> 


<div class="d-flex align-items-center justify-content-between">
    <p>
        <a href="<%=request.getContextPath()%>/NguoiDungServlet?action=add" class="btn btn-primary rounded">
            <i class="fas fa-plus-circle"></i> Thêm mới
        </a>
    </p>

    <form class="input-group" method="get" style="width: auto;">  
	    <input type="hidden" name="action" value="search" />
	    <div class="position-relative">
	        <i class="fa fa-search position-absolute" style="top: 50%; left: 10px; transform: translateY(-50%);" ></i>  
	        <input type="text" class="form-control rounded" style="padding-left:40px" placeholder="Tìm tên người dùng" name="txtSearchTenNguoiDung"/>
	    </div>
	    <input class="btn btn-primary ml-2 rounded" type="submit" value="Tìm kiếm"> 
	</form>
</div>  

<table class="table table-bordered table-hover table-striped">
	<thead>
	    <tr style="background-color: #edf3f9; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);">
	        <th>Mã số</th>
	        <th>Họ và tên</th>
	        <th>Năm sinh</th>
	        <th>Giới tính</th> 
	        <th>SĐT</th>
	        <th>Email</th>
	        <th>Địa chỉ</th>
	        <th>Hình ảnh</th>
	        <th>Vai trò</th>
	        <th>Tên đăng nhập</th>
	        <th>Mật khẩu</th> 
	        <th>Chức năng</th> 
	    </tr>
	</thead>
	
	<tbody> 
		<!-- public NguoiDung(String maND, String tenND, int namSinh, String gioiTinh, String sdt, String email, String diaChi,
			String anhND, String vaiTro, String tenDangNhap, String matKhau) -->
	    <c:forEach items="${nguoiDungList}" var="nd">
	        <tr>
	            <td>${nd.maND}</td>   
	            <td>${nd.tenND}</td> 
	            <td>${nd.namSinh}</td> 
	            <td>${nd.gioiTinh}</td>
	            <td>${nd.sdt}</td>   
	            <td>${nd.email}</td> 
	            <td>${nd.diaChi}</td> 
	            <td><img src="<%=request.getContextPath()%>/views/assets/images/HinhNguoiDung/${nd.anhND}" class="img-fluid rounded" style="width:100px; height: auto;"></td>  
	            <td>${nd.vaiTro}</td>   
	            <td>${nd.tenDangNhap}</td> 
	            <td>${nd.matKhau}</td>  
 
			    <td>
				    <div class="btn-group d-flex justify-content-center"> 
				        <a href="<%=request.getContextPath()%>/NguoiDungServlet?action=edit&maND=${nd.maND}" class="text-info mr-3" style="font-size: 20px;">
				            <i class="fas fa-edit"></i>
				        </a> 
				        <a href="<%=request.getContextPath()%>/NguoiDungServlet?action=delete&maND=${nd.maND}" class="text-danger mr-3" onclick="return confirm('Bạn có chắc muốn xóa?');" style="font-size: 20px;">
				            <i class="fas fa-trash-alt"></i>
				        </a>
				    </div>
				</td> 
	        </tr>
	    </c:forEach>
	</tbody> 
</table>