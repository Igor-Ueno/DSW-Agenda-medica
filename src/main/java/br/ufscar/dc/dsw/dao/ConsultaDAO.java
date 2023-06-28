package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import br.ufscar.dc.dsw.domain.Consulta;

public class ConsultaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USUARIO = "seu_usuario";
    private static final String SENHA = "sua_senha";

    public List<Consulta> listarConsultas() {
        List<Consulta> consultas = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Consulta");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String CPF = resultSet.getString("CPF");
                String CRM = resultSet.getString("CRM");
                java.sql.Timestamp dataHoraSql = resultSet.getTimestamp("data_hora");
                Consulta consulta = new Consulta(id, CPF, CRM, dataHoraSql);
                consultas.add(consulta);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public void insert(Consulta consulta) {
        try {
            Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Consulta (id, CPF, CRM, data_hora) VALUES (?, ?, ?, ?)");
            statement.setLong(1, consulta.getId());
            statement.setString(2, consulta.getCPF());
            statement.setString(3, consulta.getCRM());
            java.sql.Timestamp dataHoraSql = new java.sql.Timestamp(consulta.getDataHora().getTime());
            statement.setTimestamp(4, dataHoraSql);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Consulta consulta) {
        try {
            Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM Consulta WHERE id = ? AND CPF = ? AND CRM = ?");
            statement.setLong(1, consulta.getId());
            statement.setString(2, consulta.getCPF());
            statement.setString(3, consulta.getCRM());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Consulta consulta) {
        try {
            Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Consulta SET data_hora = ? WHERE id = ? AND CPF = ? AND CRM = ?");
            java.sql.Timestamp dataHoraSql = new java.sql.Timestamp(consulta.getDataHora().getTime());
            statement.setTimestamp(1, dataHoraSql);
            statement.setLong(2, consulta.getId());
            statement.setString(3, consulta.getCPF());
            statement.setString(4, consulta.getCRM());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Consulta get(Long id, String CPF, String CRM,Timestamp dataHora) {
        Consulta consulta = null;
        try {
            Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Consulta WHERE id = ? AND CPF = ? AND CRM = ?");
            statement.setLong(1, id);
            statement.setString(2, CPF);
            statement.setString(3, CRM);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                java.sql.Timestamp dataHoraSql = resultSet.getTimestamp("data_hora");
                consulta = new Consulta(id, CPF, CRM, dataHoraSql);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consulta;
    }

}
