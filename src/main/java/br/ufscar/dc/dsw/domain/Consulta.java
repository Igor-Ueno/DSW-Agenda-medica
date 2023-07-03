package br.ufscar.dc.dsw.domain;

import java.sql.Date;
// import java.text.DateFormat;
// import java.text.SimpleDateFormat;
// import java.util.Calendar;
// import java.time.LocalDate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Consulta {
    
    private String CPFpaciente;
    private String CRMmedico;
    private Date data_consulta;
    private String hora;

    public Consulta(String CPFpaciente, String CRMmedico, Date data_consulta, String hora) {
        this.CPFpaciente = CPFpaciente;
        this.CRMmedico = CRMmedico;
        this.data_consulta = data_consulta;
        this.hora = hora;
    }

    public String getCPFpaciente() {
        return CPFpaciente;
    }

    public void setCPFpaciente(String CPFpaciente) {
        this.CPFpaciente = CPFpaciente;
    }

    public String getCRMmedico() {
        return CRMmedico;
    }

    public void setCRMmedico(String CRMmedico) {
        this.CRMmedico = CRMmedico;
    }

    public Date getData_Consulta() {
        return data_consulta;
    }

    public void setData_Consulta(Date data_consulta) {
        this.data_consulta = data_consulta;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getStringData_Consulta(){ 
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
        String strDate = dateFormat.format(data_consulta);
        return strDate;
    }

    public void setStringData_Consulta(String data_consulta_str){
        LocalDate localDate = LocalDate.parse(data_consulta_str);
        this.data_consulta = Date.valueOf(localDate);
    }

    public String getCRMAlt(){
        String[] array = CRMmedico.split("/");
        String CRMalt = array[0] + "-" + array[1];
        return CRMalt;
    }
}
