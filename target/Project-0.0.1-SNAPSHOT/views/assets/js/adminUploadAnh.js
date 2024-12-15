document.addEventListener('DOMContentLoaded', function() {
    // Kiểm tra xem phần tử .custom-file-input có tồn tại không
    const fileInput = document.querySelector('.custom-file-input');
    if (fileInput) {
        // Nếu phần tử tồn tại, thêm sự kiện change
        fileInput.addEventListener('change', function(e) {
            var fileInput = e.target;  // Lấy phần tử input file từ sự kiện
            if (fileInput.files.length > 0) {  // Kiểm tra xem có tệp nào được chọn không
                var file = fileInput.files[0];  // Lấy tệp đầu tiên
                var fileName = file.name || 'Chọn file...';
        
                // Cập nhật giá trị của label ngay sau phần tử có class là '.custom-file-input'
                var label = fileInput.nextElementSibling;
                if (label) {
                    label.innerText = fileName;
                }

                // Cập nhật giá trị của input[type="hidden"]
                var hiddenInput = fileInput.parentElement.querySelector('input[type="hidden"]');
                if (hiddenInput) {
                    hiddenInput.value = fileName;
                }
        
                var reader = new FileReader();
                reader.onload = function(e) {
                    // Cập nhật ảnh trong .border img
                    var img = document.querySelector('.border img');
                    if (img) {
                        img.src = e.target.result;
                    }
                };
                reader.readAsDataURL(file); // Đọc file và gán kết quả base64 vào src ảnh
            }  
        });
    } 
});
