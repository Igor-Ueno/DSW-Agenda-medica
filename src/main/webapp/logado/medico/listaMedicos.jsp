<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
    <fmt:bundle basename="message">
        <head>
            <title>Consultório</title>
        </head>
        <body>
            <%
            String contextPath = request.getContextPath().replace("/", "");
            %>
            <div align="center">
                <h1>É isso aí de Médicos</h1>
                <h2>
                    <a href="/<%=contextPath%>">Menu Principal</a>
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
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </body>
    </fmt:bundle>
    
</html>