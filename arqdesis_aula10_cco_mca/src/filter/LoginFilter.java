package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import to.UsuarioTO;

@WebFilter("/*")
public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// place your code here
		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String caminho = req.getContextPath();
		String uri = req.getRequestURI();

		System.out.println("caminho: " + caminho);
		System.out.println("uri: " + uri);

		HttpSession session = req.getSession();
		String comando = request.getParameter("command");
		if (comando == null) {
			comando = "";
		}

		UsuarioTO logado = (UsuarioTO) session.getAttribute("logado");
		if (logado == null && !uri.equals(caminho + "/Login.jsp")
				&& !comando.equals("FazerLogin")) {
			res.sendRedirect("Login.jsp");
		} else {
			chain.doFilter(request, response);

		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
