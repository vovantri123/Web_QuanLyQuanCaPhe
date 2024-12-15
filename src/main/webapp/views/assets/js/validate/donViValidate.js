function validateForm() {
    var tenDV = document.forms["formDonVi"]["tenDV"].value.trim();

    // Kiểm tra Tên đơn vị không được để trống
    if (tenDV === "") {
        alert("Vui lòng nhập Tên đơn vị!");
        return false;
    }

    return true;
}
