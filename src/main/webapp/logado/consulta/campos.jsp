
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="1">
	<caption>
		<fmt:message key="form.register"/>
	</caption>

	<tr>
		<td><label for="CPFpaciente"><fmt:message key="user.CPF"/></label></td>
		<td><input type="text" id="CPFpaciente" name="CPFpaciente" size="45" readonly="true" required value="${CPFpaciente}"/></td>
	</tr>
	<tr>
		<td><label for="CRMmedico"><fmt:message key="user.CRM"/></label></td>
		<td><input type="text" id="CRMmedico" name="CRMmedico" size="45" required/></td>
	</tr>
    <tr>
		<td><label for="data_consulta"><fmt:message key="appointment.date"/></label></td>
		<td><input type="date" id="data_consulta" name="data_consulta" size="45" required/></td>
	</tr>
    <tr>
		<td><label for="hora"><fmt:message key="appointment.time"/></label></td>
		<td><input type="text" id="hora" name="hora" size="45" required/></td>
	</tr>

	<tr>
		<td colspan="2" align="center"><input type="submit" value="<fmt:message key="form.save"/>" /></td>
	</tr>
</table>