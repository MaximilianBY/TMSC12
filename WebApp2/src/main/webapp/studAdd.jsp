<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new student</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<form method="post" action="studAdd">
    <div class="container mt-3">
        <h3>Input student data</h3>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Student</span>
            </div>
            <input type="text" class="form-control" placeholder="First Name" name="firstName">
            <input type="text" class="form-control" placeholder="Last Name" name="lastName">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">City From</span>
            </div>
            <input type="text" class="form-control" placeholder="City From" name="cityFrom">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">City Study</span>
            </div>
            <input type="text" class="form-control" placeholder="City Study" name="cityStudy">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Course</span>
            </div>
            <input type="text" class="form-control" placeholder="Course" name="course">
        </div>
        <button type="submit" class="btn btn-primary btn-md" formaction="studentsDB.html">Previews
            page
        </button>
        <button type="submit" class="btn btn-primary btn-md">Submit</button>
    </div>
</form>
</body>
</html>
