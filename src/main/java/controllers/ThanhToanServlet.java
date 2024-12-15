package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SignatureException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;

import daos.GioHangDao;
import daos.PhuongThucThanhToanDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.GioHang;
import models.NguoiDung;
import models.PhuongThucThanhToan;

@WebServlet("/ThanhToanServlet")
public class ThanhToanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThanhToanServlet() {
        super();
    }

    // Các tham số MoMo API
    private static final String PARTNER_CODE = "MOMOBKUN20180529";
    private static final String ACCESS_KEY = "klm05TvNBzhg7h7j";
    private static final String SECRET_KEY = "at67qH6mk8w5Y1nAyMoYKMWACiEi2bsa";
    private static final String ENDPOINT = "https://test-payment.momo.vn/v2/gateway/api/create";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// Lấy thông tin người dùng từ session
        HttpSession session = request.getSession();
        NguoiDung nd = (NguoiDung) session.getAttribute("nguoiDung"); 
        
        // Lấy thông tin từ session
        GioHangDao ghDao = new GioHangDao();
        List<GioHang> cart = ghDao.getById(nd.getMaND()); 
        String maPTTT = (String) session.getAttribute("maPTTT"); // Mã phương thức thanh toán
        // Lấy thông tin phương thức thanh toán từ database
        PhuongThucThanhToanDao ptttDao = new PhuongThucThanhToanDao();
        PhuongThucThanhToan pttt = ptttDao.getById(maPTTT);
	    
	    if (pttt != null && cart.size() > 0)
	    {
	    	if ("MoMo".equals(pttt.getTenPTTT())) 
		    {	    
		    	Date ngayHT = new Date(System.currentTimeMillis()); // Ngày hiện tại
	            String ngayDD = ngayHT.toString(); // Định dạng ngày thành chuỗi
	            String orderInfo = "Ngày tạo: " + ngayDD; // Thông tin đơn hàng
		        
	            // Lấy số tiền thanh toán từ request
	            DecimalFormat df = new DecimalFormat("#");
	            String amount = df.format(Float.parseFloat(request.getParameter("tongTien")));
	            String thanhTien = request.getParameter("thanhTien");
	            String ipnUrl = "http://localhost:8080/Project/HoaDonInServlet"; // URL thông báo IPN
	                    
	            // Lấy thông tin
	            String diaChi = request.getParameter("diaChi");       
	            String ten = request.getParameter("ten");
	            String soDT = request.getParameter("soDT");  
	            
	            // Kiểm tra các tham số có bị rỗng hay không
	            if (diaChi == null || diaChi.isEmpty() || ten == null || ten.isEmpty() || soDT == null || soDT.isEmpty()) {
	                request.setAttribute("msg", "Tên - Địa Chỉ - Số Điện Thoại: Không được để trống");
	                request.getRequestDispatcher("/HoaDonServlet").forward(request, response);
	                return; 
	            }
	            
	            String redirectUrl = "http://localhost:8080/Project/HoaDonInServlet"; // URL chuyển hướng
	            String separator = redirectUrl.contains("?") ? "&" : "?";
	            redirectUrl += separator + "ten=" + ten + "&diaChi=" + diaChi + "&soDT=" + soDT + "&thanhTien=" + thanhTien + "&tongTien=" + amount;
	            
	            String extraData = "Thanh Toán Bằng MoMo"; // Dữ liệu thêm
		
		        // Tạo requestId và orderId
		        String requestId = String.valueOf(System.currentTimeMillis());
		        String orderId = requestId;
		
		        // Chuỗi raw signature để tạo chữ ký
		        String rawSignature = "accessKey=" + ACCESS_KEY +
		                "&amount=" + amount +
		                "&extraData=" + extraData +
		                "&ipnUrl=" + ipnUrl +
		                "&orderId=" + orderId +
		                "&orderInfo=" + orderInfo +
		                "&partnerCode=" + PARTNER_CODE +
		                "&redirectUrl=" + redirectUrl +
		                "&requestId=" + requestId +
		                "&requestType=captureWallet";
		
		        String signature = "";
		        try {
		            signature = generateSignature(SECRET_KEY, rawSignature);
		        } catch (SignatureException e) {
		            e.printStackTrace();
		            request.setAttribute("msg", "Lỗi khi tạo chữ kí");
		            request.getRequestDispatcher("/HoaDonServlet").forward(request, response);
		            return;
		        }
		
		        // Chuẩn bị dữ liệu JSON để gửi request đến API của MoMo
		        JSONObject requestBody = new JSONObject();
		        requestBody.put("partnerCode", PARTNER_CODE);
		        requestBody.put("accessKey", ACCESS_KEY);
		        requestBody.put("requestId", requestId);
		        requestBody.put("amount", amount);
		        requestBody.put("orderId", orderId);
		        requestBody.put("orderInfo", orderInfo);
		        requestBody.put("redirectUrl", redirectUrl);
		        requestBody.put("ipnUrl", ipnUrl);
		        requestBody.put("extraData", extraData);
		        requestBody.put("requestType", "captureWallet");
		        requestBody.put("signature", signature);
		
		        try {
		        	String responseBody = sendPostRequest(ENDPOINT, requestBody.toString()); // Gửi request HTTP POST
		
		        	// Lấy URL thanh toán từ response
	                JSONObject jsonResponse = new JSONObject(responseBody);
	                String payUrl = jsonResponse.optString("payUrl", null);               	                                                  
	                response.sendRedirect(payUrl); // Chuyển hướng người dùng đến trang thanh toán
	                return;
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		            request.setAttribute("msg", "Lỗi khi thêm hóa đơn");
		        }
		    } 
		    else if ("Tiền mặt".equals(pttt.getTenPTTT())) {
		    	request.getRequestDispatcher("/HoaDonInServlet").forward(request, response);
		    	return;
		    }
		    else {
		        // Nếu không phải MoMo, xử lý các phương thức thanh toán khác (nếu có)
		    	request.setAttribute("msg", "Chưa tích hợp phương thức này");
		    }
	    }
	    else {
	    	request.setAttribute("msg", "Không có sản phẩm nào");
	    }	    
	    session.setAttribute("nguoiDung", nd);
	    request.getRequestDispatcher("/HoaDonServlet").forward(request, response);
    }
	
    // Tạo HMAC-SHA256 signature
    private String generateSignature(String secretKey, String rawSignature) throws SignatureException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            byte[] rawHmac = mac.doFinal(rawSignature.getBytes());
            return bytesToHex(rawHmac);
        } catch (Exception e) {
            throw new SignatureException("Lỗi khi tạo signature", e);
        }
    }

    // Chuyển byte array thành hex string
    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // Gửi HTTP POST request và nhận response
    private String sendPostRequest(String apiUrl, String requestBody) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int status = connection.getResponseCode();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line.trim());
            }
            return response.toString();
        }
    }
}
