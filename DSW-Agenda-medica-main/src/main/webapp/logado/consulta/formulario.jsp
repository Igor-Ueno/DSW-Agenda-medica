<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Consultório</title>
</head>

<body>
	<div align="center">
		<h1>Agendamento de Consulta</h1>
		<h2>
			<a href="lista">Lista de Médicos</a>
		</h2>
	</div>
	<div align="center">
		<form action="insercao" method="post">
			<%@include file="campos.jsp"%>
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