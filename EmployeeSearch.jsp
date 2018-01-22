<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome to the Employee Database. Enter the employee id to search for an employee
      <form action= "/EmployeeSearchServlet" method="post">
		Employee Id: <input type="text" name="empId"><br> 
		<input type="submit" value="submit">
		</form>
		${employee}
</body>
</html>