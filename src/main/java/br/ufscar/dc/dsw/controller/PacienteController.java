package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/paciente/*")
public class PacienteController extends HttpServlet {

    private static final long serialVersionUID = 1L;
	private UsuarioDAO dao;

    @Override
    public void init() {
        dao = new UsuarioDAO();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
    	Erro erros = new Erro();

    	if (usuario == null) {
    		response.sendRedirect(request.getContextPath());
            return;
    	} else if (!usuario.getPapel().equals("adm")) {
    		erros.add("Acesso não autorizado!");
    		erros.add("Apenas Papel [ADM] tem acesso a essa página");
    		request.setAttribute("mensagens", erros);
    		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
    		rd.forward(request, response);
            System.out.println("user redirected");
            return;
    	} 
		String action = request.getPathInfo();

        if (action == null) {
            action = "";

        }

        System.out.println(action);

        try {
            switch (action) {
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/remocao":
                    remove(request, response);
                    break;
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
				case "/atualizacao":
                    atualize(request, response);
                    break;
				default:
					lista(request,response);
                    break;      
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("oi lista");
        List<Usuario> listaPacientes = dao.getPacientes();
        System.out.println("pegou sql");
        request.setAttribute("listaPacientes", listaPacientes);
        System.out.println("cmc forward");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/paciente/lista.jsp");
        dispatcher.forward(request, response);
        System.out.println("faz forward");
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String CPF = request.getParameter("CPF");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        String data_nascimento_str = request.getParameter("data_nascimento");
        LocalDate localDate = LocalDate.parse(data_nascimento_str);
        Date data_nascimento = Date.valueOf(localDate);
        String papel = "pac";
        Usuario paciente = new Usuario(CPF, login, senha, nome, telefone, sexo, data_nascimento, papel);
        dao.insert(paciente);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");

        String CPF = request.getParameter("CPF");
        System.out.println(CPF);
        Usuario paciente = dao.getByCPF(CPF);
        System.out.println(paciente.getNome());
        dao.delete(paciente);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String CPF = request.getParameter("CPF");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        String data_nascimento_str = request.getParameter("data_nascimento");
        LocalDate localDate = LocalDate.parse(data_nascimento_str);
        Date data_nascimento = Date.valueOf(localDate);
        String papel = "pac";
        Usuario paciente = new Usuario(CPF, login, senha, nome, telefone, sexo, data_nascimento, papel);
        dao.update(paciente);
        response.sendRedirect("lista");
    }
	
	private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/paciente/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String CPF = request.getParameter("CPF");
        System.out.println(CPF);
        Usuario paciente = dao.getByCPF(CPF);
        System.out.println(paciente.getNome());
        request.setAttribute("paciente", paciente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/paciente/formulario.jsp");
        dispatcher.forward(request, response);
    }
}
