<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"  %>

<script type="text/javascript" src="${pageContext.request.contextPath}/views/assets/js/validate/voucherValidate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/assets/js/formatNumber.js"></script>
        
<h3 class="text-center mb-3 mt-3">Chỉnh sửa Voucher</h3> 

<form action="VoucherServlet?action=update" id="formVoucher" method="post" name="formVoucher" onsubmit="return removeSeparators() && validateForm()">
    <!-- Giả sử bạn đã có các giá trị voucher trong các biến JSP (ví dụ: voucher.getMaVC()) -->
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="maVC">Mã Voucher</label>
            <input type="text" class="form-control" id="maVC" name="maVC" value="${voucher.maVC}" readonly />
        </div>
        <div class="form-group col-md-6">
            <label for="tenVC">Tên Voucher</label>
            <input type="text" class="form-control" id="tenVC" name="tenVC" value="${voucher.tenVC}"/>
        </div>
    </div>
    
    <div class="form-group">
	    <label >Giá trị Voucher</label> 
	    <input type="text" class="form-control so"  name="giaTriVC" 
	       value="<fmt:formatNumber value='${voucher.giaTriVC}'/>" oninput="formatNumber(event)" />
	</div>


    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="soLuotSuDungToiDa">Số lượt sử dụng tối đa</label>
            <input type="number" class="form-control" id="soLuotSuDungToiDa" name="soLuotSuDungToiDa" value="${voucher.soLuotSuDungToiDa}" min="0" step="1"/>
        </div>
        <div class="form-group col-md-6">
            <label for="soLuotDaSuDung">Số lượt đã sử dụng</label>
            <input type="number" class="form-control" id="soLuotDaSuDung" name="soLuotDaSuDung" value="${voucher.soLuotDaSuDung}" min="0" step="1"/>
        </div>
    </div>
    <div class="form-row">
	    <div class="form-group col-md-6">
	        <label for="ngayBatDau">Ngày bắt đầu</label>
	        <input type="date" class="form-control" id="ngayBatDau" name="ngayBatDau" value="${voucher.ngayBatDau}" />
	    </div>
	    <div class="form-group col-md-6">
	        <label for="ngayKetThuc">Ngày kết thúc</label>
	        <input type="date" class="form-control" id="ngayKetThuc" name="ngayKetThuc" value="${voucher.ngayKetThuc}"/>
	    </div>
	</div>
	<div class="form-group">
	    <!-- <label for="trangThai">Trạng thái</label> -->
	    <input type="hidden" class="form-control" id="trangThai" name="trangThai" value="${voucher.trangThai}"/>
	</div>
    
    <div class="form-group d-flex justify-content-center"> 
        <button type="submit" class="btn btn-primary mr-2" style="width:100px">Cập nhật</button>
        <a href="<%=request.getContextPath()%>/VoucherServlet" class="btn btn-secondary" style="width:100px">Hủy</a> 
	</div>
</form> 


 