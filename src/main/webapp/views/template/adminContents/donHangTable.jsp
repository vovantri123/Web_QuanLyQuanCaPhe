<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"  %>

<h3 class="mb-3 mt-3 text-center font-weight-bold">Quản lý đơn hàng</h3> 

<div class="d-flex align-items-center justify-content-between">  
    <form class="input-group ml-auto mb-2 mt-1" method="get" style="width: auto;">  
        <!-- <input type="hidden" name="action" value="search" /> -->
        <div class="d-flex align-items-center">
            <label for="fromDate" class="mr-2 font-weight-bold">Từ ngày:</label>
            <input type="date" class="form-control mr-3" id="fromDate" name="fromDate">
            
            <label for="toDate" class="mr-2 font-weight-bold">Đến ngày:</label>
            <input type="date" class="form-control mr-3" id="toDate" name="toDate">
            
            <!-- Combobox lọc theo trạng thái -->
            <label for="trangThai" class="mr-2 font-weight-bold">Trạng thái:</label>
            <select class="form-control mr-3" id="trangThai" name="trangThai">
                <option value="">Tất cả</option>
                <option value="Đang giao">Đang giao</option>
                <option value="Đã giao">Đã giao</option>
                <option value="Đã hủy">Đã hủy</option>
            </select>
            
            <input class="btn btn-primary rounded" type="submit" value="Lọc">
        </div>
    </form>
</div>

<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr style="background-color: #edf3f9; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);">
            <th>Mã số</th>
            <th>Giá trị đơn</th>
            <th>Ngày mua</th>
            <th>Tên khu vực</th> 
            <th>Trạng thái</th>  
            <th>Chức năng</th>
        </tr>
    </thead>

    <tbody> 
        <c:forEach items="${donHangList}" var="dh">
            <tr>
                <td>${dh.maDH}</td> 
                <td><fmt:formatNumber value='${dh.giaTriDH}'/></td>  
                <td>
                    <fmt:formatDate value='${dh.ngayMua}' pattern="dd/MM/yyyy"/>
                </td>  
                <td>${dh.tenKV}</td>  
                <td>${dh.trangThai}</td> 
                <td>
                    <a href="<%=request.getContextPath()%>/BillServlet?maDH=${dh.maDH}" class="text-primary mr-3">
                        <i class="fas fa-eye"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody> 
</table>