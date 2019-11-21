package cr.ac.tec.rest_api.resources;

import cr.ac.tec.rest_api.data.GraphList;
import cr.ac.tec.rest_api.data.Graph;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/graphs")
public class Graphs {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGraphs(){
        if (GraphList.graphs.isEmpty())
            //empty array if no graphs in memory
            return Response.status(200)
                    .entity(new String[0])
                    .build();
        else {
            return Response.status(200)
                    .entity(GraphList.graphs)
                    .build();
        }

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGraph(){
        try {
            Graph graph = new Graph();
            GraphList.graphs.put(graph.getId(),graph);
            return Response.status(200)
                    .entity(graph.getId())
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
