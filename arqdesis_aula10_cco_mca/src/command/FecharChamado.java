package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Chamado;
import model.DepartamentoTI;
import model.Fila;

public class FecharChamado implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String descricao = request.getParameter("descricao");
		int id = Integer.parseInt(request.getParameter("selected_fila"));
		DepartamentoTI dti = new DepartamentoTI();
		Chamado chamado = new Chamado();
		chamado.setDescricao(descricao);
		Fila fila = new Fila(id, null);
		request.setAttribute("chamado", dti.abrirChamado(chamado, fila));
		RequestDispatcher dispatcher = request.getRequestDispatcher("ChamadoSalvo.jsp");
		dispatcher.forward(request, response);
	}

}
