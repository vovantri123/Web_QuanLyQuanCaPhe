<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container my-4">
    <!-- Header cards -->
    <div class="row">
    <div class="col-md-4">
        <div class="card text-white bg-primary mb-3" style="border-radius: 7px; box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);">
            <div class="card-body d-flex align-items-center">
                <i class="fas fa-chart-line fa-3x mr-4"></i>
                <div class="text-left">
                    <h4 class="card-title">Tổng doanh thu</h4> 
                    <h2 class="card-text"><fmt:formatNumber value="${totalRevenue}"/> VND</h2>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-4">
        <div class="card text-white bg-success mb-3" style="border-radius: 7px; box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);">
            <div class="card-body d-flex align-items-center">
                <i class="fas fa-box-open fa-3x mr-4"></i>
                <div class="text-left">
                    <h4 class="card-title">Đã bán được</h4>
                    <h2 class="card-text">${totalProducts} Sản phẩm</h2>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-4">
        <div class="card text-white bg-info mb-3" style="border-radius: 7px; box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);">
            <div class="card-body d-flex align-items-center">
                <i class="fas fa-users fa-3x mr-4"></i>
                <div class="text-left">
                    <h4 class="card-title">Tổng khách hàng</h4>
                    <h2 class="card-text">${totalCustomers} Người</h2>
                </div>
            </div>
        </div>
    </div>
</div>
    	
    
    <!-- Charts Section -->
    <div class="row mt-4">
        <div class="col-md-8">
            <div class="chart-container">
                <h5>Số lượng bán được trên từng sản phẩm</h5>
                <canvas id="revenueByProductChart"></canvas>
            </div>
        </div>
        <div class="col-md-4">
            <div class="chart-container">
                <h5>Tỷ lệ % doanh thu theo sản phẩm</h5>
                <canvas id="salesRatioChart"></canvas>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-8">
            <div class="chart-container">
                <h5>Doanh thu theo thời gian</h5>
                <canvas id="productSoldChart"></canvas>
            </div>
        </div>
        <div class="col-md-4">
            <div class="chart-container">
                <h5>Lọc dữ liệu</h5> 
                <form action="DashBoardServlet?action=update" method="get">
                    <div class="form-group">
                        <label for="startDate">Từ Ngày</label>
                        <input type="date" id="startDate" name="startDate" class="form-control" value="${startDate}">
                    </div>
                    <div class="form-group">
                        <label for="endDate">Đến Ngày</label>
                        <input type="date" id="endDate" name="endDate" class="form-control" value="${endDate}">
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Tìm Thống Kê</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    var ctx1 = document.getElementById('revenueByProductChart').getContext('2d');
    var ctx2 = document.getElementById('salesRatioChart').getContext('2d');
    var ctx3 = document.getElementById('productSoldChart').getContext('2d');
    
    // Hàm sinh màu ngẫu nhiên
    function generateRandomColor() {
        const letters = '0123456789ABCDEF';
        let color = '#';
        for (let i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }
    
    // Tạo một đối tượng để lưu màu sắc của sản phẩm
    const productColorMap = {};

    // Hàm để lấy màu cho mỗi sản phẩm, nếu chưa có sẽ tạo mới
    function getColorForProduct(productName) {
        if (!productColorMap[productName]) {
            productColorMap[productName] = generateRandomColor();
        }
        return productColorMap[productName];
    }
    
    // Biểu đồ cột Số lượng bán được trên từng sản phẩm  
    const sanPhamLabels = [];
    const soLuongData = [];
    <c:forEach var="item" items="${sanPhamVaSoLuong}">
        sanPhamLabels.push('${item["TenSP"]}');
        soLuongData.push(${item["TongSoLuong"]});
    </c:forEach>;

    new Chart(ctx1, {
        type: 'bar',
        data: {
            labels: sanPhamLabels,
            datasets: [{
                label: 'Số lượng đã bán',
                data: soLuongData,
                backgroundColor: sanPhamLabels.map(getColorForProduct),  // Gán màu cố định cho mỗi sản phẩm
                borderColor: sanPhamLabels.map(product => getColorForProduct(product)),
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: { beginAtZero: true }
            }
        }
    });

    // Biểu đồ tròn Tỷ lệ % doanh thu theo sản phẩm
    const doanhThuLabels = [];
    const doanhThuData = [];
    const doanhThuColors = [];
    <c:forEach var="item" items="${sanPhamVaTongTien}">
        doanhThuLabels.push('${item["TenSP"]}');
        doanhThuData.push(${item["TongTien"]});
        doanhThuColors.push(getColorForProduct('${item["TenSP"]}')); // Sử dụng màu cố định cho mỗi sản phẩm
    </c:forEach>;

    new Chart(ctx2, {
        type: 'pie',
        data: {
            labels: doanhThuLabels,
            datasets: [{
                data: doanhThuData,
                backgroundColor: doanhThuColors, // Màu cố định cho các phần tử
                borderColor: 'rgba(0, 0, 0, 0.125)', // Viền màu
                borderWidth: 1
            }]
        },
        options: {
            responsive: true
        }
    });
     
</script>

<script>
	//Biểu đồ đường Doanh thu theo thời gian
	const ngayMuaLabels = [];
	const giaTriData = [];
	<c:forEach var="item" items="${ngayMuaVaGiaTri}">
	    ngayMuaLabels.push('${item["NgayMua"]}');
	    giaTriData.push(${item["GiaTriDH"]});
	</c:forEach>;
	
	new Chart(ctx3, {
	    type: 'line',
	    data: {
	        labels: ngayMuaLabels,
	        datasets: [{
	            label: 'Doanh thu (VND)',
	            data: giaTriData,
	            backgroundColor: '#17a2b8',
	            borderColor: '#17a2b8',
	            fill: false,
	            tension: 0.1
	        }]
	    },
	    options: {
	        responsive: true,
	        scales: {
	            y: { beginAtZero: true }
	        }
	    }
	});
</script>