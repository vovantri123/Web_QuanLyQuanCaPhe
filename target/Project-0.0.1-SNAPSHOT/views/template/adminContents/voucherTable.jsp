<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"  %>
  
  
 
<h3 class="mb-3 mt-3 text-center font-weight-bold">Quản lý voucher</h3> 


<div class="d-flex align-items-center justify-content-between">
    <p>
        <a href="<%=request.getContextPath()%>/VoucherServlet?action=add" class="btn btn-primary rounded">
            <i class="fas fa-plus-circle"></i> Thêm mới
        </a>
    </p>

    <form class="input-group" method="get" style="width: auto;"> <!-- width:auto chiếm đủ nội dung của nó, còn không để thì nó sẽ chiếm hết chiều ngang màn hình -->
	    <input type="hidden" name="action" value="search" /> 
	    <div class="position-relative">
	        <i class="fa fa-search position-absolute" style="top: 50%; left: 10px; transform: translateY(-50%);" ></i>  
	        <input type="text" class="form-control rounded" style="padding-left:40px" placeholder="Tìm tên voucher" name="txtSearchTenVoucher"/>
	    </div>
	    <input class="btn btn-primary ml-2 rounded" type="submit" value="Tìm kiếm"> 
	</form>
</div>  

<table class="table table-bordered table-hover table-striped">
	<thead>
	    <tr style="background-color: #edf3f9; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);">
	        <th>Mã số</th>
	        <th>Tên voucher</th>
	        <th>Giá trị</th>
	        <th>Số lượt sử dụng tối đa</th>
	        <th>Số lượt đã sử dụng</th>
	        <th>Ngày bắt đầu</th>
	        <th>Ngày kết thúc</th>
	        <th>Tình trạng</th>
	        <th>Chức năng</th> 
	    </tr>
	</thead>
	
	<tbody>
		<!-- Lặp qua danh sách voucher -->
	    <c:forEach items="${voucherList}" var="v">
	        <tr>
	            <td>${v.maVC}</td> <!-- Mã voucher -->
	            <td>${v.tenVC}</td> <!-- Tên voucher -->
	            <td><fmt:formatNumber value='${v.giaTriVC}'/></td> <!-- Giá trị voucher -->
	            <td>${v.soLuotSuDungToiDa}</td> <!-- Số lượt sử dụng tối đa -->
	            <td>${v.soLuotDaSuDung}</td> <!-- Số lượt đã sử dụng -->
	            <td><fmt:formatDate value='${v.ngayBatDau}' pattern="dd/MM/yyyy"/></td> <!-- Ngày bắt đầu -->
	            <td><fmt:formatDate value='${v.ngayKetThuc}' pattern="dd/MM/yyyy"/></td> <!-- Ngày kết thúc -->
	            <td >
	            	 <span class="badge p-2 font-weight-bold rounded-pill ${v.trangThai == 'Hết lượt' || v.trangThai == 'Hết hạn' ? 'bg-danger' : 'bg-success'} text-white" style="min-width: 70px; text-align: center;">
					    ${v.trangThai}
					  </span>
	            </td>  
 
			    <td>
				    <div class="btn-group d-flex justify-content-center"> 
				        <a href="<%=request.getContextPath()%>/VoucherServlet?action=edit&maVC=${v.maVC}" class="text-info mr-3" style="font-size: 20px;">
				            <i class="fas fa-edit"></i>
				        </a> 
				        <a href="<%=request.getContextPath()%>/VoucherServlet?action=delete&maVC=${v.maVC}" class="text-danger mr-3" onclick="return confirm('Bạn có chắc muốn xóa?');" style="font-size: 20px;">
				            <i class="fas fa-trash-alt"></i>
				        </a>
				    </div>
				</td> 
	        </tr>
	    </c:forEach>
	</tbody> 
</table>


