package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
// import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.sql.Date;
// import java.text.DateFormat;
// import java.util.Date;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.PacienteDAO;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/pacientes/*")
public class PacienteController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private PacienteDAO dao;

    @Override
    public void init() {
        dao = new PacienteDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Paciente paciente = (Paciente) request.getSession().getAttribute("usuarioLogado");
		Erro erros = new Erro();

		if (paciente == null) {
			response.sendRedirect(request.getContextPath());
			return;
		} else if (!paciente.getPapel().equals("PAC")) {
			erros.add("Acesso não autorizado!");
			erros.add("Apenas Papel [PAC] tem acesso a essa página");
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
                // Adicionar operações do paciente depois
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private Map<String, Paciente> getPacientes() {
        Map<String, Paciente> pacientes = new HashMap<>();
        for (Paciente paciente: new PacienteDAO().getAll()) {
            pacientes.put(paciente.getCPF(), paciente);
        }
        return pacientes;
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Paciente paciente = (Paciente) request.getSession().getAttribute("usuarioLogado");
        List<Paciente> listaPacientes = dao.getAll();
        request.setAttribute("listaPacientes", listaPacientes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/compra/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("pacientes", getPacientes());
        // Mudar o path
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/compra/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // INSERT INTO Paciente (email, senha, CPF, nome, telefone, sexo, data_nascimento, papel) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String CPF = request.getParameter("CPF");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        String dataString = request.getParameter("data_nascimento");
        // DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        // java.util.Date data_nascimento = new java.sql.Date(fmt.parse(dataString).getTime());
        // String papel = request.getParameter("papel");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String papel = request.getParameter("papel");
        // java.sql.Date data_nascimento;
        try {
            java.util.Date dataUtil = formato.parse(dataString);
            java.sql.Date data_nascimento = new java.sql.Date(dataUtil.getTime());
            Paciente paciente = new Paciente(email, senha, CPF, nome, telefone, sexo, data_nascimento, papel);
            dao.insert(paciente);
            response.sendRedirect("lista");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}