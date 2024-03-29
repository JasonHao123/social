<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" pageEncoding="UTF-8" %>

<form id="signin" action="<c:url value="/signin/authenticate" />" method="post">
	<div class="formInfo">
  		<c:if test="${param.error eq 'bad_credentials'}">
  		<div class="error">
  			Your sign in information was incorrect.
  			Please try again or <a href="<c:url value="/signup" />">sign up</a>.
  		</div>
 	 	</c:if>
  		<c:if test="${param.error eq 'multiple_users'}">
  		<div class="error">
  			Multiple local accounts are connected to the provider account.
  			Try again with a different provider or with your username and password.
  		</div>
 	 	</c:if>
	</div>
	<fieldset>
		<label for="login">Username</label>
		<input id="login" name="j_username" type="text" size="25" <c:if test="${not empty signinErrorMessage}">value="${SPRING_SECURITY_LAST_USERNAME}"</c:if> />
		<label for="password">Password</label>
		<input id="password" name="j_password" type="password" size="25" />	
	</fieldset>
	<div class="ui-field-contain">
    <fieldset data-role="controlgroup" data-type="horizontal">
        <button class="ui-shadow ui-btn ui-corner-all ui-icon-home ui-btn-icon-right" type="submit">登录</button>
        <a href="<c:url value="/spring/signup"/>" class="ui-shadow ui-btn ui-corner-all ui-icon-grid ui-btn-icon-right">注册</a>
    </fieldset>
</div>

</form>
<div class="ui-field-contain">
          <a href="<c:url value="/signup"/>" class="ui-shadow ui-btn ui-corner-all ui-icon-grid ui-btn-icon-right">社交平台登录</a>
</div>
