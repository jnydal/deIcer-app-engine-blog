package no.jorundnydal.deicer.controller.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jsr107cache.Cache;
import no.jorundnydal.deicer.Utils;
import no.jorundnydal.deicer.controller.AbstractNifrostController;
import no.jorundnydal.deicer.gae.SessionMemCacheManager;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;



public class LogoutController extends AbstractNifrostController {
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// invalidate memcache session
		String sessionid = Utils.getCookieValue(request.getCookies(), "sessionid" , null);
			if (sessionid!=null) {
			
				Cache cache = SessionMemCacheManager.getCache();
				cache.remove(sessionid);
				
			}
		
		// invalidate ordinary session
		request.getSession().invalidate();
		
		ModelAndView modelAndView = handleRequestInternal(request, response);
		
		modelAndView.setView(new RedirectView("news.html"));

		return modelAndView;
		
	}

}
