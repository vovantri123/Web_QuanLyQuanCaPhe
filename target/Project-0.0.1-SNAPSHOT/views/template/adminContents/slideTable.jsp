<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"  %>
  
  
 
<h3 class="mb-3 mt-3 text-center font-weight-bold">Quản lý slide</h3> 


<div class="d-flex align-items-center justify-content-between">
    <p>
        <a href="<%=request.getContextPath()%>/SlideServlet?action=add" class="btn btn-primary rounded">
            <i class="fas fa-plus-circle"></i> Thêm mới
        </a>
    </p>

    <form class="input-group" method="get" style="width: auto;">
	    <input type="hidden" name="action" value="filter" />
	    <div class="position-relative">
	        <i class="fa fa-filter position-absolute" style="top: 50%; left: 10px; transform: translateY(-50%);"></i>
	        <select class="form-control rounded" name="filterOption" style="padding-left:25px; padding-right:25px">
	            <option value="default">Mặc định</option>
	            <option value="position">Sắp xếp theo vị trí</option>
	        </select>
	    </div>
	    <input class="btn btn-primary ml-2 rounded" type="submit" value="Lọc"> 
	</form>

</div>  

<table class="table table-bordered table-hover table-striped">
	<thead>
	    <tr style="background-color: #edf3f9; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);">
	        <th>Mã số</th>
	        <th>Tên slide</th>
	        <th>Hình ảnh</th>
	        <th>Vị trí</th> 
	        <th>Trạng thái</th>
	        <th>Chức năng</th> 
	    </tr>
	</thead>
	
	<tbody> 
		<!-- public Slide(String maSilde, String tenSlide, String anhSlide, String viTri, String trangThai, String maND) -->
	    <c:forEach items="${slideList}" var="s">
	        <tr>
	            <td>${s.maSlide}</td>   
	            <td>${s.tenSlide}</td>  
	            <td><img src="<%=request.getContextPath()%>/views/assets/images/Slide/${s.anhSlide}" class="img-fluid rounded" style="width:725px; height: auto;"></td>  
	            <td>${s.viTri}</td>
	            <td >
	            	 <span class="badge p-2 font-weight-bold rounded-pill ${s.trangThai == 'Hiển thị' ? 'bg-success' : 'bg-danger'} text-white" style="min-width: 70px; text-align: center;">
					    ${s.trangThai}
					  </span>
	            </td>  
 
			    <td>
				    <div class="btn-group d-flex justify-content-center"> 
				        <a href="<%=request.getContextPath()%>/SlideServlet?action=edit&maSlide=${s.maSlide}" class="text-info mr-3" style="font-size: 20px;">
				            <i class="fas fa-edit"></i>
				        </a> 
				        <a href="<%=request.getContextPath()%>/SlideServlet?action=delete&maSlide=${s.maSlide}" class="text-danger mr-3" onclick="return confirm('Bạn có chắc muốn xóa?');" style="font-size: 20px;">
				            <i class="fas fa-trash-alt"></i>
				        </a>
				    </div>
				</td> 
	        </tr>
	    </c:forEach>
	</tbody> 
</table>