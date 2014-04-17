<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Sign In</title>
	</head>
	<body>
		<form action="<c:url value="/signin/weibo" />" method="POST">
		    <button type="submit">Sign in with Facebook</button>
		    <input type="hidden" name="scope" value="email,friendships_groups_read" />		    
		</form>
	</body>
</html>
