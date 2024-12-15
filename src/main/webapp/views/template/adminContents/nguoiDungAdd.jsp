<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/views/assets/js/validate/nguoiDungValidate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/assets/js/formatNumber.js"></script>

<h3 class="mb-4 text-center font-weight-bold">Thêm Mới Người Dùng</h3>

<form action="NguoiDungServlet?action=insert" id="formNguoiDung" method="post" enctype="multipart/form-data" onsubmit="return removeSeparators() && validateForm()" class="p-4 bg-light shadow rounded">
	<input type="hidden"name="maND"/>
	
    <!-- Row 1: Hình ảnh và thông tin người dùng -->
    <div class="form-group row">
        
        <!-- Cột 1: Hình ảnh -->
         <div class="col-md-3">
            <div class="form-group">
		        <label for="picture" class="font-weight-bold">Hình Ảnh</label>
		        <div class="custom-file">
		            <input type="file" class="custom-file-input" name="filename123"> <!-- cái name này đặt tên gì cũng được, nhưng phải có tên :v -->
		            
		            <label class="custom-file-label">Chọn hình ảnh</label>
		            <input type="hidden" name="anhND" value="${nguoiDung.anhND}" />
		        </div>
		
		        <div class="border p-3 text-center mt-3 bg-white">
		            <img src="" 
		                 onerror="this.src='https://via.placeholder.com/150x150'"
		                 alt="Placeholder Image"
		                 class="img-fluid img-thumbnail shadow-sm rounded"
		                 style="width: 150px; height: auto; max-width: 300px;  max-height: 300px;">
		        </div>
		    </div>
        </div>

        <!-- Cột 2: Các trường thông tin người dùng -->
        <div class="col-md-9">
            <!-- Họ và tên -->
            <div class="form-group">
                <label for="tenND" class="font-weight-bold">Họ và Tên</label>
                <input type="text" class="form-control" id="tenND" name="tenND"/>
            </div>
            
            <!-- Giới tính -->
            <div class="form-group">
                <label for="gioiTinh" class="font-weight-bold">Giới Tính</label>
                <select class="form-control" id="gioiTinh" name="gioiTinh">
                    <option value="Nam">Nam</option>
                    <option value="Nữ">Nữ</option>
                </select>
            </div>

            <!-- Năm sinh -->
            <div class="form-group">
                <label for="namSinh" class="font-weight-bold">Năm Sinh</label>
                <input type="number" class="form-control" id="namSinh" name="namSinh" />
            </div>
        </div>
    </div>
 

    <!-- Số điện thoại -->
    <div class="form-group">
        <label for="sdt" class="font-weight-bold">Số Điện Thoại</label>
        <input type="text" class="form-control" id="sdt" name="sdt"  />
    </div>

    <!-- Email -->
    <div class="form-group">
        <label for="email" class="font-weight-bold">Email</label>
        <input type="text" class="form-control" id="email" name="email"  />
    </div>

    <!-- Địa chỉ -->
    <div class="form-group">
        <label for="diaChi" class="font-weight-bold">Địa Chỉ</label>
        <textarea class="form-control" id="diaChi" name="diaChi" rows="3"></textarea>
    </div>
 
    <!-- Vai trò -->
    <div class="form-group">
        <label for="vaiTro" class="font-weight-bold" >Vai Trò</label>
        <select class="form-control" id="vaiTro" name="vaiTro" disabled> 	
            <option value="Admin">Admin</option>
            <option value="User" selected>User</option>
        </select>
    </div>

    <!-- Tên đăng nhập -->
    <div class="form-group">
        <label for="tenDangNhap" class="font-weight-bold">Tên Đăng Nhập</label>
        <input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" />
    </div>

    <!-- Mật khẩu -->
    <div class="form-group">
        <label for="matKhau" class="font-weight-bold">Mật Khẩu</label>
        <input type="password" class="form-control" id="matKhau" name="matKhau" />
    </div>
 
    <div class="form-group d-flex justify-content-center"> 
        <button type="submit" class="btn btn-primary mr-2" style="width:100px">Thêm</button>
        <a href="<%=request.getContextPath()%>/NguoiDungServlet" class="btn btn-secondary" style="width:100px">Hủy</a> 
    </div>
</form>
 
