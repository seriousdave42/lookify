<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify!</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Artist</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${songs}" var="song">
				<tr>
					<td><c:out value="${song.name}"/></td>
					<td><c:out value="${song.artist}"/></td>
					<td><c:out value="${song.rating}"/></td>
					<td>
						<form action="/songs/${song.id}" method=POST>
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Delete">
						</form>
					</td>
				</tr>					
			</c:forEach>
		</tbody>
	</table>

	<a href="/songs/new">Add Song</a>
	<a href="/search/topTen">Top Songs</a>
	<br>
	<form action="/search" method=POST>
		<input type="text" name="search">
		<input type="submit" value="Search">
	</form>
</body>
</html>