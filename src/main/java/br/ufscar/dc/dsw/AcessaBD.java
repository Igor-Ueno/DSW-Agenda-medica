package br.ufscar.dc.dsw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AcessaBD {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Consultorio", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Medico");
            while (rs.next()) {
                System.out.print(rs.getString("Email"));
                System.out.print(", " + rs.getString("Senha"));
                System.out.print(", " + rs.getString("CRM"));
                // Adicione aqui os outros campos que você deseja imprimir
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("A classe do driver de conexão não foi encontrada!");
        } catch (SQLException e) {
            System.out.println("O comando SQL não pode ser executado!");
        }
    }
}