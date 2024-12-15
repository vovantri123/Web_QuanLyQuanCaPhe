<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/views/fragment/head.html"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/style.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/chitietHD.css" />
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<!-- toast.css và toast.js -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/toast.css" />
<script src="<%=request.getContextPath()%>/views/assets/js/toast.js"></script>
</head>
<body>
	<!-- Include isp thông báo -->
	<jsp:include page="/views/fragment/toast.jsp">
		<jsp:param name="msg" value="${msg}" />
	</jsp:include>

    <!-- Header -->
	<jsp:include page="/views/fragment/header.jsp">
		<jsp:param name="HoTen" value="${nguoiDung.tenND}" />
		<jsp:param name="Anh" value="${nguoiDung.anhND}" />
	</jsp:include>

    <!-- Form cho combobox "Khu vực", gửi dữ liệu tới HoaDonServlet khi thay đổi -->
    <form action="HoaDonServlet" method="post">
        <div class="bill-container">
            <h1>Xác nhận đơn hàng</h1>
            <div class="content-wrapper">
                <div class="address-container">
                    <div class="section">
                        <h2><i class="fas fa-map-marker-alt"></i> Giao hàng</h2>
                        <div class="input-group">
                            <label>Khu vực</label>
                            <select name="khuVuc" onchange="this.form.submit()">
                                <c:forEach var="kv" items="${dSKhuVuc}">
                                    <option value="${kv.maKV}" <c:if test="${kv.maKV == sessionScope.maKV}">selected</c:if>>${kv.tenKV}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="section">
			           <h2><i class="fas fa-credit-card"></i> Phương thức thanh toán</h2>
			           <div class="input-group">
			               <select name="maPTTT" onchange="this.form.submit()">
			                   <c:forEach var="pT" items="${dSPTTT}">
			                       <option value="${pT.maPTTT}" <c:if test="${pT.maPTTT == sessionScope.maPTTT}">selected</c:if>>${pT.tenPTTT}</option>
			                   </c:forEach>
			               </select>
			           </div>
			       </div>
			       <div class="section input-group">
			           <h2><i class="fa-solid fa-ticket"></i> Mã giảm giá</h2>
			           <input type="text" name="maGiamGia" value="${sessionScope.maGiamGia != null ? sessionScope.maGiamGia : ''}" placeholder="Nhập mã giảm giá" style="width: 140px; padding: 5px; border: 1px solid #ccc; border-radius: 4px;">
			           <!-- Nút Áp dụng -->
					   <button type="submit" name="action" value="themVC" style="width: 140px; padding: 5px 10px; background-color: #ff9900; color: white; border: none; border-radius: 4px; cursor: pointer;">
					       Áp dụng
					   </button>					   
					   <!-- Nút Hủy -->
					   <button type="submit" name="action" value="huyVC" style="width: 140px; padding: 5px 10px; background-color: #f44336; color: white; border: none; border-radius: 4px; cursor: pointer;">
					       Hủy
					   </button>
					   <!-- Trường ẩn chứa giá trị của action -->
					   <input type="hidden" id="action" name="action" value="">
                   </div>
                </div>               
            </div>
        </div>       
    </form>

    <!-- Form chính cho việc đặt hàng, gửi dữ liệu tới ThanhToanServlet khi nhấn nút "Đặt hàng" -->
    <form action="ThanhToanServlet" method="POST">
        <div class="bill-container">
            <div class="content-wrapper">
                <div class="address-container">
                    <div class="section">
                        <h2><i class="fas fa-map-marker-alt"></i> Giao hàng</h2>
                        <!-- Các trường thông tin giao hàng khác -->
                        <div class="input-group">
                            <label>Địa chỉ chi tiết</label>
                            <input type="text" name="diaChi" value="${sessionScope.nguoiDung.diaChi != null ? sessionScope.nguoiDung.diaChi : ''}" placeholder="Nhập địa chỉ chi tiết" readonly>
                        </div>
                        <div class="input-group">
                            <label>Tên</label>
                            <input type="text" name="ten" value="${sessionScope.nguoiDung.tenND != null ? sessionScope.nguoiDung.tenND : ''}" placeholder="Nhập họ và tên" readonly>
                        </div>
                        <div class="input-group">
                            <label>Số điện thoại</label>
                            <input type="text" name="soDT" value="${sessionScope.nguoiDung.sdt != null ? sessionScope.nguoiDung.sdt : ''}" placeholder="Nhập số điện thoại" readonly>
                        </div>
                    </div>                              
                </div>

                <div class="order-container">
                    <div class="section-title"><i class="fas fa-utensils"></i> Các món đã chọn</div>
                    <c:forEach var="item" items="${cart}">
                        <div class="order-item">
                            <div>
                                <p>${item.soLuong} x ${item.tenSP}</p>
                                <p>Giá 1 Sản Phẩm: <fmt:formatNumber value="${item.giaSP}" type="number" pattern="#,##0" />đ</p>
                                <p class="remove-item"><a href="HoaDonServlet?maSP=${item.maSP}&action=delete">Xóa</a></p>
                            </div>
                            <p><fmt:formatNumber value="${item.giaSP*item.soLuong}" type="number" pattern="#,##0" />đ</p>
                        </div>
                    </c:forEach>
                    
                    <div class="add-item">
                        <a href="<%=request.getContextPath()%>/DanhMucSanPham"><i class="fas fa-plus-circle"></i> Thêm món</a>
                    </div>
                    <div class="section-title"><i class="fas fa-receipt"></i> Tổng cộng</div>
                    <div class="order-summary">
                        <div class="order-total">
                            <p>Thành tiền</p>                           
                            <p><fmt:formatNumber value="${thanhTien}" type="number" pattern="#,##0" />đ</p>
                            <input type="hidden" name="thanhTien" value="${thanhTien}" />
                        </div>
                        <div class="order-total">
                            <p>Phí giao hàng</p>
                            <p><fmt:formatNumber value="${sessionScope.kvPhi != null ? sessionScope.kvPhi : 0}" type="number" pattern="#,##0" />đ</p>
                        </div>
                         <div class="order-total">
					        <p>Giảm giá</p>
					        <p><fmt:formatNumber value="${sessionScope.giamGia != null ? sessionScope.giamGia : 0}" type="number" pattern="#,##0" />đ</p>
					    </div>
                        <div class="order-total">
					        <p>Tổng tiền</p>
						    <input type="hidden" name="tongTien" value="${(thanhTien + sessionScope.kvPhi <= sessionScope.giamGia) ? 0 : (thanhTien - sessionScope.giamGia + sessionScope.kvPhi)}" />						
						    <p><fmt:formatNumber value="${(thanhTien + sessionScope.kvPhi <= sessionScope.giamGia) ? 0 : (thanhTien - sessionScope.giamGia + sessionScope.kvPhi)}" type="number" pattern="#,##0" />đ</p>
					    </div>
                    </div>
                    <div class="place-order">
                        <button><i class="fas fa-shopping-cart"></i> Đặt hàng</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>