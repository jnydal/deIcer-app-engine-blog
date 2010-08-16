<%@ include file="../includes.jsp" %>
<%@ include file="../header.jsp" %>

	<c:choose>
	<c:when test="${not empty param.email}">
	
		<h2>E-mail has been sent</h2>
	
		<p>An e-mail with a reset password link has been sent to <i>${param.email}</i></p>
   	
	</c:when>
	<c:otherwise>
	
		<h2>Reset your admin password</h2>
	
		<form method="post">
		
			E-mail: <input name="email" type="text"/>
			<button>Send reset link</button>
		
		</form>
	
	</c:otherwise>
	</c:choose>

<%@ include file="../footer.jsp" %>
