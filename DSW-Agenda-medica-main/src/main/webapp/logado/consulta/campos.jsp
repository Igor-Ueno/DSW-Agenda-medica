<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="1">
	<caption>
        Agendamento de Consulta
	</caption>

	<tr>
		<td><label for="CPFpaciente">CPF</label></td>
		<td><input type="text" id="CPFpaciente" name="CPFpaciente" size="45"
			required value="${consulta.CPFpaciente}" /></td>
	</tr>

    <tr>
		<td><label for="CRMmedico">CRM do médico selecionado</label></td>
		<td><input type="text" id="CRMmedico" name="CRMmedico" size="45"
            required value="${consulta.CRMmedico}" /></td>
	</tr>

    <tr>
		<td><label for="data_consulta">Data da Consulta</label></td>
		<td><input type="date" id="data_consulta" name="data_consulta" size="45" required
			value="${consulta.getStringData_Consulta()}" /></td>
	</tr>

    

    <tr>
		<td><label for="hora">Horário</label></td>
		<td><input type="text" id="hora" name="hora" size="45"
			required value="${consulta.hora}" /></td>
	</tr>


	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>

<script>
    // Obtendo o valor do parâmetro "CRM" da URL
    var urlParams = new URLSearchParams(window.location.search);
    var valorCRM = urlParams.get("CRM");

    // Você pode atribuir o valor a um campo de entrada, exibir em um elemento HTML, etc.
    document.getElementById("CRMmedico").value = valorCRM;
</script>

