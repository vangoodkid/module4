<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Cập nhật sản phẩm</title>
  <meta charset="UTF-8"/>
</head>
<body>
<h2>Cập nhật sản phẩm</h2>

<form th:action="@{/products/update/{id}(id=${product.id})}" th:object="${product}" method="post">
  <p>Tên: <input type="text" th:field="*{name}"/></p>
  <p>Giá: <input type="number" step="0.01" th:field="*{price}"/></p>
  <p>Mô tả: <input type="text" th:field="*{description}"/></p>
  <p>Nhà sản xuất: <input type="text" th:field="*{manufacturer}"/></p>
  <button type="submit">✔ Cập nhật</button>
</form>

<a th:href="@{/products}">⬅ Quay lại</a>
</body>
</html>
