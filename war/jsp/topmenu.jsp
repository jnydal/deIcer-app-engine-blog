<div id="top_menu_transparancy"></div>
<div id="top_menu">
	
<ul class="sf-menu sf-navbar">

<!-- get page/handler and request attribute, make a clausule an put class="current" attribute to li element if handler is PageController by getting id parameter -->

				    <c:choose>
					<c:when test="${not empty news}">
					
						<li class="current"><a href="/news.html">News</a></li>
				   	
					</c:when>
					<c:otherwise>
					
						<li><a href="/news.html">News</a></li>
					
					</c:otherwise>
					</c:choose>
					
					<c:forEach var="reference" items="${pageReferences}" varStatus="status">
					   				   
					    <c:choose>
						<c:when test="${(param.id == reference.id) && not empty pagedata}">
						
							<li class="current"><a href="/page.html?id=${reference.id}">${reference.title}</a></li>
					   	
						</c:when>
						<c:otherwise>
						
							<li><a href="/page.html?id=${reference.id}">${reference.title}</a></li>
						
						</c:otherwise>
						</c:choose>
					   
					</c:forEach>
					
						<c:if test="${sessionScope.LOGIN_DATA!=null}">
					
							<li><a href="new_page.html" class="insert_link" id="add_page_link"><span> insert new page </span></a></li>
					
						</c:if>
					
					<!--<li>
						<a class="sf-with-ul" href="#">Merch<span class="sf-sub-indicator"> &#187;</span></a>
						<ul>
							<li>

								<a class="sf-with-ul" href="#">Tee's<span class="sf-sub-indicator"> &#187;</span></a>
								<ul>
									<li><a href="#">menu item</a></li>
									<li><a href="#aba">menu item</a></li>
									<li><a href="#abb">menu item</a></li>
									<li><a href="#abc">menu item</a></li>

									<li><a href="#abd">menu item</a></li>
								</ul>
							</li>
							<li>
								<a class="sf-with-ul" href="#">Long sleeves<span class="sf-sub-indicator"> &#187;</span></a>
								<ul>
									<li><a href="#">menu item</a></li>

									<li><a href="#aba">menu item</a></li>
									<li><a href="#abb">menu item</a></li>
									<li><a href="#abc">menu item</a></li>
									<li><a href="#abd">menu item</a></li>
								</ul>
							</li>
							<li>

								<a class="sf-with-ul" href="#">Caps<span class="sf-sub-indicator"> &#187;</span></a>
								<ul>
									<li><a href="#">menu item</a></li>
									<li><a href="#aba">menu item</a></li>
									<li><a href="#abb">menu item</a></li>
									<li><a href="#abc">menu item</a></li>

									<li><a href="#abd">menu item</a></li>
								</ul>
							</li>
							<li><a href="#">Shopping cart</a></li>
						</ul>
					</li>
					<li>
						<a class="sf-with-ul" href="#">menu item<span class="sf-sub-indicator"> &#187;</span></a>

						<ul>
							<li><a href="#">if no subitems, duplicate parent item href and use this as descriptive label</a></li>
						</ul>
					</li>
					<li>
						<a class="sf-with-ul" href="#">menu item<span class="sf-sub-indicator"> &#187;</span></a>
						<ul>

							<li><a href="#">subitem 4a</a></li>
							<li><a href="#">subitem 4b</a></li>
							<li><a href="#">subitem 4c</a></li>
							<li><a href="#">subitem 4d</a></li>
						</ul>
					</li>
					<li>

						<a class="sf-with-ul" href="#">menu item<span class="sf-sub-indicator"> &#187;</span></a>
						<ul>
							<li><a href="#">subitem 5a</a></li>
							<li><a href="#">subitem 5b</a></li>
							<li><a href="#">subitem 5c</a></li>
							<li><a href="#">subitem 5d</a></li>

						</ul>
					</li> -->
				</ul>
				
</div>
