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
            <h1>Agendamento</h1>
        </div>

        <div align="center">
            <table border="1">
                <caption>Médicos</caption>
                <tr>
                    <th>CRM</th>
                    <th>Nome</th>
                    <th>Especialidade</th>
                </tr>
                <c:forEach var="medico" items="${requestScope.listaMedicos}">
                    <tr>
                        <td>${medico.CRM}</td>
                        <td>${medico.nome}</td>
                        <td>${medico.especialidade}</td>
                        <td> <a href="/<%=contextPath%>/consulta/cadastro?CRM=${medico.CRM}">
                            Agendar Consulta</a></td>
                    </tr>

                </c:forEach>
            </table>

            <tr>
                <td> <a href="/<%=contextPath%>/paciente">Hub Paciente</a> </td>
            </tr>
        </div>
    </body>
</html>
</html>