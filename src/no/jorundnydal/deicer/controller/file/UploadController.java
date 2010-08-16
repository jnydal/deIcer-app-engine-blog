package no.jorundnydal.deicer.controller.file;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.jorundnydal.deicer.controller.AbstractNifrostController;

import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class UploadController extends AbstractNifrostController {
	
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		ModelAndView mav = handleRequestInternal(arg0, arg1);
		
		mav.setViewName("file/uploadProductImage");
	       
		BlobKey key = null;
		
	        if (arg0.getMethod().equalsIgnoreCase("post")) {
	        	
	        	key = storeFile(arg0);
	        	
	        }
	        if (key!=null) arg1.sendRedirect("/file.html?blob-key=" + key.getKeyString());
	        
	    return mav;
	        
	}
	
	@SuppressWarnings("unused")
	private BlobKey storeFile(HttpServletRequest arg0) {
		
    	// write
        Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(arg0);
        return blobs.get("myFile");
        
	}

}