<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<h2>${product.title}</h2>
<p>₹ ${product.price}</p>
<c:if test="${not empty product.imagePath}">
  <img src="${pageContext.request.contextPath}/${product.imagePath}" width="300"/>
</c:if>
<p>${product.description}</p>
<a href="${pageContext.request.contextPath}/product/delete/${product.id}">Delete</a>
<a href="${pageContext.request.contextPath}/product/list">Back</a>
</body></html>
