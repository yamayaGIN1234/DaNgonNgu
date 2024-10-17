/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bach.dev;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin ngôn ngữ từ tham số (ví dụ: "en", "vi")
        String lang = request.getParameter("lang");
        
        Locale locale;
        if ("vi".equals(lang)) {
            locale = new Locale("vi", "VN");
        } else {
            locale = new Locale("en", "US");
        }
        
        // Lưu ngôn ngữ vào session để duy trì qua các lần truy cập
        HttpSession session = request.getSession();
        session.setAttribute("lang", locale);
        
        // Tải ResourceBundle tương ứng với ngôn ngữ đã chọn
        ResourceBundle bundle = ResourceBundle.getBundle("bach.resources.messages", locale);
        
        // Gửi các chuỗi văn bản sang JSP
        request.setAttribute("greeting", bundle.getString("greeting"));
        request.setAttribute("language", bundle.getString("language"));
        
        // Điều hướng về trang index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
