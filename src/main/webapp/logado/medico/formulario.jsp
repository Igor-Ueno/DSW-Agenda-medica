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
			<div align="center">
				<h1><fmt:message key="CRUD.label_doc"/></h1>
				<h2>
					<a href="lista"><fmt:message key="CRUD.list_doc"/></a>
				</h2>
			</div>
			<div align="center">
				<c:choose>
					<c:when test="${medico != null}">
						<form action="atualizacao" method="post">
							<%@include file="campos.jsp"%>
						</form>
					</c:when>
					<c:otherwise>
						<form action="insercao" method="post">
							<%@include file="campos.jsp"%>
						</form>
					</c:otherwise>
				</c:choose>
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