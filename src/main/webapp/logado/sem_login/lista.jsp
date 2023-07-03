<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
    <fmt:bundle basename="message">
        <head>
            <title><fmt:message key="CRUD.list_doc"/></title>
        </head>
        <body>
            <%
            String contextPath = request.getContextPath().replace("/", "");
            %>
            <div align="center">
                <h1><fmt:message key="CRUD.list_doc"/></h1>
            </div>
            <div align="center">
                <form method="post" action="lista_especialidade">
                    <label for="especialidade"><fmt:message key="user.specialty"/>:</label>
                    <select name="especialidade" id="especialidade">
                        <option value="Cardiologista"><fmt:message key="doc.cardiologist"/></option>
                        <option value="Dermatologista"><fmt:message key="doc.dermatologist"/></option>
                        <option value="Ortopedista"><fmt:message key="doc.orthopedist"/></option>
                        <option value="Oftalmologista"><fmt:message key="doc.ophthalmologist"/></option>
                        <option value="Endocrinologista"><fmt:message key="doc.endocrinologist"/></option>
                    </select>        
                    <input type="submit" value="<fmt:message key="form.filter"/>">
                </form>
            </div>
            <div align="center">
                <table border="1">
                    <caption><fmt:message key="CRUD.list_doc"/></caption>
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
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <a href="/<%=contextPath%>/">Voltar</a>
        </body>
    </fmt:bundle>
</html>