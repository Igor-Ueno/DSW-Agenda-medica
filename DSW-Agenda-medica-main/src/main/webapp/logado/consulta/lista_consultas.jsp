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
            <h1>Lista de Consultas</h1>
        </div>

        <div align="center">
            <table border="1">
                <caption>Consultas</caption>
                <tr>
                    <th>CPF</th>
                    <th>CRM</th>
                    <th>Data</th>
                    <th>horário</th>
                </tr>
                <c:forEach var="consulta" items="${requestScope.listaConsultas}">
                    <tr>
                        <td>${consulta.CPFpaciente}</td>
                        <td>${consulta.CRMmedico}</td>
                        <td>${consulta.getStringData_Consulta()}</td>
                        <td>${consulta.hora}</td>
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