package cr.ac.tec.graph.api.resources;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;


@Path("/Test")
public class Test {
	
	@GET
	public Response get() {
		return Response.status(200).entity("The website has been created").build();
	}


}
