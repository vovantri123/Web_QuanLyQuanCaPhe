<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-white" style="height:80px;">
      	<button class="btn mt-2 mb-3 mr-2" id="toggleDrawerBtn">
		  	<i class="fa-solid fa-bars" style="font-size: 24px; color: black;"></i>
		</button>

        <a class="navbar-brand" href="#" style="color: black;"> 
            <span style="font-size: 1.5rem; font-weight: bold;">The Coffee House</span>
        </a>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle d-flex align-items-center" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: black;">
                        <img src="<%=request.getContextPath()%>/views/assets/images/HinhNguoiDung/Avt1.jpg"  
					         alt= "Avatar admin" 
					         class="rounded-circle" style="width:30px; margin-right: 8px;"/> Admin
                    </a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="<%=request.getContextPath()%>/NguoiDungServlet?action=edit&maND=ND01" style="color: black;">Profile</a>
                        <a class="dropdown-item" href="<%=request.getContextPath()%>/views/template/setting.jsp" style="color: black;">Settings</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item text-danger" href="LogoutServlet" onclick="return confirm('Bạn có chắc muốn đăng xuất?');">Logout</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</header>
