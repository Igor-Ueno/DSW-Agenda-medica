<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Autenticação de Usuário</title>
    </head>
    <body>
        <%
		String contextPath = request.getContextPath().replace("/", "");
	    %>
        <div align="center">
            <h1>Gerenciamento de Pacientes</h1>
            <h2>
                <a href="/<%=contextPath%>/">Menu Principal</a> &nbsp;&nbsp;&nbsp; 
                <a href="/<%=contextPath%>/paciente/cadastro">Adicione Novo Paciente</a>
            </h2>
        </div>
        <div align="center">
            <table border="1">
                <caption>Lista de Pacientes</caption>
                <tr>
                    <th>CPF</th>
                    <th>Login</th>
                    <th>Senha</th>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>Sexo</th>
                    <th>Data de Nascimento</th>
                </tr>
                <c:forEach var="paciente" items="${requestScope.listaPacientes}">
				<tr>
					<td>${paciente.CPF}</td>
					<td>${paciente.login}</td>
					<td>${paciente.senha}</td>
					<td>${paciente.nome}</td>
					<td>${paciente.telefone}</td>
					<td>${paciente.sexo}</td>
                    <td>${paciente.getStringData_Nascimento()}</td>
                    <td><a href="/<%=contextPath%>/paciente/edicao?CPF=${paciente.CPF}">
                        Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/<%=contextPath%>/paciente/remocao?CPF=${paciente.CPF}"
                        onclick="return confirm('Tem certeza de que deseja excluir este item?');">
						Remoção</a></td>
				</tr>
			</c:forEach>
            </table>
        </div>
    </body>
</html>