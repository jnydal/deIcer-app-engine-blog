package no.jorundnydal.deicer.controller.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import no.jorundnydal.deicer.controller.AbstractNifrostController;
import no.jorundnydal.deicer.entity.Admin;
import no.jorundnydal.deicer.service.UserService;

import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class ResetPasswordController extends AbstractNifrostController {

	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse arg1) throws Exception {

		ModelAndView mav = handleRequestInternal(request, arg1);
		
		mav.setViewName("authentication/resetPassword");
		
	        if (request.getMethod().equalsIgnoreCase("post")) {
	        	
	        	String email = request.getParameter("email");
	        	sendResetLink(email);
	        	
	        }
	    
	    return mav;
		
	}

	private void sendResetLink(String email) throws UnsupportedEncodingException {

		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String msgBody = "Click to <a href=''>reset your password</a>";

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("noreply@nifrost-band.appspot.com", "Nifrost-band website"));
            System.out.println(email);
            Key id = KeyFactory.createKey(Admin.class.getSimpleName(), email);
            Admin a = userService.getAdmin(id);
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress(email, ""));
            msg.setSubject("Reset your admin password");
            msg.setText(msgBody);
            Transport.send(msg);

        } catch (AddressException e) {
            // ...
        } catch (MessagingException e) {
            // ...
        }
		
	}
	
}
