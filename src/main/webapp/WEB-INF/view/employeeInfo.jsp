<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2> Employee Info</h2>
<br>
<form:form action="saveNewEmployee" modelAttribute="newEmployee">

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
