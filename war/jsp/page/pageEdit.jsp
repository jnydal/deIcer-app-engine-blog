<%@ include file="../includes.jsp" %>
<%@ include file="../header.jsp" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<h1>Edit page</h1>

	<form:form id="edit_page_form" method="post">

		Title <form:errors path="title" cssClass="error"/><br />
		<form:input path="title"/><br /><br />

		
		Content <form:errors path="content" cssClass="error" /><br />
		<form:textarea cssClass="tinymce page" id="elm1" rows="15" cols="60" path="content"/>
		<br />
		
	</form:form>

<%@ include file="../footer.jsp" %>