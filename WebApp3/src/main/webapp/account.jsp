<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Shop</title>
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
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="mynavbar">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${contextPath}/eshop?command=category-redirect">Category</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"
                           href="${contextPath}/eshop?command=redirect-to-shopping-cart">Cart</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${contextPath}/eshop?command=sign-in">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container mt-3">
    <c:if test="${not empty user}">
        <div class="container">
            <h2>User info</h2>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Birthday</th>
                    <th>Email</th>
                    <th>Phone number</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${user.getName()}</td>
                    <td>${user.getSurname()}</td>
                    <td>${user.getBirthday()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getPhoneNumber()}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </c:if>
</div>
<div id="list-product" class="container-fluid mt-3">
    <div class="container">
        <h1>Redeemed products</h1>
        <table class="table">
            <tr>
                <th><h3>Photo</h3></th>
                <th><h3>Brand</h3></th>
                <th><h3>Model</h3></th>
                <th><h3>Price</h3></th>
                <th><h3>Quantity</h3></th>
                <th><h3></h3></th>
            </tr>
            <c:if test="${not empty user_shopping_cart}">
                <c:forEach items="${user_shopping_cart}" var="product">
                    <tr>
                        <td>
                            <img class="card-img" style="width:150px;height:120px"
                                 src="${contextPath}/images/products/${product.getImageName()}"
                                 alt="Card image">
                        </td>
                        <td style="font-style: italic">
                            <strong>${product.getBrand()}</strong>
                        </td>
                        <td style="font-style: italic">
                            <strong>${product.getModel()}</strong>
                        </td>
                        <td style="font-style: italic">
                            <strong>${product.getPrice()}$</strong>
                        </td>
                        <td>
                            <strong>${product.getQuantity()}</strong>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty user_shopping_cart}">
                <tr>
                    <td>
                        <p>Список пуст</p>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <h3><strong>Total price: ${total_price}$</strong></h3>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
