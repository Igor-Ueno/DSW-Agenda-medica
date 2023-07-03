package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Paciente {

	private String email;
	private String senha;
	private String CPF;
	private String nome;
	private String telefone;
	private String sexo;
	private Date data_nascimento;
	private String papel;

	public Paciente(String email, String senha, String CPF, String nome, String telefone, String sexo,
			Date data_nascimento, String papel) {
		this.email = email;
		this.senha = senha;
		this.CPF = CPF;
		this.nome = nome;
		this.telefone = telefone;
		this.sexo = sexo;
		this.data_nascimento = data_nascimento;
		this.papel = papel;
	}

	// public Paciente(String data, Float valor, Livro livro, Usuario usuario) {
	// super();
	// this.data = data;
	// this.valor = valor;
	// this.livro = livro;
	// this.usuario = usuario;
	// }

	// Getters
	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getCPF() {
		return CPF;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public Date getDataNascimento() {
		return data_nascimento;
	}

	public String getPapel() {
		return papel;
	}

	// Setters
	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setDataNascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
}