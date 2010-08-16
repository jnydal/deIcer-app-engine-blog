package no.jorundnydal.deicer.shop.controller.category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.jorundnydal.deicer.Utils;
import no.jorundnydal.deicer.controller.AbstractNifrostFormController;
import no.jorundnydal.deicer.shop.entity.Category;
import no.jorundnydal.deicer.shop.service.CategoryService;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;



public class CategoryNewController extends AbstractNifrostFormController {
	
	
	private CategoryService categoryService;
	
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
    	Category defaultcategory = new Category();
    	return defaultcategory;
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
    		
    	categoryService.storeCategory((Category)command);
    	
    	return new ModelAndView(new RedirectView(getSuccessView()));
    	
    }

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}
    
}
