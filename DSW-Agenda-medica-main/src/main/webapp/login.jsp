<%@ page contentType="text/html" pageEncoding="UTF-8"%> <%@ page
isELIgnored="false"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Autenticação de Usuário</title>
    <link
      href="${pageContext.request.contextPath}/layout.css"
      rel="stylesheet"
      type="text/css"
    />
  </head>
  <body>
    <div align="center">
      <h1>Autenticação de Usuário</h1>
    </div>

    <c:if test="${mensagens.existeErros}">
      <div id="erro">
        <ul>
          <c:forEach var="erro" items="${mensagens.erros}">
            <li>${erro}</li>
          </c:forEach>
        </ul>
      </div>
    </c:if>

    <div align="center">
      <form method="post" action="index.jsp">
        <table>
          <tr>
            <th>E-mail:</th>
            <td><input type="text" name="login" value="${param.login}" /></td>
          </tr>
          <tr>
            <th>Senha:</th>
            <td><input type="password" name="senha" /></td>
          </tr>
          <tr>
            <div align="center">
              <td colspan="2">
                <input type="submit" name="bOK" value="Entrar" />
              </td>
            </div>
          </tr>
        </table>
      </form>
    </div>

    <div align="center">
      <h2>
        <%--
        <a href="/<%=contextPath%>/">Lista de médicos</a> &nbsp;&nbsp;&nbsp;
        <a href="/<%=contextPath%>/">Lista de médicos por especialidade</a>
        --%>
      </h2>
    </div>
  </body>
</html>
