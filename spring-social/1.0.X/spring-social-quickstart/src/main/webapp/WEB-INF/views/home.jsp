<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
	<ul>
		<li><a href="<c:url value="/signout" />">Sign Out</a></li>
	</ul>
	<h3>Your Facebook Friends</h3>
	<ul>
	<p>Previous cursor:${previous  }</p>
	<p>Next cursor:${next  }</p>
	
	<c:forEach items="${friends}" var="friend">
		<li><img src="<c:out value="${friend.profileImageUrl}"/>" align="middle"/><c:out value="${friend.name}"/></li>
	</c:forEach>
	</ul>	
	<a href="page?cursor=${previous}">Previous</a><a href="page?cursor=${next}">Next</a>
	</body>
</html>