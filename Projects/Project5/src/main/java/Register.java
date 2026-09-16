

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/Register")
public class Register extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uname");
		String email = request.getParameter("email");
		String upassword = request.getParameter("password");
		String ucity = request.getParameter("ucity");
		
		Model model = new Model();
		model.setName(name);
		model.setEmail(email);
		model.setUpassword(upassword);
		model.setUcity(ucity);
		
		
		
		int rowAffected = model.register();
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		if(rowAffected == 0) {
			response.sendRedirect("/RegistrationAppMVC/failure.jsp");
		}
		else {
			response.sendRedirect("/RegistrationAppMVC/success.jsp");
		}
	}
}
