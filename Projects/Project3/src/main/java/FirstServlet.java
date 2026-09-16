

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {


	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Control in first servlet");
		String name = request.getParameter("uname");
		String city = request.getParameter("ucity");
		
		RequestDispatcher reqDispatch = request.getRequestDispatcher("/SecondServlet");
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("ucity", city);
		
		session.setMaxInactiveInterval(1000);
		
		reqDispatch.forward(request, response);
//		reqDispatch.include(request, response);
		
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Response from servlet one</h1>");
		writer.close();
	}

}
