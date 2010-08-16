package no.jorundnydal.deicer.controller.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jsr107cache.Cache;
import no.jorundnydal.deicer.Utils;
import no.jorundnydal.deicer.controller.AbstractNifrostFormController;
import no.jorundnydal.deicer.entity.Admin;
import no.jorundnydal.deicer.entity.LoginData;
import no.jorundnydal.deicer.gae.SessionMemCacheManager;
import no.jorundnydal.deicer.service.UserService;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;




public class LoginController extends AbstractNifrostFormController {
	 
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected void initBinder(HttpServletRequest request,

		ServletRequestDataBinder binder) throws Exception {

		super.initBinder(request, binder);
	
		if (!this.isFormSubmission(request)) {
		
			// on new form, set up new challenge for login connection
	    	String challenge = Utils.getNewChallenge();
			request.getSession().setAttribute("challenge",challenge);
		
		}
		
		// set serversalt (is always needed)
		String serversalt = Utils.getServerSalt(request);
		request.getSession().setAttribute("serversalt",serversalt);
	    
	}

	/*
	 * called when opening login.html without any POST og GET parameters
	 * 
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
    	
    	LoginData defaultdata = new LoginData();
		
    	return defaultdata;
    	
    }
    
    private void setUpSession(HttpServletRequest request, HttpServletResponse response, LoginData loginData) {
    	
    	/*
		* memcache session handling implementation - primary handling solution
		*/
		
		String sessionid = Utils.getCookieValue(request.getCookies(), "sessionid", Utils.generateSessionId()); // get existing cookie - or create a new for memcache session
		Cache cache = SessionMemCacheManager.getCache();

		cache.put(sessionid, loginData);
		
		response.addCookie(new Cookie("sessionid", sessionid));
		
		/*
		* default session handling approach - secondary handling solution
		*/
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("LOGIN_DATA", loginData);	
									
		System.out.println("User "+loginData+" logged in...");
    	
    }
    
    private boolean validAdmin(LoginData loginData, String challenge) {
        
        System.out.println("validating password for "+loginData.getUsername()+"("+loginData.getPassword()+")");
        
        Admin user;
		
		boolean validLogin = false;
		
		Key objectkey = null;
			 
			  // validate user credentials
		      try {
		    	  
		    	objectkey = KeyFactory.createKey(Admin.class.getSimpleName(), loginData.getUsername());
				user = userService.getAdmin(objectkey);
				validLogin = user.validate(loginData.getPassword(), challenge);
				
			} catch (Exception e) {
				
				System.out.println("failed to get user from datastore "+e.getMessage());
				
			}
    	
    	return validLogin;
    	
    }
    
    /*
     * called on successfully validated login data format
     * 
     * (non-Javadoc)
     * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
     */
	@Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws ServletException {
		
		ModelAndView modelAndView = null;
		
		boolean validAdmin = validAdmin((LoginData)command, (String) request.getSession().getAttribute("challenge"));
		boolean validBuiltInUser = Utils.validateBuiltInUser((LoginData)command, request);
		
		if (validAdmin||validBuiltInUser) {
			
			setUpSession(request, response, (LoginData)command);
			modelAndView = new ModelAndView(new RedirectView(getSuccessView()));
			
		}else {
			
			//modelAndView.setView(new RedirectView("login.html?loginFailed=1"));
			try {
				response.sendRedirect("login.html?loginFailed=1");
			} catch (IOException e) {

				// eat it
				
			}
			
		}
		
		return modelAndView;
    	
    }

}
