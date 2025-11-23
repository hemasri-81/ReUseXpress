<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<h2>Login</h2>
<c:if test="${not empty error}"><div style="color:red">${error}</div></c:if>
<form action="${pageContext.request.contextPath}/auth/login" method="post">
  Username: <input name="username"/><br/>
  Password: <input name="password" type="password"/><br/>
  <button type="submit">Login</button>
</form>
</body></html>
