package br.ufscar.dc.dsw.controller;

//import br.ufscar.dc.dsw.dao.MedicoDAO;
import br.ufscar.dc.dsw.dao.ConsultaDAO;
//import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

@WebServlet(urlPatterns = "/consultas/*")
public class ConsultaController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ConsultaDAO dao;

    @Override
    public void init() {
        dao = new ConsultaDAO();
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
		} else if (!usuario.getPapel().equals("ADMIN")) {
			erros.add("Acesso não autorizado!");
			erros.add("Apenas Papel [ADMIN] tem acesso a essa página");
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
			return;
		}
		
        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }

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
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Consulta> listaConsultas = dao.listarConsultas();
        request.setAttribute("listaConsultas", listaConsultas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/consulta/lista.jsp");
        dispatcher.forward(request, response);
    }

    private Map<Long, Timestamp> getConsultas() {
        Map<Long, Timestamp> consultas = new HashMap<>();
        for (Consulta consulta : new ConsultaDAO().listarConsultas()) {
            consultas.put(consulta.getId(), consulta.getDataHora());
        }
        return consultas;
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("consultas", getConsultas());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/consulta/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String CPF = request.getParameter("CPF");
        String CRM = request.getParameter("CRM");
        String dataHoraStr = request.getParameter("dataHora");
        Timestamp dataHora = Timestamp.valueOf(dataHoraStr);
        Consulta consulta = dao.get(id,CPF,CRM,dataHora);
        request.setAttribute("consulta", consulta);
        request.setAttribute("consultas", getConsultas());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/consulta/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Long id = Long.parseLong(request.getParameter("id"));
        String CPF = request.getParameter("CPF");
        String CRM = request.getParameter("CRM");
        String dataHoraStr = request.getParameter("dataHora");
        Timestamp dataHora = Timestamp.valueOf(dataHoraStr);
        Consulta consulta = new Consulta(id, CPF, CRM,dataHora);

        dao.insert(consulta);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
       Long id = Long.parseLong(request.getParameter("id"));
        String CPF = request.getParameter("CPF");
        String CRM = request.getParameter("CRM");
        String dataHoraStr = request.getParameter("dataHora");
        Timestamp dataHora = Timestamp.valueOf(dataHoraStr);
        Consulta consulta = new Consulta(id, CPF, CRM,dataHora);

        dao.update(consulta);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String CPF = request.getParameter("CPF");
        String CRM = request.getParameter("CRM");
        String dataHoraStr = request.getParameter("dataHora");
        Timestamp dataHora = Timestamp.valueOf(dataHoraStr);
        Consulta consulta = new Consulta(id,CPF,CRM,dataHora);
        dao.delete(consulta);
        response.sendRedirect("lista");
    }
}