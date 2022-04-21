<%@ page import="by.tms.model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mobile Phones</title>
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
                    <a class="nav-link" href="Devices">Devices</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link">Basket</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="signin">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid mt-3">
    <form method="post" action="mobPhones" accept-charset="UTF-8">
        <div class="container">
            <h1>List phones</h1>
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
                        <tr class="inner">
                            <td><img class="card-img" style="width:150px;height:120px"
                                     src="${contextPath}/images/${product.getImageName()}"
                                     alt="Card image">
                            </td>
                            <td style="font-style: italic"><strong>${product.getBrand()}</strong>
                            </td>
                            <td style="font-style: italic"><strong>${product.getModel()}</strong>
                            </td>
                            <td style="font-style: italic"><strong>${product.getPrice()}$</strong>
                            </td>
                            <td style="font-style: italic"><strong>${product.getQuantity()}</strong>
                            </td>
                            <td><a class="btn btn-primary"
                                   data-product-id="${product.getId()}">Buy</a></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
        </div>
    </form>
</div>
</body>
</html>