<%@ include file="../includes.jsp" %>
<%@ include file="../header.jsp" %>

	<h1>Admin list</h1>

	<c:forEach items="${adminList}" var="user">
		<b>${user.id.name}</b><br />
		<i>${user.contactInfo.firstname} ${user.contactInfo.lastname}</i><br /><br />
	</c:forEach>
	
<%@ include file="../footer.jsp" %>