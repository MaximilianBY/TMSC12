<%@ page import="by.tms.student.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Show student DB</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<form method="post" action="showDB" accept-charset="UTF-8">
    <div class="conteiner">
        <h1>List students</h1>
        <table class="table">
            <tr>
                <th>ID</th>
                <th>First name</th>
                <th>Last name</th>
                <th>City from</th>
                <th>City study</th>
                <th>Course</th>
            </tr>
            <%
                ArrayList<Student> std = (ArrayList<Student>) request.getAttribute("students");
                for (Student stud : std) {
            %>
            <tr>
                <td><%=stud.getId()%>
                </td>
                <td><%=stud.getFirstName()%>
                </td>
                <td><%=stud.getLastName()%>
                </td>
                <td><%=stud.getCityFrom()%>
                </td>
                <td><%=stud.getCityStudy()%>
                </td>
                <td><%=stud.getCourse()%>
                </td>
            </tr>
            <%}%>
        </table>
        <button type="submit" class="btn btn-primary btn-md" formaction="studentsDB.html">Previews
            page
        </button>
    </div>
</form>
</body>
</html>