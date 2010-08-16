package no.jorundnydal.deicer.controller.post;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.jorundnydal.deicer.PMF;
import no.jorundnydal.deicer.controller.AbstractNifrostController;
import no.jorundnydal.deicer.dao.PostDAO;
import no.jorundnydal.deicer.entity.Admin;
import no.jorundnydal.deicer.entity.BlogPost;
import no.jorundnydal.deicer.entity.LoginData;
import no.jorundnydal.deicer.entity.User;
import no.jorundnydal.deicer.gae.editor.GoogleDatastoreKeyEditor;
import no.jorundnydal.deicer.service.PostService;

import org.springframework.web.servlet.ModelAndView;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;


@SuppressWarnings("unused")
public class NewsController extends AbstractNifrostController {
	
	private static final Logger log = Logger.getLogger(GoogleDatastoreKeyEditor.class.getName());
	
	private PostService postService;
	
	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
	
		log.info("logger is working!");
		
		ModelAndView modelAndView = handleRequestInternal(arg0, arg1);
    
		modelAndView.setViewName("post/news");
		
		Long page = null;

		try {
			
			page = Long.parseLong(arg0.getParameter("page"));
		
		}catch (NumberFormatException e) {
			
			page = (long) 0;
			
		}
		
		boolean nextResultLink = (postService.isOlderPosts(page)) ? true : false;
		boolean prevResultLink = (postService.isNewerPosts(page)) ? true : false;
		
		if (nextResultLink) modelAndView.addObject("olderPosts", nextResultLink);
		if (prevResultLink) modelAndView.addObject("newerPosts", prevResultLink);		

        modelAndView.addObject("news", postService.getPosts(page));
        		
		return modelAndView;
		
	}
		
}
