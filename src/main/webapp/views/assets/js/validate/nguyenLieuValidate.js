function validateForm() {
    var tenNL = document.forms["formNguyenLieu"]["tenNL"].value.trim();
    var soLuongTonKho = document.forms["formNguyenLieu"]["soLuongTonKho"].value.trim();
    var maDV = document.forms["formNguyenLieu"]["maDV"].value.trim();

    // Kiểm tra các trường không được để trống
    if (tenNL === "") {
        alert("Vui lòng nhập Tên Nguyên Liệu!");
        return false;
    }

    if (soLuongTonKho === "" || isNaN(soLuongTonKho) || parseFloat(soLuongTonKho) <= 0) {
        alert("Vui lòng nhập Số lượng tồn kho hợp lệ!");
        return false;
    }

    if (maDV === "") {
        alert("Vui lòng chọn Đơn vị!");
        return false;
    }

    // Cập nhật trạng thái nguyên liệu (nếu có yêu cầu)
    updateNguyenLieuStatus();

    return true;
}

function updateNguyenLieuStatus() {
    var soLuongTonKho = parseInt(document.forms["formNguyenLieu"]["soLuongTonKho"].value.trim());
    var statusField = document.getElementById('trangThai');

    if (soLuongTonKho <= 0) {
        statusField.value = "Hết hàng";
    } else {
        statusField.value = "Còn hàng";
    }
}
