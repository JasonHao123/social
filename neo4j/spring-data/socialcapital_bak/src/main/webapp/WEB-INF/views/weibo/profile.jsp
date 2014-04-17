<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>

<h3>Your LinkedIn Profile</h3>

<p>Hello, <c:out value="${profile.screenName}"/>!</p>
<img src="<c:out value="${profile.profileImageUrl}"/>"/>
<dl>
	<dt>LinkedIn ID:</dt>
	<dd><a href="<c:out value="${profile.id}"/>" target="_blank"><c:out value="${profile.idstr}"/></a></dd>
	<dt>Headline:</dt>
	<dd><c:out value="${profile.description}"/></dd>
	
</dl>

<c:url value="/connect/weibo" var="disconnectUrl"/>
<form id="disconnect" action="${disconnectUrl}" method="post">
	<button type="submit">Disconnect from LinkedIn</button>	
	<input type="hidden" name="_method" value="delete" />
</form>
