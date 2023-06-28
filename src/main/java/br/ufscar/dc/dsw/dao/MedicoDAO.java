package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Medico;
//import br.ufscar.dc.dsw.domain.Paciente;

public class MedicoDAO extends GenericDAO {

    public void insert(Medico medico) {

        String sql = "INSERT INTO Medico (email, senha, CRM, nome, especialidade, sexo, papel) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, medico.getEmail());
            statement.setString(2, medico.getSenha());
            statement.setString(3, medico.getCRM());
            statement.setString(4, medico.getNome());
            statement.setString(5, medico.getEspecialidade());
            statement.setString(6, medico.getSexo());
            statement.setString(7, medico.getPapel());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Medico> getAll() {

        List<Medico> listaMedicos = new ArrayList<>();

        String sql = "SELECT * from Medico";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String CRM = resultSet.getString("CRM");
                String nome = resultSet.getString("nome");
                String especialidade = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                String papel = resultSet.getString("papel");
                Medico new_medico = new Medico(email, senha, CRM, nome, especialidade, sexo, papel);
                listaMedicos.add(new_medico);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaMedicos;
    }

    public void delete(Medico medico) {
        String sql = "DELETE FROM Editora where CRM = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, medico.getCRM());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Medico medico) {
        String sql = "UPDATE Editora SET cnpj = ?, nome = ?";
        sql += " WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, medico.getEmail());
            statement.setString(2, medico.getSenha());
            statement.setString(3, medico.getNome());
            statement.setString(4, medico.getEspecialidade());
            statement.setString(5, medico.getSexo());
            
            statement.setString(6, medico.getPapel());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Medico get(String CRM) {
        Medico medico = null;

        String sql = "SELECT * from Medico where CRM = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, CRM);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String especialidade = resultSet.getString("especialidade");
                String sexo = resultSet.getString("sexo");
               
                String papel = resultSet.getString("papel");
                medico = new Medico(email,senha,CRM,nome,especialidade,sexo,papel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return medico;
    }
}