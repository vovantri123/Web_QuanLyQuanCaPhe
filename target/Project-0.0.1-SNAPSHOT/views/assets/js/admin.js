document.addEventListener("DOMContentLoaded", function() {
    // Xử lý mở/đóng drawer
    const toggleDrawerBtn = document.getElementById("toggleDrawerBtn");
    const drawer = document.getElementById("drawer");
    const content = document.getElementById("content");
    const header = document.querySelector('header');

    if (toggleDrawerBtn && drawer && content && header) {
        toggleDrawerBtn.addEventListener("click", function() {
            // Thêm hoặc bỏ class 'hide' để điều khiển việc ẩn/hiện của drawer
            drawer.classList.toggle("hide");
            content.classList.toggle("shifted"); // Đẩy nội dung chính sang trái khi drawer ẩn

            // Cập nhật header
            if (drawer.classList.contains("hide")) {
                header.classList.add("full-width"); // Khi drawer ẩn, header full chiều ngang
            } else {
                header.classList.remove("full-width"); // Khi drawer mở, header sẽ có chiều rộng tính theo chiều rộng drawer
            }
        });
    }

    // Xử lý click chọn một mục trong drawer
    const menuItems = document.querySelectorAll('.list-group-item');
    if (menuItems) {
        menuItems.forEach(item => {
            item.addEventListener('click', function () {
                // Remove 'active' class from all items
                menuItems.forEach(i => i.classList.remove('active'));

                // Add 'active' class to clicked item
                this.classList.add('active');
            });
        });
    }
});