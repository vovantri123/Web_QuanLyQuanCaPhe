package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.Part;

/**
 * Servlet implementation class XuLyAnh
 */
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 10,      // 10MB
	    maxRequestSize = 1024 * 1024 * 50    // 50MB
	)
public class XuLyAnh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyAnh() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String luuAnh(HttpServletRequest request, ServletContext context, String folderName) throws ServletException, IOException {
        // Đường dẫn thư mục trên server  
        String serverFilePath = context.getRealPath("") + File.separator + "views\\assets\\images\\"+folderName;
        System.out.println("Server Path: " + serverFilePath);

        // Đường dẫn thư mục trong gốc của dự án
        int viTriCat = context.getRealPath("").indexOf(".metadata"); 
        
        // Lấy tên project
        String realPath = context.getRealPath("");   
        Path path = Paths.get(realPath);  
        String nameProject = path.getFileName().toString();  // Lấy tên thư mục cuối cùng
        System.out.println(nameProject);
        
        String localFilePath = context.getRealPath("").substring(0, viTriCat) + nameProject + File.separator + "src\\main\\webapp\\views\\assets\\images\\"+folderName;
        System.out.println("Local Path: " + localFilePath);

        // Tạo thư mục nếu chưa tồn tại (cho cả server và local)
        File serverUploadDir = new File(serverFilePath);
        if (!serverUploadDir.exists()) {
            serverUploadDir.mkdirs();
        }

        File localUploadDir = new File(localFilePath);
        if (!localUploadDir.exists()) {
            localUploadDir.mkdirs();
        }

        String fileName = "";
        for (Part part : request.getParts()) {
            fileName = extractFileName(part); 
            if (fileName != null && !fileName.isEmpty()) {
                System.out.println(fileName);

                // Lưu vào thư mục trên server
                String serverFile = serverFilePath + File.separator + fileName;
                part.write(serverFile);  

                // Lưu vào thư mục trong gốc dự án
                String localFile = localFilePath + File.separator + fileName;
                part.write(localFile);   
            }
        }

        return fileName;
    }

	
    public String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition"); // có dạng là: form-data; name="fileSlide"; filename="example.jpg"
        for (String content : contentDisp.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }

}
