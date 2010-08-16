package no.jorundnydal.deicer.controller.page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.jorundnydal.deicer.Utils;
import no.jorundnydal.deicer.controller.AbstractNifrostFormController;
import no.jorundnydal.deicer.entity.Page;
import no.jorundnydal.deicer.gae.editor.GoogleDatastoreTextEditor;
import no.jorundnydal.deicer.service.PageService;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;



public class PageNewController extends AbstractNifrostFormController {
	
	private PageService pageService;

	  @InitBinder
	  protected void initBinder(HttpServletRequest request,
	                            ServletRequestDataBinder binder) throws Exception {
		  
	    binder.registerCustomEditor(com.google.appengine.api.datastore.Text.class,
	        new GoogleDatastoreTextEditor()
	    );
	
	  }
	
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
    	Page defaultpage = new Page();
    	return defaultpage;
    }

    @Override
    protected ModelAndView showForm(HttpServletRequest request,
            HttpServletResponse response, BindException errors) throws Exception {
			
    	if (!Utils.loggedIn(request, response)) {
    		
    		return new ModelAndView(new RedirectView("login.html"));
    		
    	}
   
        return super.showForm(request, response, errors);
		
    }
    
    @Override
    public ModelAndView onSubmit(Object command) throws ServletException {

    	this.pageService.storePage((Page)command);
    		
    	return new ModelAndView(new RedirectView(getSuccessView()));
    	
    }

	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

	public PageService getPageService() {
		return pageService;
	}

}
