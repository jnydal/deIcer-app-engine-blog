package no.jorundnydal.deicer.restapi;

import com.sun.jersey.spi.inject.Inject;

import no.jorundnydal.deicer.dao.UserDAO;

import org.springframework.context.annotation.Scope;  
import org.springframework.stereotype.Component;  

import java.util.logging.Logger;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;

/**
* User REST API
*/

@SuppressWarnings("unused")
@Component
@Path("/user")
@Scope("request")
public class UserResource {

    @SuppressWarnings("unused")
	private final Logger LOGGER = Logger.getLogger(UserResource.class.getName());
	
    @SuppressWarnings("unused")
	@Inject
    private UserDAO userDAO;

    @GET
	@Path("/{id}")
    @Produces("text/plain")
    public String getUserInfo(@PathParam("id") String id) {
	
        return "USER REST API GET response";
		
    }

    @PUT
    public void setNewContactInfo(String newContactInfo) {
	
        //UserDAO dao = new UserDaoImpl();
        //dao.setValue(newText);
        //this.dataMapper.saveData(dao);
		
    }
	
	@DELETE
	@Path("/{id}")
	@Produces("text/plain")
	public String deletePerson(@PathParam("id") String id) {
	   if(id!=null) {
			//deletePersonById(id);
	   }
/*
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		List<String> ids = queryParams.get("id");
	   if(ids == null) {
			//log.info("\n\nThe ids is null");
		} else {
		   for (String currentid : ids) {
				//deletePersonById(currentid);
			}
		}*/
	   return "success";
	}
	
}
