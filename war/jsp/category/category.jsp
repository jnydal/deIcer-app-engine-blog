<%@ include file="../includes.jsp" %>
<%@ include file="../header.jsp" %>

	<c:forEach items="${products}" var="product">
		<div class="product_line">
			<span><img src="${product.image}"/></span>
			<span>${product.title}</span>
			<span>${product.price}</span>
			<form>
				<input size="2" type="text" value="1"/>
				<button>Add to cart</button>
			</form>
		</div>
	</c:forEach>

<%@ include file="../footer.jsp" %>
