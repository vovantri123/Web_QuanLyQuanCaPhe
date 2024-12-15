<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"  %>
  
 
<h3 class="mb-3 mt-3 text-center font-weight-bold">Quản lý nguyên liệu</h3> 


<div class="d-flex align-items-center justify-content-between">
    <p>
        <a href="<%=request.getContextPath()%>/NguyenLieuServlet?action=add" class="btn btn-primary rounded">
            <i class="fas fa-plus-circle"></i> Thêm mới
        </a>
    </p>

    <form class="input-group" method="get" style="width: auto;">  
	    <input type="hidden" name="action" value="search"/> 
	    <div class="position-relative">
	        <i class="fa fa-search position-absolute" style="top: 50%; left: 10px; transform: translateY(-50%);" ></i>  
	        <input type="text" class="form-control rounded" style="padding-left:40px" placeholder="Tìm tên nguyên liệu" name="txtSearchTenNguyenLieu"/>
	    </div>
	    <input class="btn btn-primary ml-2 rounded" type="submit" value="Tìm kiếm"> 
	</form>
</div>  

<table class="table table-bordered table-hover table-striped">
	<thead>
	    <tr style="background-color: #edf3f9; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);">
	        <th>Mã số</th>
	        <th>Tên nguyên liệu</th>
	        <th>Số lượng tồn kho</th>
         	<th>Tên đơn vị</th> 
         	<th>Chức năng</th> 
	    </tr>
	</thead>
	
	<tbody> 
		<!-- public NguyenLieu(String maNL, String tenNL, int soLuongTonKho, String maDV, String tenDV)  -->
	    <c:forEach items="${nguyenLieuList}" var="nl">
	        <tr>
	            <td>${nl.maNL}</td> 
	            <td>${nl.tenNL}</td>  
	            <td>${nl.soLuongTonKho}</td>  
	            <td>${nl.tenDV}</td>  
	              
			    <td>
				    <div class="btn-group d-flex justify-content-center"> 
				        <a href="<%=request.getContextPath()%>/NguyenLieuServlet?action=edit&maNL=${nl.maNL}" class="text-info mr-3" style="font-size: 20px;">
				            <i class="fas fa-edit"></i>
				        </a> 
				        <a href="<%=request.getContextPath()%>/NguyenLieuServlet?action=delete&maNL=${nl.maNL}" class="text-danger mr-3" onclick="return confirm('Bạn có chắc muốn xóa?');" style="font-size: 20px;">
				            <i class="fas fa-trash-alt"></i>
				        </a>
				    </div>
				</td> 
	        </tr>
	    </c:forEach>
	</tbody> 
</table>


