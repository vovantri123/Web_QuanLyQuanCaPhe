function validateForm() {
    var tenLoaiSP = document.forms["formLoaiSanPham"]["tenLoaiSP"].value.trim();
    var hinhLoaiSP = document.forms["formLoaiSanPham"]["hinhLoaiSP"].value.trim(); 
	
    // Kiểm tra Tên loại sản phẩm không được để trống
    if (tenLoaiSP === "") {
        alert("Vui lòng nhập Tên loại sản phẩm!");
        return false;
    }

    // Kiểm tra hình ảnh (nếu có tải lên)
    if (hinhLoaiSP === "" || !/\.(jpg|jpeg|png|gif)$/i.test(hinhLoaiSP)) {
        alert("Vui lòng chọn hình ảnh có định dạng JPG, JPEG, PNG hoặc GIF!");
        return false;
    }

    return true;
}
