<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page isELIgnored="false"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Consultório</title>
    <link
      href="${pageContext.request.contextPath}/styles.css"
      rel="stylesheet"
      type="text/css"
    />
  </head>

  <body>
    <div align="center">
      <h1>Digite seu CPF</h1>
    </div>
    <div align="center">
      <form action="consultas" method="post">
        <%@include file="campos_consultas.jsp"%>
      </form>
    </div>
    <c:if test="${!empty requestScope.mensagens}">
      <ul class="erro">
        <c:forEach items="${requestScope.mensagens}" var="mensagem">
          <li>${mensagem}</li>
        </c:forEach>
      </ul>
    </c:if>
  </body>
</html>
