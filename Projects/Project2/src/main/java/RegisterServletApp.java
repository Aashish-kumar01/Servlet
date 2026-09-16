

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Register")
public class RegisterServletApp extends HttpServlet { 
	public RegisterServletApp() {
		System.out.println("Servlet obj is created internally by container");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uname");
		String city = request.getParameter("ucity");
		
//		PrintWriter writer = response.getWriter();
		
		response.sendRedirect("/RegisterServletApp/success.jsp");
	}
}
