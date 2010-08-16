package no.jorundnydal.deicer.controller;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.jorundnydal.deicer.PMF;
import no.jorundnydal.deicer.dao.PostDAO;
import no.jorundnydal.deicer.gae.editor.GoogleDatastoreKeyEditor;
import no.jorundnydal.deicer.service.PostService;

import org.springframework.web.servlet.ModelAndView;
import java.util.logging.Logger;



@SuppressWarnings("unused")
public class ErrorController extends AbstractNifrostController {
	
	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("http-error");
        		
		return modelAndView;
		
	}
		
}
