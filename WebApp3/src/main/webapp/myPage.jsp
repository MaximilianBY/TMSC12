<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>My first personal web page</title>
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
<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Welcome to my personal web page</h1>
</div>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <a class="navbar-brand">Navbar</a>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="categories">Category</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="basket">Basket</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-4">
            <h5>Photo of me:</h5>
            <div class="fakeimg"><img src="images/users/Me.jpg"></div>
            <p>This foto was made on Sicily</p>
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
