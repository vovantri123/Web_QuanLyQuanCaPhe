function validateForm() { 
	
    var tenSP = document.forms["formSanPham"]["tenSP"].value.trim();
    var giaSP = document.forms["formSanPham"]["giaSP"].value.trim();
    var maLoaiSP = document.forms["formSanPham"]["maLoaiSP"].value.trim();
	var hinhAnh = document.forms["formSanPham"]["anhSP"].value.trim();
    var moTaSP = CKEDITOR.instances["moTaSP"].getData().trim();

    // Kiểm tra các trường không được để trống
    if (tenSP === "") {
        alert("Vui lòng nhập Tên sản phẩm.");
        return false;
    }

    if (giaSP === "" || isNaN(giaSP) || parseFloat(giaSP) <= 0) {
        alert("Vui lòng nhập Giá sản phẩm là một số dương.");
        return false;
    }

    if (maLoaiSP === "") {
        alert("Vui lòng chọn Loại sản phẩm.");
        return false;
    }

    if (moTaSP === "") {
        alert("Vui lòng nhập Mô tả sản phẩm.");
        return false;
    }
	
	// Kiểm tra hình ảnh (nếu có tải lên)
    if (hinhAnh === "" || !/\.(jpg|jpeg|png|gif)$/i.test(hinhAnh)) {
        alert("Vui lòng chọn hình ảnh có định dạng JPG, JPEG, PNG hoặc GIF!");
        return false;
    }

    return true;
}
