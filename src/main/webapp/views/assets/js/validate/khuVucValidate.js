function validateForm() {
    var tenKV = document.forms["formKhuVuc"]["tenKV"].value.trim();
    var phiVanChuyen = document.forms["formKhuVuc"]["phiVanChuyen"].value.trim();

    // Kiểm tra Tên khu vực không được để trống
    if (tenKV === "") {
        alert("Vui lòng nhập Tên khu vực!");
        return false;
    }

    // Kiểm tra phí vận chuyển là một số dương
    if (phiVanChuyen === "" || isNaN(phiVanChuyen) || parseFloat(phiVanChuyen) <= 0) {
        alert("Vui lòng nhập phí vận chuyển hợp lệ!");
        return false;
    }

    return true;
}
