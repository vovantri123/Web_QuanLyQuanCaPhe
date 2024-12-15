document.addEventListener("DOMContentLoaded", () => {
	const stars = document.querySelectorAll(".rating-stars .star");
	const ratingInput = document.getElementById("ratingInput");
	let selectedRating = 0; // Lưu giá trị đánh giá đã chọn

	stars.forEach((star, index) => {
		star.addEventListener("mouseover", () => {
			highlightStars(index);
		});

		star.addEventListener("mouseout", () => {
			resetStars();
		});

		star.addEventListener("click", () => {
			selectedRating = index + 1; // Lưu giá trị đánh giá (từ 1 đến 5)
			document.getElementById("ratingInput").value = selectedRating; // Ghi giá trị vào input ẩn
			lockStars(index); // Khóa các sao đã chọn
		});
	});

	function highlightStars(index) {
		for (let i = 0; i <= index; i++) {
			stars[i].style.color = "#ffd700"; // Vàng
		}
	}

	function resetStars() {
		stars.forEach((star, i) => {
			star.style.color = i < selectedRating ? "#ffd700" : "#ccc"; // Vàng nếu được chọn, xám nếu chưa
		});
	}

	function lockStars(index) {
		for (let i = 0; i < stars.length; i++) {
			stars[i].style.color = i <= index ? "#ffd700" : "#ccc"; // Vàng nếu được chọn, xám nếu không
		}
	}

	// Hàm để hiển thị/ẩn phần bình luận
	window.toggleCommentSection = function() {
		const commentSection = document.querySelector(".product-detail-container .customer-comment-container");
		commentSection.classList.toggle("open"); // Toggle the open class to control the sliding effect
	};
});