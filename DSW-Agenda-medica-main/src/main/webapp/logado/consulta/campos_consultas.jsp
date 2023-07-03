<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="1">
	<tr>
		<td><label for="CPFpaciente">CPF</label></td>
		<td><input type="text" id="CPFpaciente" name="CPFpaciente" size="45"
			required value="${consulta.CPFpaciente}" /></td>
	</tr>

    <tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>
