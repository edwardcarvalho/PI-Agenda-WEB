

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Listar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		DaoContato daoContato = new DaoContato();
		
		ArrayList<Contato> agenda = daoContato.listarContatos();
		
		out.println("<table border='1' cellpadding='5' cellspacing='5'><tr><th>Nome</th><th>Dt.Nascimento</th><th>Telefone</th><th>Email</th><th>Dt.Cadastro</th></tr>");
		for (Contato index : agenda) {
			out.println("<tr>");
			out.println("<td>"+index.getNome()+"</td>");
			out.println("<td>"+index.getDataNascimento()+"</td>");
			out.println("<td>"+index.getTelefone()+"</td>");
			out.println("<td>"+index.getEmail()+"</td>");
			out.println("<td>"+index.getDataCadastro()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<form action='index.html'>");
		out.println("<input type='submit' value='Cadastrar novo contato'/>");
		out.println("</form>");
	}

}
