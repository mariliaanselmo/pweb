package br.edu.ifgoiano;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.IfStatement;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = -7376927078897110086L;

	@Override
	protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		final String responsavelNome = req.getParameter("responsavelNome");
		final String alunoNome = req.getParameter("alunoNome");
		final String telefone = req.getParameter("telefone");
		String cadastro = "";
		
		System.out.println("O nome do responsável digitado foi: " .concat(responsavelNome));
		System.out.println("O nome do aluno digitado foi: " .concat(alunoNome));
		System.out.println("O telefone digitado foi: " .concat(telefone));
		
		//if (telefone != null && alunoNome!= null && responsavelNome!= null) {
			//cadastro = responsavelNome + " responsável por " + alunoNome + " cadastrado com sucesso!" ;
		//} else if (telefone == null || alunoNome== null || responsavelNome== null) {
			//cadastro = "Todos os dados de formulário são de preenchimento obrigatório";
		//}
		
		if (telefone.isEmpty() || alunoNome.isEmpty() || responsavelNome.isEmpty()) {
			cadastro = "Todos os dados de formulário são de preenchimento obrigatório";
		} else {
			cadastro = responsavelNome + " responsável por " + alunoNome + " cadastrado com sucesso!" ;
		}
		
		req.setAttribute("cadastro", cadastro);
		
		req.getRequestDispatcher("cadastroTela.jsp").forward(req, resp);
		
		System.out.println(cadastro);
	}
}
