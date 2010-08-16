package no.jorundnydal.deicer.controller.page;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.jorundnydal.deicer.Utils;
import no.jorundnydal.deicer.controller.AbstractNifrostController;
import no.jorundnydal.deicer.service.PageService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;



public class PageDeleteController extends AbstractNifrostController {

	private PageService pageService;

	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse arg1) throws Exception {

		ModelAndView mav = handleRequestInternal(request, arg1);
		
		if (!Utils.loggedIn(request, arg1)) {
    		
    		return new ModelAndView(new RedirectView("login.html"));
    		
    	}

		Long id = Long.parseLong(request.getParameter("id"));
    	
		if (id!=null) {

    		pageService.deletePage(id);
    		
    		mav = new ModelAndView(new RedirectView("news.html"));

		}
	    
	    return mav;
		
	}

	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

	public PageService getPageService() {
		return pageService;
	}
	
}
