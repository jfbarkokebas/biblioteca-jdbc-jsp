package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

@WebServlet(urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = (String) request.getParameter("nome");
		
		request.setAttribute("usuario", user);
			//precisa validar o LOGIN
			RequestDispatcher rd = request.getRequestDispatcher("principal/inicio.jsp");
			rd.forward(request, response);
		
	
	}

}
