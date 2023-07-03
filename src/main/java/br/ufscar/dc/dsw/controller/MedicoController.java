package br.ufscar.dc.dsw.controller;

import java.io.IOException;
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

@WebServlet(urlPatterns = "/medico/*")
public class MedicoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
	private UsuarioDAO dao;

    @Override
    public void init() {
        dao = new UsuarioDAO();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
    	
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
                case "/lista_medicos":
                    lista_medicos(request,response);
                case "/listarMedicosPorEspecialidade":
                    listarMedicosPorEspecialidade(request, response);
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
        
        List<Usuario> listaMedicos = dao.getMedicos();
        request.setAttribute("listaMedicos", listaMedicos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/medico/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String CRM = request.getParameter("CRM");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String especialidade = request.getParameter("especialidade");
        String papel = "med";
        Usuario medico = new Usuario(CRM, especialidade, nome, login, senha, papel);
        dao.insert(medico);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");

        String CRM = request.getParameter("CRM");
        System.out.println(CRM);
        Usuario medico = dao.getByCRM(CRM);
        System.out.println(medico.getNome());
        dao.delete(medico);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String CRM = request.getParameter("CRM");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String especialidade = request.getParameter("especialidade");
        String papel = "med";
        Usuario medico = new Usuario(CRM, especialidade, nome, login, senha, papel);
        dao.update(medico);
        response.sendRedirect("lista");
    }
	
	private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/medico/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String CRM = request.getParameter("CRM");
        System.out.println(CRM);
        Usuario medico = dao.getByCRM(CRM);        
        System.out.println(medico.getNome());
        request.setAttribute("medico", medico);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/medico/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void lista_medicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("ggggggggggggggggggggggggggggg");
        List<Usuario> listaMedicos = dao.getMedicos();
        request.setAttribute("listaMedicos", listaMedicos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/medico/listaMedicos.jsp");
        dispatcher.forward(request, response);
    }

    private void listarMedicosPorEspecialidade(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        List<Usuario> listaMedicosPorEspecialidade = dao.getMedicosPorEspecialidade();
        request.setAttribute("listaMedicosPorEspecialidade", listaMedicosPorEspecialidade);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/medico/listaEspecialidades.jsp");
        dispatcher.forward(request, response);
    }
}


  

  