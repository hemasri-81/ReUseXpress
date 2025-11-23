<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><head><title>ReUseXpress</title></head><body>
  <h1>ReUseXpress</h1>
  <a href="${pageContext.request.contextPath}/product/list">All Products</a> |
  <a href="${pageContext.request.contextPath}/product/add">Sell an item</a> |
  <a href="${pageContext.request.contextPath}/auth/login">Login</a> |
  <a href="${pageContext.request.contextPath}/auth/register">Register</a>
  <h2>Newest Items</h2>
  <c:forEach var="p" items="${products}">
    <div style="border:1px solid #ccc; padding:10px; margin:10px;">
      <h3><a href="${pageContext.request.contextPath}/product/details/${p.id}">${p.title}</a></h3>
      <p>₹ ${p.price}</p>
      <c:if test="${not empty p.imagePath}">
        <img src="${pageContext.request.contextPath}/${p.imagePath}" width="150" />
      </c:if>
      <p>${p.description}</p>
    </div>
  </c:forEach>
</body></html>
