let currentSlide = 0;

function showSlide(index) {
	const slides = document.querySelector(".slides");
	const totalSlides = slides.children.length;
	currentSlide = (index + totalSlides) % totalSlides;
	slides.style.transform = `translateX(-${currentSlide * 100}%)`;
}

function changeSlide(step) {
	showSlide(currentSlide + step);
}

// Tự động chuyển slide sau mỗi 5 giây
setInterval(() => {
	changeSlide(1);
}, 5000);