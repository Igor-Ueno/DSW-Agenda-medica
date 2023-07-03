package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.ConsultaDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;


@WebServlet(urlPatterns = "/consulta/*")
public class ConsultaController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
	private ConsultaDAO dao;
    private UsuarioDAO dao_usuario;

    @Override
    public void init() {
        dao = new ConsultaDAO();
        dao_usuario = new UsuarioDAO();
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
    	
        // System.out.println(usuario.getNome());

    	if (usuario == null) {
    		response.sendRedirect(request.getContextPath());
            return;
    	} else if (usuario.getPapel().equals("pac")) {
            request.setAttribute("CPFpaciente", usuario.getCPF());

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
                    case "/listaCPF":
                        listaConsultaByCPF(request,response);
                    break;
                    default:
                        listaMedicos(request,response);
                    break;
                }
            } catch (RuntimeException | IOException | ServletException e) {
                throw new ServletException(e);
            }
        } else if (usuario.getPapel().equals("med")) {
            request.setAttribute("CRMmedico", usuario.getCRM());

            try {
                listaConsultaByCRM(request,response);
            } catch (RuntimeException | IOException | ServletException e) {
                throw new ServletException(e);
            }
        } else {
            erros.add("Acesso não autorizado!");
    		erros.add("Apenas Papeis [PAC] e [MED] tem acesso a essa página");
    		request.setAttribute("mensagens", erros);
    		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
    		rd.forward(request, response);
            System.out.println("user redirected");
            return;
        }
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/consulta/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String CPFpaciente = request.getParameter("CPFpaciente");
        String CRMmedico = request.getParameter("CRMmedico");
        String data_consulta_str = request.getParameter("data_consulta");
        LocalDate localDate = LocalDate.parse(data_consulta_str);
        Date data_consulta = Date.valueOf(localDate);
        String hora = request.getParameter("hora");
        Consulta consulta = new Consulta(CPFpaciente, CRMmedico, data_consulta, hora);
        dao.insert(consulta);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");

        String CPFpaciente = request.getParameter("CPFpaciente");
        String CRMalt = request.getParameter("CRMmedico");
        String[] array = CRMalt.split("-");
        String CRMmedico = array[0] + "/" + array[1];
        String data_consulta_str = request.getParameter("data_consulta");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(data_consulta_str, formatter);
        Date data_consulta = Date.valueOf(localDate);
        System.out.println(data_consulta);
        String hora = request.getParameter("hora");
        Consulta consulta = new Consulta(CPFpaciente, CRMmedico, data_consulta, hora);
        dao.delete(consulta);
        response.sendRedirect("lista");
    }

    private void listaConsultaByCPF(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("lista de consultas por paciente");

        // String CPF = request.getParameter("CPF");
        String CPFpaciente = (String) request.getAttribute("CPFpaciente");
        System.out.println(CPFpaciente);
        List<Consulta> listaConsultas = dao.getByCPF(CPFpaciente);
        System.out.println(listaConsultas);
        request.setAttribute("listaConsultas", listaConsultas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/consulta/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void listaConsultaByCRM(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("lista de consultas por medico");

        String CRMmedico = (String) request.getAttribute("CRMmedico");
        System.out.println(CRMmedico);
        List<Consulta> listaConsultas = dao.getByCRM(CRMmedico);        
        System.out.println(listaConsultas);
        request.setAttribute("listaConsultas", listaConsultas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/consulta/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void listaMedicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("oi lista_medicos");
        List<Usuario> listaMedicos = dao_usuario.getMedicos();
        System.out.println("pegou sql");
        request.setAttribute("listaMedicos", listaMedicos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/consulta/listaMedicos.jsp");
        dispatcher.forward(request, response);
        System.out.println("faz forward");
    }
}
