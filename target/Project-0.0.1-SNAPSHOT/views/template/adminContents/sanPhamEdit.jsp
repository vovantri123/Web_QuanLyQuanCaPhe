<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/views/assets/js/validate/sanPhamValidate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/assets/js/formatNumber.js"></script>
 
<h3 class="mb-4 mt-4 text-center font-weight-bold">Chỉnh sửa sản phẩm</h3> 

<form action="SanPhamServlet?action=update" id="formSanPham" method="post" enctype="multipart/form-data" onsubmit="return removeSeparators() && validateForm()" class="p-4 bg-light rounded shadow">
    <!-- Row 1: Hình ảnh sản phẩm và thông tin sản phẩm -->
    <div class="form-group row">
        <!-- Cột 1: Hình ảnh sản phẩm --> 
	    <div class="col-md-4">
		    <div class="form-group">
	            <label for="picture" class="font-weight-bold">Hình sản phẩm</label>
				<div class="custom-file">
				    <input type="file" class="custom-file-input" name="filename123"> <!-- cái name này đặt tên gì cũng được, nhưng phải có tên :v -->
				   
				    <label class="custom-file-label">Chọn hình ảnh</label>
				    <input type="hidden" name="anhSP" value="${sanPham.anhSP}" />
				</div>
				
				<div class="border p-3 text-center mt-2 bg-white">
				     <img src="<%=request.getContextPath()%>/views/assets/images/HinhSanPham/${sanPham.anhSP}"
						onerror="this.src='https://via.placeholder.com/200x200'"
						alt="Placeholder Image"
						class="img-fluid img-thumbnail shadow-sm rounded"
						style="max-width: 200px; max-height: 200px;">
				</div>
		    </div>
		     
		</div>



        <!-- Cột 2: Các trường thông tin sản phẩm -->
        <div class="col-md-8"> 
            <!-- Mã sản phẩm -->
            <div class="form-group">
                <label for="maSP" class="font-weight-bold">Mã sản phẩm</label>
                <input type="text" class="form-control" id="maSP" name="maSP" value="${sanPham.maSP}" readonly>
            </div>

            <!-- Tên sản phẩm -->
            <div class="form-group">
                <label for="tenSP" class="font-weight-bold">Tên sản phẩm</label>
                <input type="text" class="form-control" id="tenSP" name="tenSP" value="${sanPham.tenSP}">
            </div>

            <!-- Giá sản phẩm -->
            <div class="form-group">
                <label for="giaSP" class="font-weight-bold">Giá sản phẩm</label>
                <div class="input-group">
                    <input type="text" class="form-control so" id="giaSP" name="giaSP" value="<fmt:formatNumber value='${sanPham.giaSP}'/>" oninput="formatNumber(event)">
                    <div class="input-group-append">
                        <span class="input-group-text">VNĐ</span>
                    </div>
                </div>
            </div>
            
            <!-- Loại sản phẩm -->
            <div class="form-group">
                <label for="maLoaiSP" class="font-weight-bold">Loại sản phẩm</label>
                <select class="form-control" id="maLoaiSP" name="maLoaiSP">
                    <c:forEach items="${loaiSPList}" var="loaiSP">
                        <option value="${loaiSP.maLoaiSP}" ${loaiSP.maLoaiSP == sanPham.maLoaiSP ? 'selected' : ''}>
                            ${loaiSP.tenLoaiSP}
                        </option>
                    </c:forEach>
                </select>
            </div> 
        </div>
    </div>

    <!-- Row 2: Mô tả sản phẩm -->
    <div class="form-group row">
        <div class="col-sm-12">
            <label for="moTaSP" class="font-weight-bold">Mô tả sản phẩm</label>
            <textarea class="form-control" id="moTaSP" name="moTaSP" rows="4">${sanPham.moTaSP}</textarea>
        </div>
    </div>

    <div class="form-group d-flex justify-content-center"> 
        <button type="submit" class="btn btn-primary mr-2" style="width:100px">Cập nhật</button>
        <a href="<%=request.getContextPath()%>/SanPhamServlet" class="btn btn-secondary" style="width:100px">Hủy</a> 
	</div>
</form>

<!-- CKEditor -->
<script>
    CKEDITOR.replace('moTaSP'); 
</script> 



 