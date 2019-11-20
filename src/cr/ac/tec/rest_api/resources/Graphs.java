package cr.ac.tec.rest_api.resources;

import cr.ac.tec.rest_api.data.Edge;
import cr.ac.tec.rest_api.data.GraphList;
import cr.ac.tec.rest_api.data.Graph;
import cr.ac.tec.rest_api.data.Node;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/graphs")
public class Graphs {
    @GET
    @Produces("application/json")
    public Response getGraphs(){
        return Response.status(200)
                .entity(GraphList.graphs)
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGraph(){
        try {
            Graph g = new Graph();
            GraphList.graphs.put(g.getId(),g);
            return Response.status(200)
                    .entity(g)
                    .build();
        }catch (Exception e){
            return Response.status(500)
                    .entity("Graph not created")
                    .build();
        }
    }

    @DELETE
    public Response deleteGraphs(){
        GraphList.graphs.clear();
        return Response.status(200)
                .entity("Deleted graphs")
                .build();
    }

    @Path("{id}")
    public IndependentGraph handleSingleGraph(@PathParam("id")UUID graphId){
        return new IndependentGraph(graphId);
    }
}
