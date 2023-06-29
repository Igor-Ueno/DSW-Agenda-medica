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

        String sql = "INSERT INTO Usuario (CPF, CRM, email, senha, nome, telefone, sexo, data_nascimento, especialidade, papel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, usuario.getCPF());
            statement.setString(2, usuario.getCRM());
            statement.setString(3, usuario.getEmail());
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
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                Date data_nascimento = resultSet.getDate("data_nascimento");

                Usuario paciente = new Usuario(CPF, email, senha, nome, telefone, sexo, data_nascimento, papel);
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
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                String especialidade = resultSet.getString("especialidade");

                Usuario medico = new Usuario(CRM, especialidade, nome, email, senha, papel);
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
        String sql = "DELETE FROM Usuario where email = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, usuario.getEmail());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Usuario usuario) {
        String sql = "UPDATE Usuario SET CPF = ?, CRM = ?, telefone =  ?, nome = ?, senha = ?, papel = ?, sexo = ?, data_nascimento = ?, especialidade = ? WHERE email = ?";

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
            statement.setString(10, usuario.getEmail());
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
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                java.sql.Date data_nascimento = resultSet.getDate("data_nascimento");

                usuario = new Usuario(CPF, email, senha, nome,telefone, sexo, data_nascimento, papel);
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
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                String especialidade = resultSet.getString("especialidade");

                usuario = new Usuario(CRM, especialidade, nome, email, senha, papel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
    
    public Usuario getByEmail(String email) {
        Usuario usuario = null;

        String sql = "SELECT * from Usuario WHERE email = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String CPF = resultSet.getString("CPF");
                String CRM= resultSet.getString("CRM");
                String nome= resultSet.getString("nome");
                String senha= resultSet.getString("senha");
                String papel= resultSet.getString("papel");
                java.sql.Date data_nascimento = resultSet.getDate("data_nascimento");
                String telefone= resultSet.getString("telefone");
                String especialidade = resultSet.getString("especialidade");
                String sexo = resultSet.getString("sexo");

                usuario = new Usuario(CPF, CRM, nome, email, senha, papel, data_nascimento, telefone, especialidade, sexo);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
}