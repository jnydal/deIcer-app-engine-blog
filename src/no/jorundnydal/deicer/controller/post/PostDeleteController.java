package no.jorundnydal.deicer.controller.post;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.jorundnydal.deicer.Utils;
import no.jorundnydal.deicer.controller.AbstractNifrostController;
import no.jorundnydal.deicer.service.PageService;
import no.jorundnydal.deicer.service.PostService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;



public class PostDeleteController extends AbstractNifrostController {

	private PostService postService;

	
	public PostService getPostService() {
		return postService;
	}


	public void setPostService(PostService postService) {
		this.postService = postService;
	}


	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse arg1) throws Exception {

		ModelAndView mav = handleRequestInternal(request, arg1);
		
		if (!Utils.loggedIn(request, arg1)) {
    		
    		return new ModelAndView(new RedirectView("login.html"));
    		
    	}

		Long id = Long.parseLong(request.getParameter("id"));
    	
		if (id!=null) {

    		postService.deletePost(id);
    		
    		mav = new ModelAndView(new RedirectView("news.html"));

		}
	    
	    return mav;
		
	}
	
}
