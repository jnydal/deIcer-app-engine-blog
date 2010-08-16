package no.jorundnydal.deicer.controller.authentication.validator;

import no.jorundnydal.deicer.entity.LoginData;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class LoginValidator implements Validator {
	
/*
 * called on posting to login.html
 * 
 * validates login fields for not beein empty or null... nothing more unfortunally
 * for user credential validation process, see com.nifrost.web.controller.LoginController
 * 
 * (non-Javadoc)
 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
 */
   public void validate(Object obj, Errors errors) {
	   
	  LoginData loginData = (LoginData)obj;
      
      if (loginData.getUsername() == null || loginData.getUsername().length() == 0) {
           errors.rejectValue("username", "error.empty.field", "empty username");
      } 
	  if (loginData.getPassword() == null || loginData.getPassword().length() == 0) {
		   errors.rejectValue("password", "error.empty.field", "empty password");
	  }

   }

    @SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
        return clazz.equals(LoginData.class);
    }
}
