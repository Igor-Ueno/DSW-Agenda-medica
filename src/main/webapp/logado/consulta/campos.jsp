
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.time.LocalDate"%>
<table border="1">
	<caption>
		<fmt:message key="form.register"/>
	</caption>
	<tr>
		<td><label for="CPFpaciente"><fmt:message key="user.CPF"/></label></td>
		<td><input type="text" id="CPFpaciente" name="CPFpaciente" size="45" readonly="true" value="${CPF}" required/></td>
	</tr>
	<tr>
		<td><label for="CRMmedico"><fmt:message key="user.CRM"/></label></td>
		<td><input type="text" id="CRMmedico" name="CRMmedico" size="45" readonly="true" value="${CRM}" required/></td>
	</tr>
    <tr>
		<td><label for="data_consulta"><fmt:message key="appointment.date"/></label></td>
		<script language="javascript">
			var today = new Date();
			var dd = String(today.getDate()).padStart(2, '0');
			var mm = String(today.getMonth() + 1).padStart(2, '0');
			var yyyy = today.getFullYear();
	
			today = yyyy + '-' + mm + '-' + dd;
			$('#data_consulta').attr('min',today);
		</script>
		<td><input type="date" id="data_consulta" name="data_consulta" size="45" min="<%= LocalDate.now() %>" required/></td>
	</tr>
    <tr>
		<td><label for="hora"><fmt:message key="appointment.time"/></label></td>
		<td><input type="time" id="hora" name="hora" size="45" step="1800" min="08:00" max="20:00" required/></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="<fmt:message key="form.save"/>">
	</tr>
</table>
<script>
    // Obtendo o valor do parâmetro "CRM" da URL
    var urlParams = new URLSearchParams(window.location.search);
    var valorCRM = urlParams.get("CRM");
	var valorCPF = urlParams.get("CPF");

    // Você pode atribuir o valor a um campo de entrada, exibir em um elemento HTML, etc.
    document.getElementById("CRMmedico").value = valorCRM;
    document.getElementById("CPFpaciente").value = valorCPF;
</script>
<script>

</script>
