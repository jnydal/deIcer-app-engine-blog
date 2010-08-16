package no.jorundnydal.deicer;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jsr107cache.Cache;
import no.jorundnydal.deicer.entity.LoginData;
import no.jorundnydal.deicer.gae.SessionMemCacheManager;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;



public class Utils {

	
	public static boolean loggedIn(HttpServletRequest request, HttpServletResponse response) {
		
		boolean loggedIn = true;
    	
		// get sessionid from any existing cookie
		String sessionid = getCookieValue(request.getCookies(), "sessionid", Utils.generateSessionId());

		response.addCookie(new Cookie("sessionid", sessionid)); //This does nothing if the cookies already exists

		// get memcache session implementation singleton
		Cache cache = SessionMemCacheManager.getCache();
		
		// test is session is valid (got a loginData reference)
		LoginData loginData = (LoginData) cache.get(sessionid);

			if ( loginData==null) { // either memcache doesn't contain a the session data, or nobody is logged in
				
				// do ordinary session lookup approach
				HttpSession session = request.getSession(true);
				loginData = (LoginData) session.getAttribute("LOGIN_DATA");
				
				if ( loginData!=null ) {
				
					loggedIn = true;
				
				}
				
				loggedIn = false;
				
			}
			
			return loggedIn;
			
	}
	
	public static String getNewChallenge() {
	    
	    Random generator = new Random();
	    byte[] bytes = new byte[5];
	    generator.nextBytes(bytes);
	    String challenge = bytes.toString();
	
	    return challenge;
	    
	}
	
	public static String generateSessionId() {
		 final UUID idOne = UUID.randomUUID();
		 try {
		  return java.net.URLEncoder.encode(idOne.toString(),"UTF-8");
		 } catch (final UnsupportedEncodingException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		 }
		 return null;
	}
	
	public static String getCookieValue(Cookie[] cookies, String cookieName, String defaultValue) {
		for(int i=0; i<cookies.length; i++) {
		  Cookie cookie = cookies[i];
		  if (cookieName.equals(cookie.getName()))
			return(cookie.getValue());
		}
		return(defaultValue);
	}

	/*
	 * Get Spring application context
	 * 
	 */
	public static WebApplicationContext getApplicationContext(HttpServletRequest request) {
		WebApplicationContext ctx = 
			WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
				
		return ctx;

	}
	
	/*
	 * Set serversalt to request parameter
	 * 
	 */
	public static String getServerSalt(HttpServletRequest request) {
		
		WebApplicationContext applicationContext = Utils.getApplicationContext(request);
		Domain n = (Domain)applicationContext.getBean("domain");
	    return n.getServerSalt();
		
	}
	
	public static boolean validateBuiltInUser(LoginData loginData, HttpServletRequest request) {
		
		WebApplicationContext applicationContext = Utils.getApplicationContext(request);
		Domain n = (Domain)applicationContext.getBean("domain");
		
	    return (loginData.getUsername().equals("domainadmin") && loginData.getPassword().equals(n.getAdminPassword())) ? true : false;
		
	}

	public static String getLoggedInUserId(HttpServletRequest request) {

		return ((LoginData)request.getSession().getAttribute("LOGIN_DATA")).getUsername();
		
	}
	
}
