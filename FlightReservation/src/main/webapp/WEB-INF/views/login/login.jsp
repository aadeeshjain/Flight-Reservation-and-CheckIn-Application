<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
<h2><center>Login:</center></h2>
<form action="login" method="post">
<pre>
UserName: <input type="text" name="email"/><br>
Password: <input type="password" name="password"/><br>
<input type="submit" value="Login"/>
</pre>
</form>
	${msg}

</body>
</html>