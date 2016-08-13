package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

public class FazerLogin implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(username, password);
		
		HttpSession session = request.getSession();
		
		if(usuario.validar(usuario.getTO())){
			session.setAttribute("logado", usuario.getTO());
			response.sendRedirect("index.jsp");
		} else {
			throw new ServletException("Usuário/senha não encontrados.");
		}
	}

}
