<%@ include file="../includes.jsp" %>
<%@ include file="../header.jsp" %>

	<c:if test="${sessionScope.LOGIN_DATA!=null}">
	
	<div id="add_post_dialog">

		<h2>Add post</h2>
	
		<form id="add_post_form" method="post" action="new_post.html">

		Title<br />
		<input type="text" name="title"/><br /><br />
		
		Content<br />
		<textarea class="tinymce post" id="elm1" rows="15" cols="60" name="content">
		</textarea>
		<br />
		
		</form>
		
	</div>
	
	<br />
	<a class="insert_link" id="add_post_link"><span> insert new post </span></a>
	<br />
	
	</c:if>

	<c:forEach items="${news}" var="post">
		<h2>${post.title}</h2>
			<c:if test="${sessionScope.LOGIN_DATA!=null}">
				<div class="admin_options"><a href="/delete_post.html?id=${post.id}" class="delete_post_link" id="p_${post.id}"><img title="delete post..." src="../static/images/cross.png"/></a>
				</div>
			</c:if>
		<div class="post_content">${post.content.value}
		<span class="date_field">Added ${post.date}</span>
		</div>
	</c:forEach>
	
	<c:set var="nextPageNumber" value="${param.page+1}" />
	<c:set var="prevPageNumber" value="${param.page-1}" /> 
	
	<c:if test="${not empty newerPosts}">
		<a href="/news.html?page=${prevPageNumber}"/>Newer posts</a>
	</c:if>
	
	<c:if test="${not empty olderPosts}">
		<a href="/news.html?page=${nextPageNumber}"/>Older posts</a>
	</c:if>

<%@ include file="../footer.jsp" %>
