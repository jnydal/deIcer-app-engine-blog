<%@ include file="../includes.jsp" %>
<%@ include file="../header.jsp" %>
	
	<c:if test="${sessionScope.LOGIN_DATA!=null}">
	
		<div id="admin_options"><a href="/edit_page.html?id=${param.id}" id="p_${param.id}"><img title="edit page..."  alt="edit page..." src="../static/images/edit-32.png"/></a><a href="/delete_page.html?id=${param.id}" class="delete_page_link" id="p_${param.id}"><img title="delete page..." src="../static/images/cross.png"/></a></div>
	
	</c:if>
	
	<!-- <h1>${pagedata.title}</h1> -->
	
	<div class="page_content">
	
	${pagedata.content.value}
	
	<div class="date_field">Updated ${pagedata.date}</div>
	</div>
	
<%@ include file="../footer.jsp" %>