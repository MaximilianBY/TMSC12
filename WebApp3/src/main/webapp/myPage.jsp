<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <style>
      .fakeimg {
        width: 100px;
        height: 200px;
        background: #aaa;
      }
    </style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Welcome to my personal web page</h1>
</div>

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

<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-4">
            <h5>Photo of me:</h5>
            <div class="fakeimg"><img src="images/users/Me.jpg"></div>
            <p>This photo was made on Sicily</p>
        </div>
        <div class="col-sm-8">
            <h2>Information about me</h2>
            <p><h5>Today: <fmt:formatDate type="date" dateStyle="long"
                                          value="${actualDate}"/></h5></p>
            <p>My name is: ${fullName}</p>
            <p>I'm: ${age} years old</p>
            <p>My nationality is ${nationality}</p>
            <p>${aboutMe}</p>
            <br>
        </div>
    </div>
</div>
</body>
</html>
