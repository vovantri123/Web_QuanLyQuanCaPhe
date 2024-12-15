<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hóa Đơn</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/views/assets/styles/hoadon.css" />
<script>
    function printInvoice() {
        window.print(); // Gọi hàm in của trình duyệt
    }
</script>
</head>
<body>
    <div class="invoice-container" id="invoice">
        <div class="invoice-header">HÓA ĐƠN</div>

        <div class="invoice-details">
            <div class="left">
                <p>Thời Gian: <c:out value="${ngayHT}" /></p>
                <p>Họ Tên: <c:out value="${ten}" /></p>
                <p>Điện thoại Khách hàng: <c:out value="${soDT}" /></p>
                <p>Địa chỉ Khách hàng: <c:out value="${diaChi}" /></p>
            </div>
            <div class="right">
                <p>Khu Vực: <c:out value="${tenKV}" /></p>
                <p>Mã Hóa Đơn: <c:out value="${maDH}" /></p>
                <p>Phương Thức Thanh Toán: <c:out value="${tenPTTT}" /></p>
                <p>Tình Trạng: Đang Giao</p>
            </div>
        </div>

        <table class="product-table">
            <thead>
                <tr>
                    <th>Sản Phẩm</th>
                    <th>Số lượng</th>
                    <th>Đơn giá</th>
                    <th>Thành tiền</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cart}">
                    <tr>
                        <td><c:out value="${item.tenSP}" /></td>
                        <td><c:out value="${item.soLuong}" /></td>
                        <td><fmt:formatNumber value="${item.giaSP}" type="number" pattern="#,##0" /> đ</td>
                        <td><fmt:formatNumber value="${item.giaSP * item.soLuong}" type="number" pattern="#,##0" /> đ</td>                    
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="totals">
            <p>Thành Tiền: <span><fmt:formatNumber value="${thanhTien}" type="number" pattern="#,##0" /> đ</span></p>
            <p>Phí Vận Chuyển: <span><fmt:formatNumber value="${phiVanChuyen}" type="number" pattern="#,##0" /> đ</span></p>
            <p>Giảm: <span><fmt:formatNumber value="${giamGia}" type="number" pattern="#,##0" /> đ</span></p>
            <p class="green">Tổng tiền thanh toán: 
			    <span>
			        <fmt:formatNumber value="${(thanhTien - giamGia + phiVanChuyen <= 0) ? 0 : (thanhTien - giamGia + phiVanChuyen)}" 
			                          type="number" pattern="#,##0" /> đ
			    </span>
			</p>
        </div>
    </div>
    <div class="print-button">
        <button onclick="printInvoice()">In Hóa Đơn</button>
        <a href="${pageContext.request.contextPath}/HoaDonServlet?action=xoaDH&maDH=${maDH}" class="back-link">Xác Nhận Đặt Hàng</a>
    </div>
</body>
</html>
