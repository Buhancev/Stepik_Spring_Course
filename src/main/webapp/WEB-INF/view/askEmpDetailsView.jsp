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
        <form:errors path="name"/> <!-- ошибка относящаяся к валидации поля name нашего employee-->
        <br>
        <br>
        Surname <form:input path="surname"/>
        <form:errors path="surname"/> <!-- ошибка относящаяся к валидации поля name нашего surname-->
        <br>
        <br>
        Salary <form:input path="salary"/>
        <br>
        <br>
        <!-- хард кодед вариант -->
        Department <form:select path="department">
            <form:option value="Information Technology" lavel = "IT"/>
            <form:option value="Human Resources" lavel = "HR"/>
            <form:option value="Sales" lavel = "Sales"/>
        </form:select>
        <br>
        Which car do you want?
        <!-- не хард кодед вариант-->
        <form:radiobuttons path="carBrand" items = "${employee.carBrands}"></form:radiobuttons>
        <br>
        EN <form:checkbox path="languages" value="English"/>
        RU <form:checkbox path="languages" value="Russian"/>
        UA <form:checkbox path="languages" value="Ukrainian"/>

        <br>
        <input type="submit" value="OK">

    </form:form>


</head>
<body>

</body>
</html>
