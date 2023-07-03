<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <fmt:bundle basename="message">
        <head>
            <title><fmt:message key="appointment.title"/></title>
        </head>
        <body>
            <%
            String contextPath = request.getContextPath().replace("/", "");
            %>
            <div align="center">
                <h1><fmt:message key="appointment.label"/></h1>
                <h2>
                    <a href="/<%=contextPath%>/"><fmt:message key="appointment.menu"/></a> &nbsp;&nbsp;&nbsp;
                    <c:if test="${CPFpaciente != null}">
                        <a href="/<%=contextPath%>/consulta/cadastro"><fmt:message key="appointment.add_app"/></a>
                    </c:if>
                </h2>
            </div>
            <div align="center">
                <table border="1">
                    <caption><fmt:message key="appointment.title"/></caption>
                    <tr>
                        <th><fmt:message key="user.CPF"/></th>
                        <th><fmt:message key="user.CRM"/></th>
                        <th><fmt:message key="appointment.date"/></th>
                        <th><fmt:message key="appointment.time"/></th>
                    </tr>
                    <c:forEach var="consulta" items="${requestScope.listaConsultas}">
                    <tr>
                        <td>${consulta.CPFpaciente}</td>
                        <td>${consulta.CRMmedico}</td>
                        <td>${consulta.getStringData_Consulta()}</td>
                        <td>${consulta.hora}</td>
                        <c:if test="${CPFpaciente != null}">
                            <td><a href="/<%=contextPath%>/consulta/remocao?CPFpaciente=${consulta.CPFpaciente}&CRMmedico=${consulta.getCRMAlt()}&data_consulta=${consulta.getStringData_Consulta()}&hora=${consulta.hora}"
                                onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                                <fmt:message key="form.removal"/></a></td>
                        </c:if>                    
                    </tr>
                </c:forEach>
                </table>
            </div>
        </body>
    </fmt:bundle>
</html>