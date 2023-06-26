package br.ufscar.dc.dsw.domain;
import java.sql.Timestamp;

public class Consulta {
    private Long id;
    private String CPF;
    private String CRM;
    private Timestamp data_hora;

    public Consulta(Long id, String CPF, String CRM, Timestamp data_hora) {
        this.id = id;
        this.CPF = CPF;
        this.CRM = CRM;
        this.data_hora = data_hora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public Timestamp getDataHora() {
        return data_hora;
    }

    public void setDataHora(Timestamp data_hora) {
        this.data_hora = data_hora;
    }
}