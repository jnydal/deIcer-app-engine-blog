package no.jorundnydal.deicer.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.jorundnydal.deicer.Utils;
import no.jorundnydal.deicer.service.PageService;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;



/**
 * JavaBean abstract base class for nifrost-aware form controllers.
 * Provides convenience methods for subclasses.
 */
public abstract class AbstractNifrostFormController extends SimpleFormController {
	
	/**
	 * Set up a custom property editor for the application's date format.
	 */
	/*
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	 */
	/**
	 * Method disallows duplicate form submission.
	 * Typically used to prevent duplicate insertion of entities
	 * into the datastore. Shows a new form with an error message.
	 */
	/*
	protected ModelAndView disallowDuplicateFormSubmission(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		BindException errors = getErrorsForNewForm(request);
		errors.reject("duplicateFormSubmission", "Duplicate form submission");
		return showForm(request, response, errors);
		
	}
	*/
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
			
		ModelAndView modelAndView = super.handleRequest(arg0, arg1);

		WebApplicationContext applicationContext = Utils.getApplicationContext(arg0);
		PageService pageService = (PageService)applicationContext.getBean("pageService");
		
		// add topmenu links for all pages
		modelAndView.addObject("pageReferences", pageService.getPageReferences());
		
		return modelAndView;
		
	}
	
}