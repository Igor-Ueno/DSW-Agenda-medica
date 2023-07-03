<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <fmt:bundle basename="message">
        <head>
            <title><fmt:message key="admin.title"/></title>
        </head>
        <body>
            <%
                String contextPath = request.getContextPath().replace("/", "");
            %>
            
            <div align="center">
                <h1><fmt:message key="admin.label"/></h1>
            </div>

            <div align="center">
                <p><fmt:message key="admin.greeding"/> ${sessionScope.usuarioLogado.nome}!</p>
            </div>

            <div align="center">
                <h2>
                    <a href="/<%=contextPath%>/paciente/"><fmt:message key="admin.pat_CRUD"/></a> &nbsp;&nbsp;&nbsp; 
                    <a href="/<%=contextPath%>/medico/"><fmt:message key="admin.doc_CRUD"/></a> &nbsp;&nbsp;&nbsp; 
                    <a href="${pageContext.request.contextPath}/logout.jsp"><fmt:message key="admin.exit"/></a>
                </h2>
            </div>
        </body>
    </fmt:bundle>
</html>

