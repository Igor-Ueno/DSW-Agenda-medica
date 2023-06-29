package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Usuario {

	private String CPF;
    private String CRM;
	private String nome;
	private String email;
	private String senha;
	private String papel;
    private Date data_nascimento;
    private String telefone;
    private String especialidade;
    private String sexo;

	public Usuario(String nome, String email, String senha, String papel) {
		this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.papel = papel;
	}

	public Usuario(String CPF, String email, String senha, String telefone, String sexo, Date data_nascimento, String papel) {
		this.CPF = CPF;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
        this.email = email;
		this.senha = senha;
		this.papel = papel;
        this.telefone = telefone;
	}

	public Usuario(String CRM, String especialidade, String nome, String email, String senha, String papel) {
		this.especialidade = especialidade;
        this.CRM = CRM;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.papel = papel;
	}

    public Usuario(String CPF, String CRM, String nome, String email, String senha, String papel, Date data_nascimento, String telefone, String especialidade, String sexo)
    {
        this.CPF = CPF;
        this.CRM = CRM;
        this.nome = nome;
        this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
}