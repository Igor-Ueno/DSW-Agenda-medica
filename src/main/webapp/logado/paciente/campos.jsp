
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table border="1">
	<caption>
		<c:choose>
			<c:when test="${paciente != null}">
				<fmt:message key="form.edition"/>
			</c:when>
			<c:otherwise>
                <fmt:message key="form.register"/>
			</c:otherwise>
		</c:choose>
	</caption>

	<tr>
		<td><label for="CPF"><fmt:message key="user.CPF"/></label></td>
		<td><input type="text" id="CPF" name="CPF" size="45"
			required value="${paciente.CPF}" /></td>
	</tr>
	<tr>
		<td><label for="login"><fmt:message key="user.login"/></label></td>
		<td><input type="text" id="login" name="login" size="45" required
			value="${paciente.login}" /></td>
	</tr>
    <tr>
		<td><label for="senha"><fmt:message key="user.password"/></label></td>
		<td><input type="text" id="senha" name="senha" size="45" required
			value="${paciente.senha}" /></td>
	</tr>
    <tr>
		<td><label for="nome"><fmt:message key="user.name"/></label></td>
		<td><input type="text" id="nome" name="nome" size="45" required
			value="${paciente.nome}" /></td>
	</tr>
    <tr>
		<td><label for="telefone"><fmt:message key="user.telephone"/></label></td>
		<td><input type="text" id="telefone" name="telefone" size="45" required
			value="${paciente.telefone}" /></td>
	</tr>

    <tr>
		<td><label for="sexo"><fmt:message key="user.sex"/></label></td>
		<td><input type="text" id="sexo" name="sexo" size="45" required
			value="${paciente.sexo}" /></td>
	</tr>

    <tr>
		<td><label for="data_nascimento"><fmt:message key="user.birthday"/></label></td>
		<td><input type="date" id="data_nascimento" name="data_nascimento" size="45" required
			value="${paciente.getStringData_Nascimento()}" /></td>
	</tr>

	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>