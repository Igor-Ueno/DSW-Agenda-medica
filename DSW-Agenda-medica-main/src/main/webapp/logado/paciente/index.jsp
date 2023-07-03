<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
        <title>Página Paciente</title>
    </head>
    <body>
        <%
            String contextPath = request.getContextPath().replace("/", "");
        %>
        
        <div align="center">
            <h1>Menu paciente</h1>
        </div>

        <div align="center">
            <p>Olá ${sessionScope.usuarioLogado.nome}!</p>
        </div>

        <div align="center">
            <h2>
                <a href="/<%=contextPath%>/consulta/">Agendar Consulta</a> &nbsp;&nbsp;&nbsp;
                <a href="<%=request.getContextPath()%>/consulta/listaConsultas">Lista de Consultas</a>&nbsp;&nbsp;&nbsp;
            </h2>
        </div>
    </body>
</html>

