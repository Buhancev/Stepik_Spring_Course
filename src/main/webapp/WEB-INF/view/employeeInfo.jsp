<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2> Employee Info</h2>
<br>
<form:form action="saveEmployee" modelAttribute="employee">

  <!-- Скрытая форма, которая не отображается, но при updateInfo поле id будет не пустым, так как мы передаем из БД
  существующий Employee, который имеет id. -->
  <form:hidden path="id"/>

  Name <form:input path="name"/>
  <br><br>

  Surname <form:input path="surname"/>
  <br><br>

  Department <form:input path="department"/>
  <br><br>

  Salary <form:input path="salary"/>
  <br><br>

  <input type="submit" value="Ok">

</form:form>
</body>

</html>
