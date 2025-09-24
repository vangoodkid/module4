<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
  <title>Danh sách sản phẩm</title>
  <meta charset="UTF-8"/>
</head>
<body>
<h2>Danh sách sản phẩm</h2>

<form th:action="@{/products/search}" method="get">
  <input type="text" name="name" placeholder="Tìm theo tên"/>
  <button type="submit">Tìm kiếm</button>
</form>

<a th:href="@{/products/create}">➕ Thêm sản phẩm mới</a>

<table border="1" cellpadding="5" cellspacing="0">
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Giá</th>
    <th>Nhà sản xuất</th>
    <th>Hành động</th>
  </tr>
  <tr th:each="product : ${products}">
    <td th:text="${product.id}"></td>
    <td th:text="${product.name}"></td>
    <td th:text="${product.price}"></td>
    <td th:text="${product.manufacturer}"></td>
    <td>
      <a th:href="@{'/products/' + ${product.id}}">👁 Xem</a> |
      <a th:href="@{'/products/edit/' + ${product.id}}">✏ Sửa</a> |
      <a th:href="@{'/products/delete/' + ${product.id}}"
         onclick="return confirm('Bạn có chắc muốn xoá?')">🗑 Xoá</a>
    </td>
  </tr>
</table>

</body>
</html>