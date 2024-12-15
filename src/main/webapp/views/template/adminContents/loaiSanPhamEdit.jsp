<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"  %>

<script type="text/javascript" src="${pageContext.request.contextPath}/views/assets/js/validate/loaiSanPhamValidate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/assets/js/formatNumber.js"></script>

<h3 class="mb-3 mt-3 text-center font-weight-bold">Chỉnh sửa loại sản phẩm</h3>

<form action="LoaiSanPhamServlet?action=update" id = "formLoaiSanPham" method="post" onsubmit="return removeSeparators() && validateForm()" enctype="multipart/form-data"> 
    
    <div class="form-group">
        <label for="maLoaiSP" class="font-weight-bold">Mã loại sản phẩm</label> 
        <input type="text" class="form-control" id="maLoaiSP" name="maLoaiSP" value="${loaiSanPham.maLoaiSP}" readonly />
    </div>

    <div class="form-group">
        <label for="tenLoaiSP" class="font-weight-bold">Tên loại sản phẩm</label> 
        <input type="text" class="form-control" id="tenLoaiSP" name="tenLoaiSP" value="${loaiSanPham.tenLoaiSP}">
    </div>

    <div class="form-group ">   
        <label for="picture" class="font-weight-bold">Hình loại sản phẩm</label>
        <div class="custom-file">
            <input type="file" class="custom-file-input" name="filename123"> <!-- cái name này đặt tên gì cũng được, nhưng phải có tên :v -->
            
            <label class="custom-file-label">Chọn hình ảnh</label>
            <input type="hidden" name="hinhLoaiSP" value="${loaiSanPham.hinhLoaiSP}" />
        </div>

        <div class="border p-3 text-center mt-3 bg-white">
            <img src="<%=request.getContextPath()%>/views/assets/images/HinhSanPham/${loaiSanPham.hinhLoaiSP}" 
           		 class="img-fluid rounded"  
                 onerror="this.src='https://via.placeholder.com/200x220'"
                 alt="Placeholder Image"
                 class="img-fluid img-thumbnail shadow-sm rounded"
                 style="max-width: 200px;  max-height: 220px;">
        </div>
    </div>  
   
    <div class="form-group d-flex justify-content-center"> 
        <button type="submit" class="btn btn-primary mr-2" style="width:100px">Cập nhật</button>
        <a href="<%=request.getContextPath()%>/LoaiSanPhamServlet" class="btn btn-secondary" style="width:100px">Hủy</a> 
	</div>
</form>
 