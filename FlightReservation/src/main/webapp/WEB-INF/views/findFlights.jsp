<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Flights</title>
</head>
<body>
<h2><center>Find Flights</center></h2>

<form action="findFlights" method="post">
<pre>
From: <input type="text" name="from"/><br>
To: <input type="text" name="to"/><br>
Departure Date: <input type="text" name="departureDate"/><br>
<input type="submit" value="search"/>
</pre>
</form>
</body>
</html>