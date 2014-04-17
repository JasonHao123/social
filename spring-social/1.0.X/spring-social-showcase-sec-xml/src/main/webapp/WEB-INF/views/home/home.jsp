<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<div id="status" style="display:none">succeed</div>
<p>Welcome, <c:out value="${account.firstName}"/>!</p>

<a href="<c:url value="/signout" />">Sign Out</a>


