<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<h2>Products</h2>
<form action="${pageContext.request.contextPath}/product/search" method="get">
  <input name="q" placeholder="Search..."/>
  <button type="submit">Search</button>
</form>
<a href="${pageContext.request.contextPath}/">Home</a>
<c:forEach var="p" items="${products}">
  <div style="border:1px solid #ddd;padding:8px;margin:8px;">
    <h3><a href="${pageContext.request.contextPath}/product/details/${p.id}">${p.title}</a></h3>
    <p>₹ ${p.price}</p>
  </div>
</c:forEach>
</body></html>
