package no.jorundnydal.deicer.controller.post;

import java.util.Date;


import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.jorundnydal.deicer.PMF;
import no.jorundnydal.deicer.Utils;
import no.jorundnydal.deicer.controller.AbstractNifrostController;
import no.jorundnydal.deicer.entity.Admin;
import no.jorundnydal.deicer.entity.BlogPost;
import no.jorundnydal.deicer.service.PostService;
import no.jorundnydal.deicer.service.UserService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;

public class PostNewController extends AbstractNifrostController {

	private UserService userService;
	private PostService postService;
	
	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse arg1) throws Exception {

		ModelAndView mav = handleRequestInternal(request, arg1);
		
		if (!Utils.loggedIn(request, arg1)) {
    		
    		return new ModelAndView(new RedirectView("login.html"));
    		
    	}
		
		String id = Utils.getLoggedInUserId(request);
		Key objectkey = KeyFactory.createKey(Admin.class.getSimpleName(), id);
		//Admin user = userService.getAdmin(objectkey);
		//System.out.println("admin key "+user.getId());
		
	        if (request.getMethod().equalsIgnoreCase("post")) {
	        	
        		String title = request.getParameter("title");
        		String content = request.getParameter("content");
	        	
        		if (!title.isEmpty()&&!content.isEmpty()) {
	        		
	        		BlogPost post = new BlogPost();
	
	        		post.setTitle(title);
	        		post.setContent(new Text(content));
	        		post.setDate(new Date());
	        		post.setUser(objectkey);

	        		postService.storePost(post);

        		}

	        }
	    
	    return new ModelAndView(new RedirectView("news.html"));
		
	}
	
}
