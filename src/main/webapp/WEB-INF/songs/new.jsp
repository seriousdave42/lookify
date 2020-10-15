<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add a New Song</h2>
	<br>
	<form:form action="/songs" method="post" modelAttribute="song">
		<p>
			<form:label path="title">Title</form:label>
			<form:errors path="title"/>
			<form:input path="title"/>
		</p>
		<p>
			<form:label path="artist">Artist</form:label>
			<form:errors path="artist"/>
			<form:input path="artist"/>
		</p>
		<p>
			<form:label path="rating">Rating</form:label>
			<form:errors path="rating"/>
			<form:input type="number" path="rating"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>

</body>
</html>