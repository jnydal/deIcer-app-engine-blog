package no.jorundnydal.deicer.controller.file;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class FileController extends AbstractController {
	
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			
			HttpServletResponse arg1) throws Exception {
		
				BlobKey blobKey = new BlobKey(arg0.getParameter("blob-key"));
				blobstoreService.serve(blobKey, arg1);

	        return null;
	        
	}

}