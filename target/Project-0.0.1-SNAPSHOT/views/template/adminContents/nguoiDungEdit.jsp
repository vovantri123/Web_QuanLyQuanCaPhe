<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"  %>

<script type="text/javascript" src="${pageContext.request.contextPath}/views/assets/js/validate/nguoiDungValidate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/assets/js/formatNumber.js"></script>

<h3 class="mb-4 text-center font-weight-bold">Chỉnh sửa Thông Tin Người Dùng</h3>

<form action="NguoiDungServlet?action=update" id="formNguoiDung"  method="post" enctype="multipart/form-data" onsubmit="return removeSeparators() && validateForm()" class="p-4 bg-light shadow rounded">
    
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
		            <img src="<%=request.getContextPath()%>/views/assets/images/HinhNguoiDung/${nguoiDung.anhND}" 
		                 onerror="this.src='https://via.placeholder.com/150x150'"
		                 alt="Placeholder Image"
		                 class="img-fluid img-thumbnail shadow-sm rounded"
		                 style="width: 150px; height: auto; max-width: 300px;  max-height: 300px;">
		        </div>
		    </div>
        </div>
        
         
        <!-- Cột 2: Các trường thông tin người dùng -->
        <div class="col-md-9">
            <!-- Mã người dùng (readonly) -->
            <div class="form-group">
                <label for="maND" class="font-weight-bold">Mã Người Dùng</label>
                <input type="text" class="form-control" id="maND" name="maND" value="${nguoiDung.maND}" readonly />
            </div>

            <!-- Họ và tên -->
            <div class="form-group">
                <label for="tenND" class="font-weight-bold">Họ và Tên</label>
                <input type="text" class="form-control" id="tenND" name="tenND" value="${nguoiDung.tenND}"/>
            </div>
            
            <!-- Giới tính -->
            <div class="form-group">
                <label for="gioiTinh" class="font-weight-bold">Giới Tính</label>
                <select class="form-control" id="gioiTinh" name="gioiTinh">
                    <option value="Nam" ${nguoiDung.gioiTinh == 'Nam' ? 'selected' : ''}>Nam</option>
                    <option value="Nữ" ${nguoiDung.gioiTinh == 'Nữ' ? 'selected' : ''}>Nữ</option>
                </select>
            </div>

            <!-- Năm sinh -->
            <div class="form-group">
                <label for="namSinh" class="font-weight-bold">Năm Sinh</label>
                <input type="number" class="form-control" id="namSinh" name="namSinh" value="${nguoiDung.namSinh}"/>
            </div>
        </div>
    </div>
 

    <!-- Số điện thoại -->
    <div class="form-group">
        <label for="sdt" class="font-weight-bold">Số Điện Thoại</label>
        <input type="text" class="form-control" id="sdt" name="sdt" value="${nguoiDung.sdt}"/>
    </div>

    <!-- Email -->
    <div class="form-group">
        <label for="email" class="font-weight-bold">Email</label>
        <input type="text" class="form-control" id="email" name="email" value="${nguoiDung.email}"/>
    </div>

    <!-- Địa chỉ -->
    <div class="form-group">
        <label for="diaChi" class="font-weight-bold">Địa Chỉ</label>
        <textarea class="form-control" id="diaChi" name="diaChi" rows="3">${nguoiDung.diaChi}</textarea>
    </div>
 
    <!-- Vai trò -->
    <div class="form-group">
        <label for="vaiTro" class="font-weight-bold" >Vai Trò</label>
        <select class="form-control" id="vaiTro" name="vaiTro" disabled>
            <option value="Admin" ${nguoiDung.vaiTro == 'Admin' ? 'selected' : ''}>Admin</option>
            <option value="User" ${nguoiDung.vaiTro == 'User' ? 'selected' : ''}>User</option>
        </select>
    </div>

    <!-- Tên đăng nhập -->
    <div class="form-group">
        <label for="tenDangNhap" class="font-weight-bold">Tên Đăng Nhập</label>
        <input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" value="${nguoiDung.tenDangNhap}"  />
    </div>

    <!-- Mật khẩu -->
    <div class="form-group">
        <label for="matKhau" class="font-weight-bold">Mật Khẩu</label>
        <input type="text" class="form-control" id="matKhau" name="matKhau" value="${nguoiDung.matKhau}"  />
    </div>
 
    <div class="form-group d-flex justify-content-center"> 
        <button type="submit" class="btn btn-primary mr-2" style="width:100px">Cập nhật</button>
        <a href="<%=request.getContextPath()%>/NguoiDungServlet" class="btn btn-secondary" style="width:100px">Hủy</a> 
	</div>
</form>

 