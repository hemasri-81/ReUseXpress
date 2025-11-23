<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<h2>Register</h2>
<c:if test="${not empty error}"><div style="color:red">${error}</div></c:if>
<form action="${pageContext.request.contextPath}/auth/register" method="post">
  Username: <input name="username"/><br/>
  Email: <input name="email"/><br/>
  Password: <input name="password" type="password"/><br/>
  <button type="submit">Register</button>
</form>
</body></html>
