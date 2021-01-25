<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
<body>
<h2><center><ul>USER REGISTRATION</ul></center></h2>

<form action="registerUser" method="post">
<pre>
First Name: <input type="text" name="firstName"/><br>
Last Name: <input type="text" name="lastName"/><br>
UserName: <input type="text" name="email"/><br>
Password: <input type="password" name="password"/><br>
Confirm Password: <input type="password" name="confirmPassword"/><br>
<input type="submit" value="Register"/>
</pre>
</form>

</body>
</html>