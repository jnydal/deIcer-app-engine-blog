package no.jorundnydal.deicer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.jorundnydal.deicer.Utils;
import no.jorundnydal.deicer.service.PageService;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;



/*
 *
 * base controller class for nifrost-band page requests
 *
 *
 */
public abstract class AbstractNifrostController extends AbstractController {


	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();

		WebApplicationContext applicationContext = Utils.getApplicationContext(arg0);
		PageService pageService = (PageService)applicationContext.getBean("pageService");
		
		// add topmenu links for all pages
		modelAndView.addObject("pageReferences", pageService.getPageReferences());
		
		return modelAndView;
		
	}

}
