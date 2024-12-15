// Toast function
function customToast({ title = "", message = "", type = "info", duration = 3000 }) {
  const main = document.getElementById("custom-toast-container");
  if (main) {
    const toast = document.createElement("div");

    // Auto remove toast
    const autoRemoveId = setTimeout(function () {
      main.removeChild(toast);
    }, duration + 1000);

    // Remove toast when clicked
    toast.onclick = function (e) {
      if (e.target.closest(".custom-toast__close")) {
        main.removeChild(toast);
        clearTimeout(autoRemoveId);
      }
    };

    const icons = {
      success: "fas fa-check-circle",
      info: "fas fa-info-circle",
      warning: "fas fa-exclamation-circle",
      error: "fas fa-exclamation-circle"
    };
    const icon = icons[type];
    const delay = (duration / 1000).toFixed(2);

    toast.classList.add("custom-toast", `custom-toast--${type}`);
    toast.style.animation = `slideInLeft ease .3s, fadeOut linear 1s ${delay}s forwards`;

    toast.innerHTML = `
                    <div class="custom-toast__icon">
                        <i class="${icon}"></i>
                    </div>
                    <div class="custom-toast__body">
                        <h3 class="custom-toast__title">${title}</h3>
                        <p class="custom-toast__msg">${message}</p>
                    </div>
                    <div class="custom-toast__close">
                        <i class="fas fa-times"></i>
                    </div>
                `;
    main.appendChild(toast);
  }
}


// Hàm hiển thị thông báo thành công
function showSuccessToast(msg) {
  customToast({
    title: "Success!",
    message: msg,  
    type: "success",
    duration: 5000
  });
}

// Hàm hiển thị thông báo thông tin
function showInformationToast(msg) {
  customToast({
    title: "Information!",
    message: msg,   
    type: "info",
    duration: 5000
  });
}

// Hàm hiển thị thông báo cảnh báo
function showWarningToast(msg) {
  customToast({
    title: "Warning!",
    message: msg,  
    type: "warning",
    duration: 5000
  });
}

// Hàm hiển thị thông báo lỗi
function showErrorToast(msg) {
  customToast({
    title: "Error!",
    message: msg,  
    type: "error",
    duration: 5000
  });
}