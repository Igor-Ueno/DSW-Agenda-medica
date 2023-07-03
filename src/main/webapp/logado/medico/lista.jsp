<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
    <fmt:bundle basename="message">
        <head>
            <title><fmt:message key="CRUD.title_doc"/></title>
        </head>
        <body>
            <%
            String contextPath = request.getContextPath().replace("/", "");
            %>
            <div align="center">
                <h1><fmt:message key="CRUD.label_doc"/></h1>
                <h2>
                    <a href="/<%=contextPath%>"><fmt:message key="CRUD.menu"/></a> &nbsp;&nbsp;&nbsp; 
                    <a href="/<%=contextPath%>/medico/cadastro"><fmt:message key="CRUD.add_doc"/></a>
                </h2>
            </div>
            <div align="center">
                <table border="1">
                    <caption><fmt:message key="CRUD.list_doc"/></caption>
                    <tr>
                        <th><fmt:message key="user.CRM"/></th>
                        <th><fmt:message key="user.login"/></th>
                        <th><fmt:message key="user.password"/></th>
                        <th><fmt:message key="user.name"/></th>
                        <th><fmt:message key="user.specialty"/></th>
                    </tr>
                    <c:forEach var="medico" items="${requestScope.listaMedicos}">
                        <tr>
                            <td>${medico.CRM}</td>
                            <td>${medico.login}</td>
                            <td>${medico.senha}</td>
                            <td>${medico.nome}</td>
                            <td>${medico.especialidade}</td>
                            <td><a href="/<%=contextPath%>/medico/edicao?CRM=${medico.CRM}">
                                <fmt:message key="form.edition"/></a>
                                &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="/<%=contextPath%>/medico/remocao?CRM=${medico.CRM}"
                                onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                                <fmt:message key="form.removal"/></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </body>
    </fmt:bundle>
</html>