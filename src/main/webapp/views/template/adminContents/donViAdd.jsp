<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/views/assets/js/validate/donViValidate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/views/assets/js/formatNumber.js"></script>

<h3 class="mb-3 mt-3 text-center font-weight-bold">Thêm mới đơn vị</h3>

<form action="DonViServlet?action=insert" id="formDonVi" method="post" onsubmit="return removeSeparators() && validateForm()" class="p-4 bg-light shadow rounded">
	<input type="hidden"name="maDV"/>
	
    <!-- Tên đơn vị -->
    <div class="form-group">
        <label for="tenDV" class="font-weight-bold">Tên đơn vị</label>
        <input type="text" class="form-control" id="tenDV" name="tenDV"  />
    </div>

    <div class="form-group d-flex justify-content-center">
        <button type="submit" class="btn btn-primary mr-2" style="width:100px">Thêm mới</button>
        <a href="<%=request.getContextPath()%>/DonViServlet" class="btn btn-secondary" style="width:100px">Hủy</a>
    </div>
</form>
