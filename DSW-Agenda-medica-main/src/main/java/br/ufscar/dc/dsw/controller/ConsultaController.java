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
import br.ufscar.dc.dsw.dao.ConsultaDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/consulta/*")
public class ConsultaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
	private UsuarioDAO dao_usuario;
    private ConsultaDAO dao_consulta;

    @Override
    public void init() {
        dao_usuario = new UsuarioDAO();
        dao_consulta = new ConsultaDAO();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                case "/insersao":
                    insere(request, response);
                    break;
                case "/listaConsultas":
                    apresentaFormConsultas(request, response);
                    break;
                case "/consultas":
                    listaConsultas(request,response);
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

        System.out.println("oi lista_medicos");
        List<Usuario> listaMedicos = dao_usuario.getMedicos();
        System.out.println("pegou sql");
        request.setAttribute("listaMedicos", listaMedicos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/consulta/lista.jsp");
        dispatcher.forward(request, response);
        System.out.println("faz forward");
    }

    private void listaConsultas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        System.out.println("oi lista_consultas");
        String CPF = request.getParameter("CPFpaciente");
        List<Consulta> listaConsultas = dao_consulta.getByCPF(CPF);
        request.setAttribute("listaConsultas", listaConsultas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/consulta/lista_consultas.jsp");
        System.out.println("pegou aqui");
        dispatcher.forward(request, response);
        System.out.println("pegou ali");
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("inseriu?");
        String CPFpaciente = request.getParameter("CPFpaciente");
        String CRMmedico = request.getParameter("CRMmedico"); 
        String data_consulta_str = request.getParameter("data_consulta");
        String hora = request.getParameter("hora");
        LocalDate localDate = LocalDate.parse(data_consulta_str);
        Date data_consulta = Date.valueOf(localDate);
       
        
        Consulta consulta = new Consulta(CPFpaciente, CRMmedico, data_consulta, hora);

        dao_consulta.insert(consulta);
        System.out.println("inseriu?");
        response.sendRedirect("lista");
    }

    
   private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/consulta/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormConsultas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/consulta/formulario_consultas.jsp");
        dispatcher.forward(request, response);
    }
    
}
