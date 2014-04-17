<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>


<div class="form ">
<h1><spring:message code="page.label.signup.title" text="Sign Up" /></h1>
<sf:form commandName="webUser">
<input type="hidden" name="mode" value="signup" />
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td alignment="right" width="20%"><spring:message code="page.label.login.username" text="Email" /></td>
      <spring:bind path="webUser.username">
        <td width="20%">
          <input type="text" name="username" value="<c:out value="${status.value}"/>">
        </td>
        <td width="60%">
          <font color="red"><c:out value="${status.errorMessage}"/></font>
        </td>
      </spring:bind>
    </tr>
    <tr>
      <td alignment="right" width="20%"><spring:message code="page.label.login.nickName" text="Nick Name" /></td>
      <spring:bind path="webUser.displayName">
        <td width="20%">
          <input type="text" name="displayName" value="<c:out value="${status.value}"/>">
        </td>
        <td width="60%">
          <font color="red"><c:out value="${status.errorMessage}"/></font>
        </td>
      </spring:bind>
    </tr>
    <tr>
      <td alignment="right" width="20%"><spring:message code="page.label.login.password" text="Password" /></td>
      <spring:bind path="webUser.password">
        <td width="20%">
          <input type="password" name="password" value="<c:out value="${status.value}"/>">
        </td>
        <td width="60%">
          <font color="red"><c:out value="${status.errorMessage}"/></font>
        </td>
      </spring:bind>
    </tr>
    
        <tr>
      <td alignment="right" width="20%"><spring:message code="page.label.signup.password.again" text="Password again" /></td>
      <spring:bind path="webUser.passwordAgain">
        <td width="20%">
          <input type="password" name="passwordAgain" value="<c:out value="${status.value}"/>">
        </td>
        <td width="60%">
          <font color="red"><c:out value="${status.errorMessage}"/></font>
        </td>
      </spring:bind>
    </tr>
   
  </table>
  <br>
  <spring:hasBindErrors name="webUser">
    <b><spring:message code="page.label.fixerror" text="Please fix all errors!" /></b>
  </spring:hasBindErrors>
  <br><br>

  <input name="execute" type="submit" alignment="center" value="<spring:message code="page.label.signup.submit" text="Submit" />">
</sf:form>
</div>

