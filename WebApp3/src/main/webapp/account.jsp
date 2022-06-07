<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
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
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop"
                           data-toggle="dropdown">
                            Category
                        </a>
                        <div class="dropdown-menu">
                            <c:if test="${not empty category}">
                                <c:forEach items="${category}" var="category">
                                    <a class="dropdown-item"
                                       href="${contextPath}/eshop?command=devices-redirect&category_id=${category.getId()}">${category.getName()}
                                        <img class="card-img" style="width:150px;height:120px"
                                             src="${contextPath}/images/category-img/${category.getImageName()}"
                                             alt="Card image">
                                    </a>
                                </c:forEach>
                            </c:if>
                        </div>
                    </li>
                </ul>
                <form class="d-flex">
                    <input type="hidden" name="command" value="search-product">
                    <input class="form-control me-2" type="text" name="search" placeholder="Search">
                    <button class="btn btn-primary" type="submit">Search</button>
                </form>
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
                <th><h3>Date of order</h3></th>
                <th><h3>Price of order</h3></th>
                <th><h3>Code of product in the shop</h3></th>
                <th><h3>Quantity</h3></th>
                <th><h3></h3></th>
            </tr>
            <c:if test="${not empty order_story}">
                <c:forEach items="${order_story}" var="order">
                    <tr>
                        <td style="font-style: italic">
                            <strong>
                                <fmt:formatDate type="date" value="${order.getOrderDate()}"/>
                            </strong>
                        </td>
                        <td style="font-style: italic">
                            <strong>${order.getOrderPrice()}$</strong>
                        </td>
                        <td style="font-style: italic">
                            <strong>${order.getProductID()}</strong>
                        </td>
                        <td>
                            <strong>${order.getProductQuantity()}</strong>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty order_story}">
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
