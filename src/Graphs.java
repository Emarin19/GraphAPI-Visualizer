import javax.ws.rs.*;
import java.util.UUID;


@Path("/graphs")
public class Graphs {
    @GET
    public void get(){}
    @POST
    public void post(){}
    @DELETE
    public void delete(){}

    @Path("{id}")
    public IndependentGraph handleSigleGraph(@PathParam("id") UUID graphId) {
        return new IndependentGraph(graphId);
    }
}