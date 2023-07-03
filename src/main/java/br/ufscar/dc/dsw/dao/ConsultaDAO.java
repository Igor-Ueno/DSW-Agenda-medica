package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.ufscar.dc.dsw.domain.Consulta;

public class ConsultaDAO extends GenericDAO {

    public void insert(Consulta consulta) {

        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        String sql = "INSERT INTO Consulta (CPFpaciente, CRMmedico, data_consulta, hora) VALUES (?, ?, ?, ?)";
        
        try {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            System.out.println(consulta.getCPFpaciente());
            System.out.println(consulta.getCRMmedico());
            System.out.println(consulta.getData_Consulta());
            System.out.println(consulta.getHora());

            statement.setString(1, consulta.getCPFpaciente());
            statement.setString(2, consulta.getCRMmedico());
            statement.setDate(3, consulta.getData_Consulta());
            statement.setTime(4, consulta.getHora());
            statement.executeUpdate();

            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            System.out.println(consulta.getCPFpaciente());
            System.out.println(consulta.getCRMmedico());
            System.out.println(consulta.getData_Consulta());
            System.out.println(consulta.getHora());


            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Consulta> getAll() {

        List<Consulta> listaConsultas = new ArrayList<>();

        String sql = "SELECT * FROM Consulta";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String CPF = resultSet.getString("CPFpaciente");
                String CRM = resultSet.getString("CRMmedico");
                Date data_consulta = resultSet.getDate("data_consulta");
                Time hora = resultSet.getTime("hora");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println(resultSet.getString("CPFpaciente"));
                System.out.println(resultSet.getString("CRMmedico"));
                System.out.println(resultSet.getDate("data_consulta"));
                System.out.println(resultSet.getTime("hora"));

                Consulta consulta = new Consulta(CPF, CRM, data_consulta, hora);
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

    public List<Consulta> getByCPF(String CPFpaciente) {

        List<Consulta> listaConsultas = new ArrayList<>();

        String sql = "SELECT * FROM Consulta WHERE CPFpaciente = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            System.out.println(CPFpaciente);
            statement.setString(1, CPFpaciente);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String CPF = resultSet.getString("CPFpaciente");
                String CRM = resultSet.getString("CRMmedico");
                Date data_consulta = resultSet.getDate("data_consulta");
                Time hora = resultSet.getTime("hora");
                System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbb");
                System.out.println(resultSet.getString("CPFpaciente"));
                System.out.println(resultSet.getString("CRMmedico"));
                System.out.println(resultSet.getDate("data_consulta"));
                System.out.println(resultSet.getTime("hora"));

                Consulta consulta = new Consulta(CPF, CRM, data_consulta, hora);
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

        System.out.println(CRMmedico);

        List<Consulta> listaConsultas = new ArrayList<>();

        String sql = "SELECT * from Consulta WHERE CRMmedico = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            System.out.println(CRMmedico);
            statement.setString(1, CRMmedico);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String CPF = resultSet.getString("CPFpaciente");
                String CRM = resultSet.getString("CRMmedico");
                Date data_consulta = resultSet.getDate("data_consulta");
                Time hora = resultSet.getTime("hora");
                System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                System.out.println(resultSet.getString("CPFpaciente"));
                System.out.println(resultSet.getString("CRMmedico"));
                System.out.println(resultSet.getDate("data_consulta"));
                System.out.println(resultSet.getTime("hora"));

                Consulta consulta = new Consulta(CPF, CRM, data_consulta, hora);
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
            statement.setString(2, consulta.getCRMmedico());
            statement.setDate(3, consulta.getData_Consulta());
            statement.setTime(4, consulta.getHora());
            System.out.println("ccccccccccccccccccccccccccccccccccccccccc");
            System.out.println(consulta.getCPFpaciente());
            System.out.println(consulta.getCRMmedico());
            System.out.println(consulta.getData_Consulta());
            System.out.println(consulta.getHora());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkHour(String CPFpaciente, String CRMmedico, Date data_consulta_toCheck, Time hora_toCheck) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String current_date = dtf.format(now);
        String date_toCheck = (data_consulta_toCheck.toString() + " " + hora_toCheck.toString());

        System.out.println(current_date);
        System.out.println(date_toCheck);

        String sql_pac = "SELECT * from Consulta WHERE CPFpaciente = ?";
        String sql_med = "SELECT * from Consulta WHERE CRMmedico = ?";

        try {
            Connection conn_pac = this.getConnection();
            Connection conn_med = this.getConnection();
            PreparedStatement statement_pac = conn_pac.prepareStatement(sql_pac);
            PreparedStatement statement_med = conn_med.prepareStatement(sql_med);
            System.out.println(CRMmedico);

            statement_pac.setString(1, CPFpaciente);
            statement_med.setString(1, CRMmedico);
            ResultSet resultSet_pac = statement_pac.executeQuery();
            ResultSet resultSet_med = statement_med.executeQuery();
            System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
            String data_consulta_toCheck_str = data_consulta_toCheck.toString();
            String hora_toCheck_str = hora_toCheck.toString();
            System.out.println(data_consulta_toCheck_str);

            System.out.println(hora_toCheck_str);


            while (resultSet_pac.next() && resultSet_med.next()) {
                Date data_consulta_pac = resultSet_pac.getDate("data_consulta");
                Time hora_pac = resultSet_pac.getTime("hora");

                String data_consulta_pac_str = data_consulta_pac.toString();
                String hora_pac_str = hora_pac.toString();

                System.out.println(data_consulta_pac_str+hora_pac_str);
                System.out.println(data_consulta_toCheck_str+hora_toCheck_str);

                if((data_consulta_pac_str+hora_pac_str).equals(data_consulta_toCheck_str+hora_toCheck_str)) {
                    return false;
                }

                Date data_consulta_med = resultSet_med.getDate("data_consulta");
                Time hora_med = resultSet_med.getTime("hora");

                String data_consulta_med_str = data_consulta_med.toString();
                String hora_med_str = hora_med.toString();

                System.out.println(data_consulta_med_str+hora_med_str);
                System.out.println(data_consulta_toCheck_str+hora_toCheck_str);
                
                if((data_consulta_med_str+hora_med_str).equals(data_consulta_toCheck_str+hora_toCheck_str)) {
                    return false;
                }
            }

            resultSet_pac.close();
            resultSet_med.close();
            statement_pac.close();
            statement_med.close();
            conn_pac.close();
            conn_med.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
