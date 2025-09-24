<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Chi tiết sản phẩm</title>
  <meta charset="UTF-8"/>
</head>
<body>
<h2>Chi tiết sản phẩm</h2>

<p><b>ID:</b> <span th:text="${product.id}"></span></p>
<p><b>Tên:</b> <span th:text="${product.name}"></span></p>
<p><b>Giá:</b> <span th:text="${product.price}"></span></p>
<p><b>Mô tả:</b> <span th:text="${product.description}"></span></p>
<p><b>Nhà sản xuất:</b> <span th:text="${product.manufacturer}"></span></p>

<a th:href="@{/products}">⬅ Quay lại</a>
</body>
</html>