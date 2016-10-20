import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cadastrar extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		DaoContato daoContato = new DaoContato();
		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String dtNascimento = request.getParameter("dataNascimento");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");

		Contato contato = new Contato(nome, dtNascimento, telefone, email);
		int result = daoContato.adicionarContato(contato);
		if (result == 1) {
			out.println("<html><head></head><body><p>Cadastrado com sucesso!</p>");
			out.println("<form action='indexLista.html' method='post'>");
			out.println("<input type='submit' value='Voltar'>");
			out.println("</form></body></html>");
		} else {
			out.println("<html><head></head><body><p>Erro no cadastro!</p>");
			out.println("<form action='indexLista.html' method='post'>");
			out.println("<input type='submit' value='Voltar'>");
			out.println("</form></body></html>");
		}
	}

}
