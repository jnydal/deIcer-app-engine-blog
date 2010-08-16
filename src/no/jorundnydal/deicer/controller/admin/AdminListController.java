package no.jorundnydal.deicer.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.jorundnydal.deicer.Utils;
import no.jorundnydal.deicer.controller.AbstractNifrostController;
import no.jorundnydal.deicer.service.UserService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;



public class AdminListController extends AbstractNifrostController {
	
	private UserService userService;
	
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
    	if (!Utils.loggedIn(arg0, arg1)) {
    		
    		return new ModelAndView(new RedirectView("login.html"));
    		
    	}
		
		ModelAndView modelAndView = handleRequestInternal(arg0, arg1);
		
		modelAndView.setViewName("admin/adminList");
		
		modelAndView.addObject("adminList", this.userService.getAllAdmins());

		return modelAndView;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

}
