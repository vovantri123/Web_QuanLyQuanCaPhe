// Hàm định dạng số với dấu chấm cho phần ngàn 
function formatNumber(event) {
    var input = event.target;
    var value = input.value;

    // Loại bỏ tất cả ký tự không phải là số (nên không cho nhập dấu phẩy)
    value = value.replace(/\D/g, '');

    // Thêm dấu chấm phân cách phần ngàn
    value = value.replace(/\B(?=(\d{3})+(?!\d))/g, ".");
 
    input.value = value;
}

function removeSeparators() {
    var form = document.querySelector('form');  // Lấy form
    var inputs = form.querySelectorAll('input.so');  // Lấy tất cả input có class 'so'
    
    // Duyệt qua tất cả các input trong form
    inputs.forEach(function(input) {
        var value = input.value;

        // Loại bỏ dấu chấm phân cách ngàn
        if (value.includes('.')) {
            value = value.replace(/\./g, '');  // Loại bỏ tất cả dấu chấm
        }

        // Cập nhật lại giá trị cho input
        input.value = value;
    });

    return true;  // Trả về true để gửi form
}