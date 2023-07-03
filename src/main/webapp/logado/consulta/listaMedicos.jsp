<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
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
                <h1>Agendamento</h1>
            </div>
    
            <div align="center">
                <table border="1">
                    <caption><fmt:message key="user.doctor"/></caption>
                    <tr>
                        <th><fmt:message key="user.CRM"/></th>
                        <th><fmt:message key="user.name"/></th>
                        <th><fmt:message key="user.specialty"/></th>
                    </tr>
                    <c:forEach var="medico" items="${requestScope.listaMedicos}">
                        <tr>
                            <td>${medico.CRM}</td>
                            <td>${medico.nome}</td>
                            <td>${medico.especialidade}</td>
                            <td><a href="/<%=contextPath%>/consulta/cadastro?CPF=${CPFpaciente}&CRM=${medico.CRM}">
                                <fmt:message key="appointment.schedule"/></a></td>
                        </tr>    
                    </c:forEach>
                </table>
    
                <tr>
                    <td> <a href="/<%=contextPath%>/consulta/listaCPF"><fmt:message key="appointment.scheduling"/></a></td>
                </tr>
            </div>
        </body>
    </fmt:bundle>
</html>