package no.jorundnydal.deicer.controller.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.jorundnydal.deicer.Utils;
import no.jorundnydal.deicer.controller.AbstractNifrostFormController;
import no.jorundnydal.deicer.entity.Admin;
import no.jorundnydal.deicer.entity.User;
import no.jorundnydal.deicer.gae.editor.GoogleDatastoreKeyEditor;
import no.jorundnydal.deicer.service.UserService;
import no.jorundnydal.deicer.shop.entity.Customer;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;




public class AdminNewController extends AbstractNifrostFormController {
	
	private UserService userService;

	  @InitBinder
	  protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {

		GoogleDatastoreKeyEditor keyeditor = new GoogleDatastoreKeyEditor();
		  
	    binder.registerCustomEditor(com.google.appengine.api.datastore.Key.class,
	        keyeditor
	    );
	    
	    /*
	     * if posting
	     */
	    if (isFormSubmission(request)) {
	    	
	    	boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
	    	
	    	if (admin) {
	    		
	    		keyeditor.setSubclass(Admin.class);
	    		
	    	}else {
	    		
	    		keyeditor.setSubclass(Customer.class);
	    		
	    	}
	    	
	    }
	    
		String serversalt = Utils.getServerSalt(request);
	    request.setAttribute("serversalt",serversalt);
	
	  }
	  
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
    	
    	User defaultuser = null;
    	
    	/*
    	 * 
    	 * check if it's a create customer or create admin request
    	 * 
    	 */
    	boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
    	
		if (admin) {
			
			defaultuser = new Admin();
			
		}else {
			
			defaultuser = new Customer();
			
		}
    	
    	return defaultuser;
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
    	
    	this.userService.storeAdmin((Admin)command);
        
    	return new ModelAndView(new RedirectView(getSuccessView()));
    	
    }

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

}
