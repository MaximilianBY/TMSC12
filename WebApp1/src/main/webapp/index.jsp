<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="calc">
    <input name="num1" type="text" placeholder="Введите число"/>
    <select name="operator">
        <option value="+"> +</option>
        <option value="-"> -</option>
        <option value="*"> *</option>
        <option value="/"> /</option>
    </select>
    <input name="num2" type="text" placeholder="Введите число"/>
    <button type="submit"> Посчитать</button>
</form>
</body>
</html>