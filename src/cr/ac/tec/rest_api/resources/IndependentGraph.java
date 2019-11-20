package cr.ac.tec.rest_api.resources;

import cr.ac.tec.rest_api.data.Graph;
import cr.ac.tec.rest_api.data.GraphList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/graph")
public class IndependentGraph {
    private UUID currentId;

    public IndependentGraph(UUID graphId){ this.currentId = graphId; }

    @GET
    @Produces("application/json")
    public Response getGraphData(){
        Graph graph = GraphList.graphs.get(currentId);
        if (graph != null){
            return Response.status(200)
                    .entity(graph)
                    .build();
        }
        return Response.status(404)
                .entity("No esta")
                .build();
    }

    @Path("nodes")
    public NodeHandler handleNodes(){
        return new NodeHandler(currentId);
    }
    @Path("edges")
    public EdgeHandler handleEdges(){
        return new EdgeHandler(currentId);
    }
}
