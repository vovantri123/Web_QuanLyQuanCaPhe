<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >  <!--  Bootstrap 4 từ CDN -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/assets/styles/hoadon.css" />
    
<body>
    <div class="invoice-container" id="invoice">
        <div class="invoice-header text-center">
            <h2>The Coffee House</h2>
            <p>Địa chỉ: 01 Đ. Võ Văn Ngân, Linh Chiểu, Thủ Đức, Hồ Chí Minh</p>
            <p>SĐT: 0972 228 083</p>
        </div>

        <!-- Invoice Info -->
        <div class="invoice-details">
            <div class="left">
                <p><strong>Mã hóa đơn:</strong> ${donHang.maDH}</p>
                <p><strong>Ngày mua:</strong> ${donHang.ngayMua}</p>
                <p><strong>Khu vực:</strong> ${donHang.tenKV}</p>
                <p><strong>Phương thức thanh toán:</strong> ${tenPTTT}</p>
                <p><strong>Tình trạng:</strong> Đã thanh toán</p>
            </div>
            <div class="right">
                <p><strong>Tên khách hàng:</strong> ${nguoiDung.tenND}</p>
                <p><strong>Giới tính:</strong> ${nguoiDung.gioiTinh}</p>
                <p><strong>Năm sinh:</strong> ${nguoiDung.namSinh}</p>
                <p><strong>Số điện thoại:</strong> ${nguoiDung.sdt}</p>
                <p><strong>Email:</strong> ${nguoiDung.email}</p>
            </div>
        </div>

        <!-- Invoice Table -->
        <table class="product-table">
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã SP</th>
                    <th>Tên SP</th>
                    <th>Giá</th>
                    <th>Số lượng</th>
                    <th>Tổng tiền</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cthd" items="${chiTietHoaDonList}" varStatus="status">
                    <tr>
                        <td class="text-center">${status.index + 1}</td>
                        <td>${cthd.maSP}</td>
                        <td>${cthd.tenSP}</td>
                        <td class="text-end"><fmt:formatNumber value="${cthd.gia}"/></td>
                        <td class="text-center">${cthd.soLuong}</td>
                        <td class="text-end"><fmt:formatNumber value="${cthd.tongTien}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="5" class="text-end fw-bold">Cộng tiền sản phẩm</td>
                    <td class="text-end"><fmt:formatNumber value="${tongTienSanPham}"/></td>
                </tr>
                <tr>
                    <td colspan="5" class="text-end fw-bold">Phí vận chuyển</td>
                    <td class="text-end"><fmt:formatNumber value="${phiVanChuyen}"/></td>
                </tr>
                <tr>
                    <td colspan="5" class="text-end fw-bold">Giảm</td>
                    <td class="text-end"><fmt:formatNumber value="${giam}"/></td>
                </tr>
                <tr>
                    <td colspan="5" class="text-end fw-bold">Thành tiền</td>
                    <td class="text-end"><fmt:formatNumber value="${thanhTien}"/></td>
                </tr>
            </tfoot>
        </table>
    </div>

    <!-- Print and action buttons -->
    <div class="print-button">
        <button onclick="printInvoice()" class="btn btn-success">In hóa đơn</button>
        <c:if test="${nguoiDung.vaiTro == 'Admin'}">
            <a href="<%=request.getContextPath()%>/DonHangServlet" class="btn btn-success">Quay Lại</a>
        </c:if>
        <c:if test="${nguoiDung.vaiTro == 'User'}">
            <a href="<%=request.getContextPath()%>/DonHangServlet" class="btn btn-success">Quay Lại</a>
        </c:if>
        <c:if test="${nguoiDung.vaiTro == 'User' && donHang.trangThai == 'Đang giao'}">
            <a href="<%=request.getContextPath()%>/DonHangServlet?suaTT=edit&maDH=${donHang.maDH}" class="btn btn-warning">Xác Nhận Đơn Hàng</a>
            <a href="<%=request.getContextPath()%>/DonHangServlet?huyTT=edit&maDH=${donHang.maDH}" class="btn btn-secondary">Hủy</a>
        </c:if>
    </div>
</body>
<script>
    function printInvoice() {
        window.print(); // Call the browser's print function
    }
</script>
</html>
