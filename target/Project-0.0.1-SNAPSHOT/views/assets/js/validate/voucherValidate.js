function validateForm() { 
    var tenVC = document.forms["formVoucher"]["tenVC"].value.trim();
    var giaTriVC = document.forms["formVoucher"]["giaTriVC"].value.trim();
    var soLuotSuDungToiDa = document.forms["formVoucher"]["soLuotSuDungToiDa"].value.trim();
    var soLuotDaSuDung = document.forms["formVoucher"]["soLuotDaSuDung"].value.trim();
    var ngayBatDau = document.forms["formVoucher"]["ngayBatDau"].value.trim();
    var ngayKetThuc = document.forms["formVoucher"]["ngayKetThuc"].value.trim();

    // Kiểm tra các trường có giá trị
    if (tenVC === "") {
        alert("Vui lòng nhập Tên Voucher!");
        return false;
    }
    if (giaTriVC === "") {
        alert("Vui lòng nhập Giá trị Voucher!");
        return false;
    }
    if (soLuotSuDungToiDa === "") {
        alert("Vui lòng nhập Số lượt sử dụng tối đa!");
        return false;
    }
    if (soLuotDaSuDung === "") {
        alert("Vui lòng nhập Số lượt đã sử dụng!");
        return false;
    }
    if (ngayBatDau === "") {
        alert("Vui lòng chọn Ngày bắt đầu!");
        return false;
    }
    if (ngayKetThuc === "") {
        alert("Vui lòng chọn Ngày kết thúc!");
        return false;
    }

    // Cập nhật trạng thái voucher
    updateVoucherStatus();

    return true;
}

function updateVoucherStatus() {
    var soLuotSuDungToiDa = parseInt(document.forms["formVoucher"]["soLuotSuDungToiDa"].value.trim());
    var soLuotDaSuDung = parseInt(document.forms["formVoucher"]["soLuotDaSuDung"].value.trim());
    var ngayBatDau = document.forms["formVoucher"]["ngayBatDau"].value.trim();
    var ngayKetThuc = document.forms["formVoucher"]["ngayKetThuc"].value.trim();
    var startDate = new Date(ngayBatDau);
    var endDate = new Date(ngayKetThuc);
    var statusField = document.getElementById('trangThai');

    if (soLuotDaSuDung >= soLuotSuDungToiDa) {
        statusField.value = "Hết lượt";
    } else if (endDate >= startDate) {
        statusField.value = "Còn hạn";
    } else {
        statusField.value = "Hết hạn";
    }
}
