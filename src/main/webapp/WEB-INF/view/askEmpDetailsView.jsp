<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC</title>
    <h2> Dear Employee, Please enter your details </h2>

    <br>
    <br>

    <form:form action = "showDetails" modelAttribute="employee">
        Name <form:input path="name"/>
        <br>
        <br>
        Surname <form:input path="surname"/>
        <br>
        <br>
        Salary <form:input path="salary"/>
        <br>
        <br>
        Department <form:select path="department">
            <form:option value="Information Technology" lavel = "IT"/>
            <form:option value="Human Resources" lavel = "HR"/>
            <form:option value="Sales" lavel = "Sales"/>
        </form:select>
        <br>
        <input type="submit" value="OK">

    </form:form>


</head>
<body>

</body>
</html>
