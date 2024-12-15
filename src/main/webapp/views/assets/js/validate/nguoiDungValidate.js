function validateForm() {
    var tenND = document.forms["formNguoiDung"]["tenND"].value.trim();
    var namSinh = document.forms["formNguoiDung"]["namSinh"].value.trim();
    var sdt = document.forms["formNguoiDung"]["sdt"].value.trim();
    var email = document.forms["formNguoiDung"]["email"].value.trim();
    var diaChi = document.forms["formNguoiDung"]["diaChi"].value.trim();
    var vaiTro = document.forms["formNguoiDung"]["vaiTro"].value.trim();
    var tenDangNhap = document.forms["formNguoiDung"]["tenDangNhap"].value.trim();
    var matKhau = document.forms["formNguoiDung"]["matKhau"].value.trim();
    var hinhAnh = document.forms["formNguoiDung"]["anhND"].value.trim();  // Trường kiểm tra hình ảnh

    // Kiểm tra các trường không được để trống
    if (tenND === "") {
        alert("Vui lòng nhập Họ và Tên!");
        return false;
    }

    if (namSinh === "" || isNaN(namSinh) || parseInt(namSinh) < 1900 || parseInt(namSinh) > new Date().getFullYear()) {
        alert("Vui lòng nhập Năm Sinh hợp lệ!");
        return false;
    }

    if (sdt === "" || !/^\d{10}$/.test(sdt)) {
        alert("Vui lòng nhập Số Điện Thoại hợp lệ!");
        return false;
    }

    if (email === "" || !/\S+@\S+\.\S+/.test(email)) {
        alert("Vui lòng nhập Email hợp lệ!");
        return false;
    }

    if (diaChi === "") {
        alert("Vui lòng nhập Địa Chỉ!");
        return false;
    }

    if (vaiTro === "") {
        alert("Vui lòng chọn Vai Trò!");
        return false;
    }

    if (tenDangNhap === "") {
        alert("Vui lòng nhập Tên Đăng Nhập!");
        return false;
    }

    if (matKhau === "") {
        alert("Vui lòng nhập Mật Khẩu!");
        return false;
    }

    // Kiểm tra hình ảnh (nếu có tải lên)
    if (hinhAnh === "" || !/\.(jpg|jpeg|png|gif)$/i.test(hinhAnh)) {
        alert("Vui lòng chọn hình ảnh có định dạng JPG, JPEG, PNG hoặc GIF!");
        return false;
    }

    return true;
}
