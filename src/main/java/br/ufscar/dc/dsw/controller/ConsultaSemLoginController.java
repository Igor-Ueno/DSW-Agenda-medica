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

@WebServlet(urlPatterns = "/consulta_sem_login/*")
public class ConsultaSemLoginController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private UsuarioDAO dao_usuario;

    @Override
    public void init() {
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
        
        String action = request.getPathInfo();

        if (action == null) {
            action = "";

        }

        System.out.println(action);

        try {
            switch (action) {
                case "/lista":
                    lista(request, response);
                    break;
                case "/lista_especialidade":
                    lista_especialidade(request, response);
                    break;
                default:
                    break;  
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Usuario> listaMedicos = dao_usuario.getMedicos();
        request.setAttribute("listaMedicos", listaMedicos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/sem_login/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void lista_especialidade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String especialidade = request.getParameter("especialidade");
        List<Usuario> listaMedicos = dao_usuario.getByEspecialidade(especialidade);
        request.setAttribute("listaMedicos", listaMedicos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/sem_login/lista.jsp");
        dispatcher.forward(request, response);
    }
}
