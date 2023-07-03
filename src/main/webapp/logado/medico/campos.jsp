<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table border="1">
	<caption>
		<c:choose>
			<c:when test="${medico != null}">
				<fmt:message key="form.edition"/>
			</c:when>
			<c:otherwise>
				<fmt:message key="form.register"/>
			</c:otherwise>
		</c:choose>
	</caption>
	
	<tr>
		<td><label for="CRM"><fmt:message key="user.CRM"/></label></td>
		<td><input type="text" id="CRM" name="CRM" size="45"
			required value="${medico.CRM}" /></td>
	</tr>
	<tr>
		<td><label for="login"><fmt:message key="user.login"/></label></td>
		<td><input type="text" id="login" name="login" size="45" required
			value="${medico.login}" /></td>
	</tr>
    <tr>
		<td><label for="senha"><fmt:message key="user.password"/></label></td>
		<td><input type="text" id="senha" name="senha" size="45" required
			value="${medico.senha}" /></td>
	</tr>
    <tr>
		<td><label for="nome"><fmt:message key="user.name"/></label></td>
		<td><input type="text" id="nome" name="nome" size="45" required
			value="${medico.nome}" /></td>
	</tr>

	<tr>
		<td><label for="especialidade"><fmt:message key="user.specialty"/></label></td>
		<td><input type="text" id="especialidade" name="especialidade" size="45" required
			value="${medico.especialidade}" /></td>
	</tr>
    
	<tr>
		<td colspan="2" align="center"><input type="submit" value="<fmt:message key="form.save"/>"/></td>
	</tr>
</table>