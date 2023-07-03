package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Usuario;

public class ConsultaDAO extends GenericDAO {

    public void insert(Consulta consulta) {

        String sql = "INSERT INTO Consulta (CPFpaciente, CRMmedico, data_consulta, hora) VALUES (?, ?, ?, ?)";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, consulta.getCPFpaciente());
            statement.setString(2, consulta.getCRMmedico());
            statement.setDate(3, consulta.getData_Consulta());
            statement.setString(4, consulta.getHora());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Consulta> getByCPF(String CPFpaciente) {

        List<Consulta> listaConsultas = new ArrayList<>();

        String sql = "SELECT * from Consulta WHERE CPFpaciente = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, CPFpaciente);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String CPF = resultSet.getString("CPFpaciente");
                String nome = resultSet.getString("CRMmedico");
                Date login = resultSet.getDate("data_consulta");
                String senha = resultSet.getString("hora");

                Consulta consulta = new Consulta(CPF, nome, login, senha);
                listaConsultas.add(consulta);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaConsultas;
    }

    public List<Consulta> getByCRM(String CRMmedico) {

        List<Consulta> listaConsultas = new ArrayList<>();

        String sql = "SELECT * from Consulta WHERE CRMmedico = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, CRMmedico);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String CPF = resultSet.getString("CPFpaciente");
                String nome = resultSet.getString("CRMmedico");
                Date login = resultSet.getDate("data_consulta");
                String senha = resultSet.getString("hora");

                Consulta consulta = new Consulta(CPF, nome, login, senha);
                listaConsultas.add(consulta);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaConsultas;
    }

    public void delete(Consulta consulta) {
        String sql = "DELETE FROM Consulta WHERE CPFpaciente = ? AND CRMmedico = ? AND data_consulta = ? AND hora = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, consulta.getCPFpaciente());
            statement.setString(1, consulta.getCRMmedico());
            statement.setDate(1, consulta.getData_Consulta());
            statement.setString(1, consulta.getHora());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }    
}
