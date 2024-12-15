
	document.addEventListener('DOMContentLoaded', function() {
		document.querySelector('.custom-file-input').addEventListener('change', function(e) {
		    var fileInput = e.target;  // Lấy phần tử input file từ sự kiện
		    if (fileInput.files.length > 0) {  // Kiểm tra xem có tệp nào được chọn không
		        var file = fileInput.files[0];  // Lấy tệp đầu tiên
		        var fileName = file.name || 'Chọn file...';
		
		
		        // Cập nhật giá trị của input[type="hidden"]
		        var hiddenInput = fileInput.parentElement.querySelector('.input-file-name');
		        hiddenInput.value = fileName;
		
		        var reader = new FileReader();
		        reader.onload = function(e) {
		            document.querySelector('.profile-image img').src = e.target.result;
		        };
		        reader.readAsDataURL(file); // Đọc file và gán kết quả base64 vào src ảnh
		    } else {
		        // Nếu không có tệp nào được chọn, có thể xử lý thông báo hay làm gì đó
		        console.log('No file selected');
		    }
		});
	});
