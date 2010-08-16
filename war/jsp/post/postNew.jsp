<%@ include file="../includes.jsp" %>
<%@ include file="../header.jsp" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<h1>Add news</h1>

	<c:if test="${not empty param.title}">
		<h2>Post has been added</h2>
		<p>Add new post?</p>
	</c:if>

	<form id="add_post_form" method="post">

		Title<br />
		<input name="title"/><br /><br />

		
		Content<br />
		<textarea class="tinymce" id="elm1" rows="15" cols="60" name="content">
		</textarea>
		<br />
		
	</form>

<%@ include file="../footer.jsp" %>