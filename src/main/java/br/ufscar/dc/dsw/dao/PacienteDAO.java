package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import br.ufscar.dc.dsw.domain.Paciente;

public class PacienteDAO extends GenericDAO {

    public void insert(Paciente paciente) {

        String sql = "INSERT INTO Paciente (email, senha, CPF, nome, telefone, sexo, data_nascimento, papel) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, paciente.getEmail());
            statement.setString(2, paciente.getSenha());
            statement.setString(3, paciente.getCPF());
            statement.setString(4, paciente.getNome());
            statement.setString(5, paciente.getTelefone());
            statement.setString(6, paciente.getSexo());
            statement.setDate(7, paciente.getDataNascimento());
            statement.setString(8, paciente.getPapel());

            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Paciente> getAll() {

        List<Paciente> listaPacientes = new ArrayList<>();

        String sql = "SELECT * from Paciente";

        try {
        	Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery(); 
            
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String CPF = resultSet.getString("CPF");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                Date data_nascimento = resultSet.getDate("data_nascimento");
                String papel = resultSet.getString("papel");
                Paciente new_paciente = new Paciente(email, senha, CPF, nome, telefone, sexo, data_nascimento, papel);
                listaPacientes.add(new_paciente);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPacientes;
    }

    public void delete(Paciente paciente) {
        String sql = "DELETE FROM Paciente where CPF = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, paciente.getCPF());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }

    public void update(Paciente paciente) {
        String sql = "UPDATE Paciente SET email = ?, senha = ?, nome = ?, telefone = ?, sexo = ?, data_nascimento = ?, papel = ? WHERE CPF = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, paciente.getEmail());
            statement.setString(2, paciente.getSenha());
            statement.setString(3, paciente.getNome());
            statement.setString(4, paciente.getTelefone());
            statement.setString(5, paciente.getSexo());
            statement.setDate(6, paciente.getDataNascimento());
            statement.setString(7, paciente.getPapel());

            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Paciente get(String CPF) {
        Paciente paciente = null;

        String sql = "SELECT * from CPF p, where p.CPF = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, CPF);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                Date data_nascimento = resultSet.getDate("data_nascimento");
                String papel = resultSet.getString("papel");

                paciente = new Paciente(email, senha, CPF, nome, telefone, sexo, data_nascimento, papel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paciente;
    }
}
