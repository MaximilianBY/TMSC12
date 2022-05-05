<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Devices</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="myPage">My account</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="mynavbar">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="categories">Category</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="cart">Cart</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="signin">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div id="list-product" class="container-fluid mt-3">
        <form method="post" action="devices" accept-charset="UTF-8">
            <div class="container">
                <h1>List devices</h1>
                <table class="table">
                    <tr>
                        <th><h3>Foto</h3></th>
                        <th><h3>Brand</h3></th>
                        <th><h3>Model</h3></th>
                        <th><h3>Price</h3></th>
                        <th><h3>Available</h3></th>
                        <th><h3></h3></th>
                    </tr>
                    <c:if test="${not empty products}">
                        <c:forEach items="${products}" var="product">
                            <tr>
                                <td><a href="${contextPath}/product?id=${product.getId()}"><img
                                        class="card-img" style="width:150px;height:120px"
                                        src="${contextPath}/images/products/${product.getImageName()}"
                                        alt="Card image">
                                </a>
                                </td>
                                <td style="font-style: italic"><a
                                        href="${contextPath}/product?id=${product.getId()}">
                                    <strong>${product.getBrand()}</strong>
                                </a>
                                </td>
                                <td style="font-style: italic"><a
                                        href="${contextPath}/product?id=${product.getId()}">
                                    <strong>${product.getModel()}</strong>
                                </a>
                                </td>
                                <td style="font-style: italic"><a
                                        href="${contextPath}/product?id=${product.getId()}">
                                    <strong>${product.getPrice()}$</strong>
                                </a>
                                </td>
                                <td style="font-style: italic"><a
                                        href="${contextPath}/product?id=${product.getId()}">
                                    <strong>${product.getQuantity()}</strong>
                                </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty products}">
                        <tr>
                            <td>
                                <p>Список пуст</p>
                            </td>
                        </tr>
                    </c:if>
                </table>
            </div>
        </form>
    </div>
</div>
</body>
</html>