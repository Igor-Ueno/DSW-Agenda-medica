package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import br.ufscar.dc.dsw.domain.Usuario;

public class UsuarioDAO extends GenericDAO {

    public void insert(Usuario usuario) {

        String sql = "INSERT INTO Usuario (CPF, CRM, login, senha, nome, telefone, sexo, data_nascimento, especialidade, papel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, usuario.getCPF());
            statement.setString(2, usuario.getCRM());
            statement.setString(3, usuario.getLogin());
            statement.setString(4, usuario.getSenha());
            statement.setString(5, usuario.getNome());
            statement.setString(6, usuario.getTelefone());
            statement.setString(7, usuario.getSexo());
            statement.setDate(8, usuario.getData_Nascimento());
            statement.setString(9, usuario.getEspecialidade());
            statement.setString(10, usuario.getPapel());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> getPacientes() {

        List<Usuario> listaPacientes = new ArrayList<>();

        String sql = "SELECT * from Usuario WHERE CPF IS NOT NULL";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String CPF = resultSet.getString("CPF");
                String nome = resultSet.getString("nome");
                String login = resultSet.getString( "login");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                Date data_nascimento = resultSet.getDate("data_nascimento");

                Usuario paciente = new Usuario(CPF, login, senha, nome, telefone, sexo, data_nascimento, papel);
                listaPacientes.add(paciente);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPacientes;
    }

    public List<Usuario> getMedicos() {

        List<Usuario> listaMedicos = new ArrayList<>();

        String sql = "SELECT * from Usuario WHERE CRM IS NOT NULL";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String CRM = resultSet.getString("CRM");
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                String especialidade = resultSet.getString("especialidade");

                Usuario medico = new Usuario(CRM, especialidade, nome, login, senha, papel);
                listaMedicos.add(medico);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaMedicos;
    }

    public void delete(Usuario usuario) {
        String sql = "DELETE FROM Usuario where login = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, usuario.getLogin());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Usuario usuario) {
        String sql = "UPDATE Usuario SET CPF = ?, CRM = ?, telefone =  ?, nome = ?, senha = ?, papel = ?, sexo = ?, data_nascimento = ?, especialidade = ? WHERE login = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, usuario.getCPF());
            statement.setString(2, usuario.getCRM());
            statement.setString(3, usuario.getTelefone());
            statement.setString(4, usuario.getNome());
            statement.setString(5, usuario.getSenha());
            statement.setString(6, usuario.getPapel());
            statement.setString(7, usuario.getSexo());
            statement.setDate(8, usuario.getData_Nascimento());
            statement.setString(9, usuario.getEspecialidade());
            statement.setString(10, usuario.getLogin());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario getByCPF(String CPF) {
        Usuario usuario = null;

        String sql = "SELECT * from Usuario WHERE CPF = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, CPF);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                java.sql.Date data_nascimento = resultSet.getDate("data_nascimento");

                usuario = new Usuario(CPF, login, senha, nome,telefone, sexo, data_nascimento, papel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    public Usuario getByCRM(String CRM) {
        Usuario usuario = null;

        String sql = "SELECT * from Usuario WHERE CRM = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, CRM);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                String especialidade = resultSet.getString("especialidade");

                usuario = new Usuario(CRM, especialidade, nome, login, senha, papel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
    
   public Usuario getByLogin(String login) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE login = ?";

        try (Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String CPF = resultSet.getObject("CPF") != null ? resultSet.getString("CPF") : null;
                    String CRM = resultSet.getObject("CRM") != null ? resultSet.getString("CRM") : null;
                    String nome = resultSet.getObject("nome") != null ? resultSet.getString("nome") : null;
                    String senha = resultSet.getObject("senha") != null ? resultSet.getString("senha") : null;
                    String papel = resultSet.getObject("papel") != null ? resultSet.getString("papel") : null;
                    Date data_nascimento = resultSet.getObject("data_nascimento") != null ? resultSet.getDate("data_nascimento") : null;
                    String telefone = resultSet.getObject("telefone") != null ? resultSet.getString("telefone") : null;
                    String especialidade = resultSet.getObject("especialidade") != null ? resultSet.getString("especialidade") : null;
                    String sexo = resultSet.getObject("sexo") != null ? resultSet.getString("sexo") : null;
                    
                    usuario = new Usuario(CPF, CRM, nome, login, senha, papel, data_nascimento, telefone, especialidade, sexo);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
}