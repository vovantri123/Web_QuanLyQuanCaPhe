function validateForm() { 
    var tenSlide = document.forms["formSlide"]["tenSlide"].value.trim();
    var viTri = document.forms["formSlide"]["viTri"].value.trim();
	var hinhAnh = document.forms["formSlide"]["anhSlide"].value.trim();

    // Kiểm tra tên slide
    if (tenSlide === "") {
        alert("Vui lòng nhập Tên Slide!");
        return false;
    }

    // Kiểm tra vị trí
    if (viTri === "") {
        alert("Vui lòng nhập Vị trí Slide!");
        return false;
    } 
	
	// Kiểm tra hình ảnh (nếu có tải lên)
    if (hinhAnh === "" || !/\.(jpg|jpeg|png|gif)$/i.test(hinhAnh)) {
        alert("Vui lòng chọn hình ảnh có định dạng JPG, JPEG, PNG hoặc GIF!");
        return false;
    }

    return true;
}
