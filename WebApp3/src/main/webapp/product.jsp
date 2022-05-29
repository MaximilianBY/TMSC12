<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
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
            <a class="navbar-brand" href="${contextPath}/eshop?command=user-account">My account</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
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

    <div class="container-fluid mt-3">
        <div class="container">
            <div class="container mt-3">
                <c:if test="${not empty product}">
                    <!-- Media top -->
                    <div class="media">
                        <img img class="card-img" style="width:150px;height:120px"
                             src="${contextPath}/images/products/${product.getImageName()}"
                             alt="Card image">
                        <div class="media-body">
                            <h4>${product.getBrand()} ${product.getModel()}</h4>
                            <p>${product.getDescription()}</p>
                            <p>${product.getPrice()}$</p>
                            <p>Available for purchase: ${product.getQuantity()}</p>
                            <a href="${contextPath}/eshop?command=add-product-to-cart&product_id=${product.getId()}">
                                <button class="btn btn-primary" type="submit"
                                        onclick="productAddedToShoppingCartMsg()">Buy
                                </button>
                            </a>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<script>
  function productAddedToShoppingCartMsg() {
    window.confirm("Product added to cart!");
  }
</script>
</body>
</html>
