function loadSettings() {
    const theme = localStorage.getItem("theme") || "light"; // Default is light
    if (theme === "dark") {
        document.body.classList.add("dark-theme");
    } else {
        document.body.classList.remove("dark-theme");
    }
}

function setupThemeHandlers() {
    const themeSelect = document.getElementById("themeSelect");
    const saveBtn = document.getElementById("saveBtn");

    if (themeSelect && saveBtn) {
        saveBtn.addEventListener("click", function () {
            const theme = themeSelect.value;
            localStorage.setItem("theme", theme);

            if (theme === "dark") {
                document.body.classList.add("dark-theme");
            } else {
                document.body.classList.remove("dark-theme");
            }

            alert("Settings saved!");
        });
    }
} 

// Theo dõi việc include JSP và tái khởi tạo cài đặt
document.addEventListener("contentLoaded", function () {
    loadSettings();
    setupThemeHandlers();
}); 