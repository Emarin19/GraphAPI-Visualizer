package cr.ac.tec.rest_api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/prueba")
public class Prueba {
    @GET
    @Produces("text/plain")
    public String getGraphs() {
        return "Hola a todos mis amigos de Costa Rica";
    }
}
