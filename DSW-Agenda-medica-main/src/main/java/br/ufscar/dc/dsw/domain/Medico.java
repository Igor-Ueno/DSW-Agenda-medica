package br.ufscar.dc.dsw.domain;

public class Medico {
    private String email;
    private String senha;
    private String CRM;
    private String nome;
    private String especialidade;
    private String sexo;
    private String papel;

    public Medico(String email, String senha, String CRM, String nome, String especialidade, String sexo, String papel) {
        this.email = email;
        this.senha = senha;
        this.CRM = CRM;
        this.nome = nome;
        this.especialidade = especialidade;
        this.sexo = sexo;
        this.papel = papel;
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

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPapel() {
		return papel;
	}

    public void setPapel(String papel) {
		this.papel = papel;
	}
}