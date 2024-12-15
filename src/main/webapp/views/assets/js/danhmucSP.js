function showProducts(category) {
	const value = category.getAttribute("data-value");
	alert(value);
	const products = document.querySelectorAll(".product-card");
	products.forEach((product) => {
		if (category === "all" || product.classList.contains(category)) {
			product.style.display = "block";
		} else {
			product.style.display = "none";
		}
	});

	// Cập nhật trạng thái menu
	document.querySelectorAll(".category-sidebar ul li").forEach((item) => {
		item.classList.remove("active");
	});
	document
		.querySelector(
			`.sidebar ul li[onclick="showProducts('${category}')"]`
		)
		.classList.add("active");
	window.location.href = 'DanhMucSanPham?value='+value;
}