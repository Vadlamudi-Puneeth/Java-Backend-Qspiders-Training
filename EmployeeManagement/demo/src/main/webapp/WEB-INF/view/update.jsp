<form action="/updateEmployee" method="post">

<input type="hidden"
       name="email"
       value="${employee.email}" />

Name:
<input type="text" name="name"
       value="${employee.name}" />

Salary:
<input type="number" name="salary"
       value="${employee.salary}" />

Role:
<input type="text" name="role"
       value="${employee.role}" />

Password:
<input type="text" name="password"
       value="${employee.password}" />

<button type="submit">Update</button>

</form>