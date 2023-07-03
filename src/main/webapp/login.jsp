<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <fmt:bundle basename="message">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><fmt:message key="login.title"/></title>
            <link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
        </head>
        <body>
            <div align="center">
                <h1><fmt:message key="login.label"/></h1>
            </div>

            <c:if test="${mensagens.existeErros}">
                <div id="erro">
                    <ul>
                        <c:forEach var="erro" items="${mensagens.erros}">
                            <li> ${erro} </li>
                            </c:forEach>
                    </ul>
                </div>
            </c:if>

            <div align="center">
                <form method="post" action="index.jsp">
                    <table>
                        <tr>
                            <th><fmt:message key="login.email"/>: </th>
                            <td><input type="text" name="login"
                                    value="${param.login}"/></td>
                        </tr>
                        <tr>
                            <th><fmt:message key="login.password"/>: </th>
                            <td><input type="password" name="senha" /></td>
                        </tr>
                        <tr>
                            <td colspan="2"> 
                                <div align="center">
                                    <input type="submit" name="bOK" value="<fmt:message key="login.enter"/>">
                                </div>                                
                            </td>                     
                        </tr>
                    </table>
                </form>
            </div>

            <div align="center">
                <h2>
                    <a href="${pageContext.request.contextPath}/consulta_sem_login/lista"><fmt:message key="CRUD.list_doc"/></a>
                </h2>
            </div>
        </body>
    </fmt:bundle>
</html>