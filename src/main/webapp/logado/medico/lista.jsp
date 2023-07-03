<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Consultório</title>
    </head>
    <body>
        <%
        String contextPath = request.getContextPath().replace("/", "");
        %>
        <div align="center">
            <h1>Gerenciamento de Médicos</h1>
            <h2>
                <a href="/<%=contextPath%>">Menu Principal</a> &nbsp;&nbsp;&nbsp; 
                <a href="/<%=contextPath%>/medico/cadastro">Adicione Novo Médico</a>
            </h2>
        </div>

        <div align="center">
            <table border="1">
                <caption>Lista de Médicos</caption>
                <tr>
                    <th>CRM</th>
                    <th>Login</th>
                    <th>Senha</th>
                    <th>Nome</th>
                    <th>Especialidade</th>
                </tr>
                <c:forEach var="medico" items="${requestScope.listaMedicos}">
                    <tr>
                        <td>${medico.CRM}</td>
                        <td>${medico.login}</td>
                        <td>${medico.senha}</td>
                        <td>${medico.nome}</td>
                        <td>${medico.especialidade}</td>
                        <td><a href="/<%=contextPath%>/medico/edicao?CRM=${medico.CRM}">
                            Edição</a>
                            &nbsp;&nbsp;&nbsp;&nbsp; <a
                            href="/<%=contextPath%>/medico/remocao?CRM=${medico.CRM}"
                            onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                            Remoção </a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>