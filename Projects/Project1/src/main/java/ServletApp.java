

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ServletApp")
public class ServletApp extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Control in Servle/controller");
		String name = request.getParameter("uname");
		
		String city = request.getParameter("ucity");
		
		if(name.equals("Aashish") && city.equals("Patna")) {
			System.out.println("Success! He is the right Aashish logged in");
		}
		else {
			System.out.println("Diff Aashish logged in");
		}
	}

}
