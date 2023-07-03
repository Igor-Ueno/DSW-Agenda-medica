package br.ufscar.dc.dsw.domain;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
// import java.util.Calendar;
import java.time.LocalDate;

public class Usuario {

	private String CPF;
    private String CRM;
	private String nome;
	private String login;
	private String senha;
	private String papel;
    private Date data_nascimento;
    private String telefone;
    private String especialidade;
    private String sexo;

	public Usuario(String nome, String login, String senha, String papel) {
		this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.papel = papel;
	}

	public Usuario(String CPF, String login, String senha, String nome, String telefone, String sexo, Date data_nascimento, String papel) {
        this.CPF = CPF;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
        this.login = login;
		this.senha = senha;
		this.papel = papel;
        this.telefone = telefone;
        this.nome = nome;
	}

	public Usuario(String CRM, String especialidade, String nome, String login, String senha, String papel) {
        this.especialidade = especialidade;
        this.CRM = CRM;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.papel = papel;
	}

    public Usuario(String CPF, String CRM, String nome, String login, String senha, String papel, Date data_nascimento, String telefone, String especialidade, String sexo)
    {
        this.CPF = CPF;
        this.CRM = CRM;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.papel = papel;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.sexo = sexo;
    }

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

    public String getCRM() {
		return CRM;
	}

    public void setCRM(String CRM) {
		this.CRM = CRM;
	}

    public String getSexo(){
        return sexo;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getEspecialidade(){
        return especialidade;
    }

    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }

    public Date getData_Nascimento(){
        return data_nascimento;
    }

    public void setData_Nascimento(Date data_nascimento){
        this.data_nascimento = data_nascimento;
    }

    public String getStringData_Nascimento(){ 
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");  
        String strDate = dateFormat.format(data_nascimento);
        return strDate;
    }

    public void setStringData_Nascimento(String data_nascimento_str){
        LocalDate localDate = LocalDate.parse(data_nascimento_str);
        this.data_nascimento = Date.valueOf(localDate);
    }
}
