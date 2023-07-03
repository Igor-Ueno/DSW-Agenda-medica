<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${medico != null}">
                            Edição
                        </c:when>
			<c:otherwise>
                            Cadastro
                        </c:otherwise>
		</c:choose>
	</caption>
	
	<tr>
		<td><label for="CRM">CRM</label></td>
		<td><input type="text" id="CRM" name="CRM" size="45"
			required value="${medico.CRM}" /></td>
	</tr>
	<tr>
		<td><label for="login">Login</label></td>
		<td><input type="text" id="login" name="login" size="45" required
			value="${medico.login}" /></td>
	</tr>
    <tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="text" id="senha" name="senha" size="45" required
			value="${medico.senha}" /></td>
	</tr>
    <tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome" size="45" required
			value="${medico.nome}" /></td>
	</tr>

	<tr>
		<td><label for="especialidade">Especialidade</label></td>
		<td><input type="text" id="especialidade" name="especialidade" size="45" required
			value="${medico.especialidade}" /></td>
	</tr>
    
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>