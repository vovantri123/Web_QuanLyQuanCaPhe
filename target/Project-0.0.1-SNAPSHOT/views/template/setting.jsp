<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Website Settings</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .setting-container {
            max-width: 600px;
            margin: 30px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .btn-save {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container setting-container">
        <h3 class="text-center">Website Settings</h3>

        <!-- Theme Setting -->
        <div class="form-group">
            <label for="themeSelect">Theme</label>
            <select id="themeSelect" class="form-control">
                <option value="light" selected>Light</option>
                <option value="dark">Dark</option>
            </select>
        </div>

        <!-- Save Button --> 
        <a id="saveBtn" class="btn btn-primary btn-block" href="<%=request.getContextPath()%>/DashBoardServlet">
           Save
        </a>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            // Get DOM elements
            const themeSelect = document.getElementById("themeSelect");
            const saveBtn = document.getElementById("saveBtn");

            // Load saved settings from localStorage
            function loadSettings() {
                const theme = localStorage.getItem("theme") || "light";
                themeSelect.value = theme;
                applyTheme(theme);
            }

            // Apply theme
            function applyTheme(theme) {
                if (theme === "dark") {
                    document.body.style.backgroundColor = "#333";
                    document.body.style.color = "#fff";
                } else {
                    document.body.style.backgroundColor = "#fff";
                    document.body.style.color = "#000";
                }
            }

            // Save settings to localStorage
            saveBtn.addEventListener("click", function () {
                const theme = themeSelect.value;
                localStorage.setItem("theme", theme);
                applyTheme(theme);

                //alert("Settings saved! from theme.js");
            });

            // Initialize settings on load
            loadSettings();
        });
    </script>
</body>
</html>
