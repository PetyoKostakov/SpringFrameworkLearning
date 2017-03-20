<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Attendee Page</title>
	<style>
		.error {
			color: #ff0000
		}
		
		.errorblock {
			color: #000;
			background-color: #ffEEEE
			border: 1px solid #ff0000
			padding: 8px;
			margin: 16px; 
		}
	</style>
</head>
<body>
	<a href="?language=en">English</a>
	<a href="?language=es">Spanish</a>
	
	
	<form:form commandName="attendee">
		<form:errors path="*" cssClass="errorblock" element="div"/>
		<label for="textInput1"><spring:message code="attendee.name"/></label>
		<form:input path="name" cssClass="error"/>
		<form:errors path="name" cssClass="error"/>
		<label for="textInput2"><spring:message code="attendee.emailAddress"/></label>
		<form:input path="emailAddress" cssClass="error"/>
		<form:errors path="emailAddress" cssClass="error"/>
		<br>
		<input type="submit" class="btn" value="Enter Event"/>
	</form:form>
</body>
</html>