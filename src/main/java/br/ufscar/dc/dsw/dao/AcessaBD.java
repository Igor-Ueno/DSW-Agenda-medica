package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AcessaBD {

	public static void main(String[] args) {
		try {

			/* Setup para uso do banco de dados MySQL */
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Login";
			Connection con = (Connection) DriverManager.getConnection(url,
					"root", "root");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Usuario");
			while (rs.next()) {
				System.out.print(rs.getString("CPF"));
				System.out.print(", " + rs.getString("CMR"));
                System.out.print(", " + rs.getString("login"));
                System.out.print(", " + rs.getString("senha"));
				System.out.print(", " + rs.getString("nome"));
                System.out.print(", " + rs.getString("telefone"));
                System.out.print(", " + rs.getString("sexo"));
                System.out.print(", " + rs.getDate("data_nascimento"));
				System.out.print(", " + rs.getString("especialidade"));
                System.out.print(", " + rs.getString("papel"));
			}
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("A classe do driver de conexão não foi encontrada!");
		} catch (SQLException e) {
			System.out.println("O comando SQL não pode ser executado!");
		}
	}
}
