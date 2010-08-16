package no.jorundnydal.deicer.controller.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.jorundnydal.deicer.controller.AbstractNifrostController;
import no.jorundnydal.deicer.service.PageService;

import org.springframework.web.servlet.ModelAndView;


public class PageController extends AbstractNifrostController {
	
	private PageService pageService;
	
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		ModelAndView modelAndView = handleRequestInternal(arg0, arg1);
		
		modelAndView.setViewName("page/page");
		
		Long id = Long.parseLong(arg0.getParameter("id"));
		
		modelAndView.addObject("pagedata", this.pageService.getPage(id));

		return modelAndView;
	}

	public PageService getPageService() {
		return pageService;
	}

	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

}
