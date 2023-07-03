<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
    <fmt:bundle basename="message">
        <head>
            <title>Lista de Médicos por Especialidade</title>
        </head>
        <body>
            <h1>Lista de Médicos por Especialidade</h1>
            
            <table border="1">
                <caption>Lista de Médicos por Especialidade</caption>
                <tr>
                    <th>CRM</th>
                    <th>Login</th>
                    <th>Senha</th>
                    <th>Nome</th>
                    <th>Especialidade</th>
                </tr>
                <c:forEach var="medico" items="${requestScope.listaMedicosPorEspecialidade}">
                    <tr>
                        <td>${medico.CRM}</td>
                        <td>${medico.login}</td>
                        <td>${medico.senha}</td>
                        <td>${medico.nome}</td>
                        <td>${medico.especialidade}</td>
                    </tr>
                </c:forEach>
            </table>            
            <br/>
            <a href="/Consulta/">Voltar</a>
        </body>
    </fmt:bundle>
</html>