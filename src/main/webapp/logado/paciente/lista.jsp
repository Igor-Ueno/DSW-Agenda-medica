<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <fmt:bundle basename="message">
        <head>
            <title><fmt:message key="CRUD.title_pat"/></title>
        </head>
        <body>
            <%
            String contextPath = request.getContextPath().replace("/", "");
            %>
            <div align="center">
                <h1><fmt:message key="CRUD.label_pat"/></h1>
                <h2>
                    <a href="/<%=contextPath%>/"><fmt:message key="CRUD.menu"/></a> &nbsp;&nbsp;&nbsp; 
                    <a href="/<%=contextPath%>/paciente/cadastro"><fmt:message key="CRUD.add_pat"/></a>
                </h2>
            </div>
            <div align="center">
                <table border="1">
                    <caption><fmt:message key="CRUD.list_pat"/></caption>
                    <tr>
                        <th><fmt:message key="user.CPF"/></th>
                        <th><fmt:message key="user.login"/></th>
                        <th><fmt:message key="user.password"/></th>
                        <th><fmt:message key="user.name"/></th>
                        <th><fmt:message key="user.telephone"/></th>
                        <th><fmt:message key="user.sex"/></th>
                        <th><fmt:message key="user.birthday"/></th>
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
                            <fmt:message key="form.edition"/></a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="/<%=contextPath%>/paciente/remocao?CPF=${paciente.CPF}"
                            onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                            <fmt:message key="form.removal"/></a></td>
                    </tr>
                </c:forEach>
                </table>
            </div>
        </body>
    </fmt:bundle>
</html>