package no.jorundnydal.deicer.shop.controller.product;

import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.jorundnydal.deicer.Utils;
import no.jorundnydal.deicer.controller.AbstractNifrostFormController;
import no.jorundnydal.deicer.gae.editor.GoogleDatastoreTextEditor;
import no.jorundnydal.deicer.shop.entity.Product;
import no.jorundnydal.deicer.shop.service.CategoryService;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.apphosting.utils.remoteapi.RemoteApiPb.Response;


public class ProductNewController extends AbstractNifrostFormController {
	
	private CategoryService categoryService;

	  @InitBinder
	  protected void initBinder(HttpServletRequest request,
	                            ServletRequestDataBinder binder) throws Exception {
		  
	    binder.registerCustomEditor(com.google.appengine.api.datastore.Text.class,
	        new GoogleDatastoreTextEditor()
	    );
	
	  }
	
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
    	Product defaultproduct = new Product();
    	return defaultproduct;
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
    	
    	// store product
    	
    	return new ModelAndView("admin/Console");
    	
    }

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

}
