<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>

<h3>Your LinkedIn Profile</h3>
<div style="width: 100%">
<a href="import?cursor=<c:out value="${previous-50}" />">Previous</a>
<a href="import?cursor=<c:out value="${next}" />">Next</a>

Total hits: ${total}
</div>

<br>
<sf:form commandName="form">
<ul>
<c:forEach items="${friends}" var="friend">
	<li><a href="${friend.url}"><img src="<c:out value="${friend.profileImageUrl}" />" />${friend.screenName}
	</a>
	<sf:checkbox value="${friend.id};${friend.screenName};${friend.url};${friend.profileImageUrl}" path="friends"/></li>
</c:forEach>
</ul>
<sf:button name="test">Submit</sf:button>
</sf:form>