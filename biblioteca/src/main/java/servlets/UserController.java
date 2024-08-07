package servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import services.UserService;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserService();
		List<User> userList = service.getAllUsers();
		
		 HttpSession session = request.getSession();
	     session.setAttribute("userList", userList);
	     
	     RequestDispatcher rd = request.getRequestDispatcher("principal/inicio.jsp");
		 rd.forward(request, response);
		
	     
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = (String) request.getParameter("nome");
		String email = (String) request.getParameter("email");
		String senha = (String) request.getParameter("senha");
		String confirmacaoSenha = (String) request.getParameter("confirmacao");
		String whatsapp = (String) request.getParameter("whatsapp");
		String telefone = (String) request.getParameter("telefone");
		
		if(senha.equals(confirmacaoSenha)) {
			User user = new User();
			user.setEmail(email);
			user.setName(nome);
			user.setPassword(senha);
			user.setPhone(telefone);
			user.setWhatsapp(whatsapp);
			
			UserService service = new UserService();
			service.addUser(user);
			
			request.setAttribute("msg", "Usuário adicionado com sucesso!");
			RequestDispatcher rd = request.getRequestDispatcher("principal/inicio.jsp");
			rd.forward(request, response);
			
		}else {
			request.setAttribute("msg", "ERRO: As senhas precisam ser iguais");
			RequestDispatcher rd = request.getRequestDispatcher("principal/inicio.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
