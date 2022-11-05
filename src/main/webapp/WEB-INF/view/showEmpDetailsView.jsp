<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Spring MVC</title>
  <h2> Dear Employee, you are welcome ! </h2>
  <br>
  <br>
  <!-- обращаемся к атрибуту по имени-->
  <h2> Your name: ${employee.name}</h2>
  <br>
  <h2> Your surname: ${employee.surname}</h2>
  <br>
  <h2> Your salary: ${employee.salary}</h2>
  <br>
  <h2> Your department: ${employee.department}</h2>
  <br>
  <h2> Your car: ${employee.carBrand}</h2>
</head>
<body>

</body>
</html>
