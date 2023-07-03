<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<fmt:bundle basename="message">
		<head>
			<title><fmt:message key="appointment.title"/></title>
			<script type="text/javascript" src="https://code.jquery.com/jquery-1.7.2.min.js"></script>
		</head>
		<body>
			<div align="center">
				<h1><fmt:message key="appointment.label"/></h1>
				<h2>
					<a href="lista"><fmt:message key="appointment.add_app"/></a>
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
	</fmt:bundle>
</html>