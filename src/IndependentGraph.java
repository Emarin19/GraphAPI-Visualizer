import cr.ac.tec.dto.DB;
import cr.ac.tec.objects.Graph;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/graph")
public class IndependentGraph {
    private UUID currentId;

    public IndependentGraph(UUID graphId) {
        this.currentId = graphId;
    }

    @GET
    @Produces("application/json")
    public Response getGraphData() {
         Graph g= DB.db.get(currentId);
        if (g != null) {
            return Response.status(200)
                    .entity(g)
                    .build();
        }
        return Response.status(404)
                .entity("NO ESTA")
                .build();
    }
}