<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th>id</th><th>name</th><th>attendees</th>
		</tr>
		<c:forEach var="event" items="${events}">
			<tr>
				<td>${event.id}</td>
				<td>${event.name}</td>
				<td>
					<table>
						<tr>
							<th>id</th><th>name</th><th>mail</th><th>phone</th>
						</tr>
						<c:forEach var="attendee" items="${event.attendees}">
							<tr>
								<td>${attendee.id}</td>
								<td>${attendee.name}</td>
								<td>${attendee.emailAddress}</td>
								<td>${attendee.phone}</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>