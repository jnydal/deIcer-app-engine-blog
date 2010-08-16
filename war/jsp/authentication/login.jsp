<%@ include file="../includes.jsp" %>
<%@ include file="../header.jsp" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">

var AuthenticationChallenge = "${sessionScope.challenge}";

</script>

	<h1>Login</h1>

	<form:form id="login_form" method="post">
	
			<b>Admin </b><br/><form:input path="username" /><form:errors path="username" cssClass="error"/><br />
				
			<b>Password </b><br/><form:password path="password" /><form:errors path="password" cssClass="error"/><br /><br />
		
			<input onclick="Deicer.insertHashedPassword('login_form',true);" value="Login" type="submit" class="button" />
		
	</form:form>

	<br /><br /><br /><br /><br /><br />
	
	<c:if test="${(param.loginFailed == 1)}"><p>Login failed, have you <a href="/reset_password.html">forgotten your password?</a></p></c:if>	

<%@ include file="../footer.jsp" %>