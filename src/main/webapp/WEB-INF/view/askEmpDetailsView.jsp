<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC</title>
    <h2> Dear Employee, Please enter your details </h2>

    <br>
    <br>

    <!-- при нажатии на кнопку, происходит переход на /showDetails-->
    <form action="showDetails" method = "get">
        <!-- тип - текст, имя поля формы - employeeName (будет хранить значение - почти переменная) -->
    <input type="text" name="employeeName"
    placeholder="Write your name"/>
        <input type="submit"/>
    </form>

</head>
<body>

</body>
</html>
