<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<h2>Add / Edit Product</h2>
<form action="${pageContext.request.contextPath}/product/save" method="post" enctype="multipart/form-data">
  <input type="hidden" name="id" value="${product.id}" />
  Title: <input name="title" value="${product.title}" /><br/>
  Description: <textarea name="description">${product.description}</textarea><br/>
  Price: <input name="price" value="${product.price}" /><br/>
  Image: <input type="file" name="image"/><br/>
  <button type="submit">Save</button>
</form>
</body></html>
