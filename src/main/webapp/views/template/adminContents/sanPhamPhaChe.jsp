<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>   
    
<h4 class="mb-4 text-center font-weight-bold">Danh sách nguyên liệu để pha chế <span>"${tenSP}"</span></h4>
<form id="phaCheForm" action="PhaCheServlet" method="post" class="p-4 bg-light rounded shadow">    
    <input type="hidden" name="action" id="actionField" value="insert">
 
    <input type="hidden" name="maSP" value="${maSP}"> 
    <input type="hidden" name="tenSP" value="${tenSP}">
    
    <div class="form-row mb-4">
	    <div class="col-md-4 mb-3 form-group">
            <label for="nguyenLieu" class="font-weight-bold">Tên nguyên liệu</label>
            <select class="form-control" id="maNL" name="maNL">
                <c:forEach items="${nguyenLieuList}" var="nguyenLieu">
                    <option value="${nguyenLieu.maNL}">
                        ${nguyenLieu.tenNL}
                    </option>
                </c:forEach>
            </select>
        </div> 

        <div class="col-md-4 mb-3">
            <label class="font-weight-bold">Số lượng</label>
            <input type="number" class="form-control" name="soLuong"  value="1" min="1" step="1">
        </div>
		
        <!-- Thêm nguyên liệu -->
        <div class="col-md-4 mb-3 d-flex align-items-end">
            <button type="button" class="btn btn-primary" style="width:60px" onclick="submitForm('insert')">
                <i class="fas fa-plus"></i>  
            </button>
        </div>
    </div>
	
    <!-- Table -->
	<table class="table table-bordered table-hover table-striped">
	    <thead class="thead-light">
	        <tr style="background-color: #edf3f9; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);">
	            <th>Mã nguyên liệu</th>
	            <th>Tên nguyên liệu</th>
	            <th>Số lượng</th>
	            <th>Số lượng tồn kho</th>
	            <th>Chức năng</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${phaCheList}" var="pc">
	            <tr>
	                <td>${pc.maNL}</td>
	                <td>${pc.tenNL}</td>
	                <td>${pc.soLuong}</td>
	                <td>${pc.soLuongTonKho}</td>
	                <td>
	                    <!-- Xóa nguyên liệu -->
	                    <div class="btn-group d-flex justify-content-center">
	                        <a href="javascript:void(0);" class="btn btn-danger btn-sm" onclick="submitForm('delete', '${maSP}', '${pc.maNL}')">
	                            <i class="fas fa-trash-alt" style="width:40px"></i> <!-- Icon thùng rác từ Font Awesome -->
	                        </a>
	                    </div>
	                </td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	<div class="form-group d-flex justify-content-center">  
        <a href="<%=request.getContextPath()%>/SanPhamServlet" class="btn btn-secondary" style="width:100px">Quay lại</a> 
    </div>
</form>

<script>
    // Hàm để thay đổi action và gửi form
    function submitForm(action, maSP = '', maNL = '') { 
    	//alert("Action: " + action + "\nMã sản phẩm: " + maSP + "\nMã nguyên liệu: " + maNL);
    	
        var form = document.getElementById('phaCheForm');
        var actionField = document.getElementById('actionField');
        
        actionField.value = action; // Cập nhật action trong form
        
        // Nếu action là delete, thêm thông tin của nguyên liệu
        if (action === 'delete') {
            form.action = 'PhaCheServlet?action=delete'; // Đặt lại URL cho xóa
            form.elements['maSP'].value = maSP; // Cập nhật maSP
            form.elements['maNL'].value = maNL; // Cập nhật maNL
        } else {
            form.action = 'PhaCheServlet?action=insert'; // Đặt lại URL cho thêm nguyên liệu
        }

        // Gửi form
        form.submit();
    }
</script>
