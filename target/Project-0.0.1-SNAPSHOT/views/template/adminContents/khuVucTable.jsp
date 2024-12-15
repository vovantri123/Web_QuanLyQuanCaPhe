<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"  %>
  
 
<h3 class="mb-3 mt-3 text-center font-weight-bold">Quản lý khu vực vận chuyển</h3> 


<div class="d-flex align-items-center justify-content-between">
    <p>
        <a href="<%=request.getContextPath()%>/KhuVucServlet?action=add" class="btn btn-primary rounded">
            <i class="fas fa-plus-circle"></i> Thêm mới
        </a>
    </p>
 
	<form method="get" class="input-group" style="width: auto;">  
	    <input type="hidden" name="action" value="search" /> <!-- Nó tự lấy url chứa servlet hiện tại rồi thêm action là search vào, để action này lên  thẻ form thì nó k gửi được :v . thẻ a thì được hay sao á, ... luôn-->
	    <div class="position-relative">
	        <i class="fa fa-search position-absolute" style="top: 50%; left: 10px; transform: translateY(-50%);" ></i>  
	        <input type="text" class="form-control rounded" style="padding-left:40px" placeholder="Tìm tên khu vực" name="txtSearchTenKhuVuc"/>
	    </div>
	    <input class="btn btn-primary ml-2 rounded" type="submit" value="Tìm kiếm"> 
	</form>
</div>  

<table class="table table-bordered table-hover table-striped">
	<thead>
	    <tr style="background-color: #edf3f9; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);">
	        <th>Mã số</th>
	        <th>Tên khu vực</th>
	        <th>Phí vận chuyển</th>
         	<th>Chức năng</th> 
	    </tr>
	</thead>
	
	<tbody> 
		<!-- public KhuVuc(String maKV, String tenKV, float phiVanChuyen) -->
	    <c:forEach items="${khuVucList}" var="kv">
	        <tr>
	            <td>${kv.maKV}</td> 
	            <td>${kv.tenKV}</td>  
	            <td><fmt:formatNumber value='${kv.phiVanChuyen}'/></td>  
	              
			    <td>
				    <div class="btn-group d-flex justify-content-center"> 
				        <a href="<%=request.getContextPath()%>/KhuVucServlet?action=edit&maKV=${kv.maKV}" class="text-info mr-3" style="font-size: 20px;">
				            <i class="fas fa-edit"></i>
				        </a> 
				        <a href="<%=request.getContextPath()%>/KhuVucServlet?action=delete&maKV=${kv.maKV}" class="text-danger mr-3" onclick="return confirm('Bạn có chắc muốn xóa?');" style="font-size: 20px;">
				            <i class="fas fa-trash-alt"></i>
				        </a>
				    </div>
				</td> 
	        </tr>
	    </c:forEach>
	</tbody> 
</table>


