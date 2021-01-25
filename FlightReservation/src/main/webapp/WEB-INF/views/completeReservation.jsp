<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>
<h2><center>Complete Reservation</center></h2>

Airlines: ${flight.operatingAirlines}<br/>
Departure City: ${flight.departureCity}<br/>
Arrival City: ${flight.arrivalCity}<br/>

<form action="completeReservation" method="post">
<pre>
<h2>Passenger Details</h2>

First Name : <input type="text" name="passengerFirstName"/><br>
Last Name : <input type="text" name="passengerLastName"/><br>
<!-- Middle Name : <input type="text" name="passengerMiddleName"/><br> -->
Email : <input type="text" name="passengerEmail"/><br>
Phone : <input type="text" name="passengerPhone"/><br>

<h2>Card Details</h2>

Name on the card: <input type="text" name="nameOnTheCard"/><br>
Card Number: <input type="text" name="cardNumber"/><br>
Expire Date: <input type="text" name="expireDate"/><br>
CVV: <input type="text" name="secCode"/><br>

<input type="hidden" name="flightId" value="${flight.id}"/>
<input type="submit" value="Confirm"/>
</pre>
</form>

</body>
</html>