package utilities;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.NguoiDung;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.util.Data;
@WebFilter("/*")
public class UserFilter implements Filter {
	public UserFilter() {
		// TODO Auto-generated constructor stub
	}
    // Danh sách các URL không yêu cầu đăng nhập
    private static final List<String> PUBLIC_URLS = Arrays.asList(
        "/TrangChuServlet?action=about",  
        "/TrangChuServlet?action=contact", 
        "/DanhMucSanPham",      
        "/TrangChuServlet",   
        "/assets/",
        "DangNhapServlet",
        "DangKyServlet",
        "QuenMatKhauServlet",
        "QuenMatKhauServlet?action=forget",
        "QuenMatKhauServlet?action=confirm",
        "QuenMatKhauServlet?action=reset",
        "/GoogleLoginServlet",
        "/TrangThaiDHServlet"
    );
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Có thể dùng để khởi tạo filter
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
    	String servletPath = httpRequest.getServletPath();
        String requestURI = httpRequest.getRequestURI();
        String contextPath = httpRequest.getContextPath();
        HttpSession session = httpRequest.getSession();

        // Kiểm tra nếu URL nằm trong danh sách không yêu cầu xác thực
        boolean isPublicURL = PUBLIC_URLS.stream().anyMatch(requestURI::contains);

        boolean loggedIn = session != null && session.getAttribute("nguoiDung") != null;
        
        // Trang chủ luôn được phép truy cập, kể cả khi chưa đăng nhập
        boolean isHomePage = requestURI.equals(httpRequest.getContextPath() + "/") ||
                             requestURI.equals(httpRequest.getContextPath() + "/TrangChuServlet");
        	
        // Kiểm tra nếu là trang DashBoardServlet và user không có quyền truy cập
        NguoiDung nd = (NguoiDung) session.getAttribute("nguoiDung");
        boolean isDashboardAccess = servletPath.equals("/DashBoardServlet");
        boolean isUser = loggedIn && nd.getVaiTro().equals("User"); // Cần kiểm tra vai trò

        if (isDashboardAccess && isUser) {
            // Trả về lỗi 404
        	request.getRequestDispatcher("/views/template/404.jsp").forward(request, response);
            return; // Kết thúc ở đây
        }
        	
        if (loggedIn || isPublicURL || isHomePage) {
            // Nếu đã đăng nhập hoặc truy cập vào URL, cho phép tiếp tục
        	
        	System.out.println("#INFO " + new Data() + " - ServletPath:" + servletPath+ ", URL =" + httpRequest.getRequestURL());
            chain.doFilter(request, response);
        } else {
            // Chuyển hướng đến trang login
            String loginURI = httpRequest.getContextPath() + "/DangNhapServlet";
            httpResponse.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
        // Cleanup filter nếu cần
    }
}
