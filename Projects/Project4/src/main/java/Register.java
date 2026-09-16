

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sun.jdi.connect.spi.Connection;


@WebServlet("/Register")
public class Register extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Control in Servlet");
		
		String name = request.getParameter("uname");
		String email = request.getParameter("email");
		String upassword = request.getParameter("password");
		String city = request.getParameter("ucity");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/servlet";
			String user = "root";
			String password = "admin";
			java.sql.Connection connect =  DriverManager.getConnection(url,user,password);
			
			PreparedStatement pstmt = connect.prepareStatement("INSERT INTO personalInfo (uname, email, upassword, ucity) VALUES (?, ?, ?, ?)");
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, upassword);
			pstmt.setString(4, city);
			
			int rowAffected = pstmt.executeUpdate();
			
			PrintWriter writer = response.getWriter();
			if(rowAffected!=0) {
				writer.println("<h1>Registartion success</h1>");
			}
			else {
				writer.println("<h1>Registration failed</h1>");
			}
			pstmt.close();
			connect.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
