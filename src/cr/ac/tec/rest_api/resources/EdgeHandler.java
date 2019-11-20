package cr.ac.tec.rest_api.resources;

import cr.ac.tec.rest_api.data.Edge;
import cr.ac.tec.rest_api.data.Graph;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;


@Path("/edges")
public class EdgeHandler {
    private Graph parentGraph;
    public EdgeHandler(Graph graph) { this.parentGraph = graph; }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEdges(){
        return Response.status(200)
                .entity(parentGraph.edgesProperty())
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEdge(Edge newEdge){
        if (parentGraph.nodesProperty().contains(newEdge.getStartNode()) && parentGraph.nodesProperty().contains(newEdge.getEndNode())){
            parentGraph.edgesProperty().add(newEdge);
            return Response.status(200)
                    .entity("Created edge")
                    .build();
        }
        return Response.status(500)
                .entity("Error")
                .build();
    }

    @DELETE
    public Response deleteEdges(){
        if (parentGraph.edgesProperty()!=null){
            parentGraph.edgesProperty().clear();
            return Response.status(200)
                    .entity("Deleted edges")
                    .build();
        }
        if (parentGraph.edgesProperty().isEmpty()){
            return Response.status(200)
                    .entity("Graph doesn´t has edges")
                    .build();
        }
        return Response.status(500)
                .entity("Error")
                .build();
    }

    @Path("{id}")
    public IndependentEdge handleSingleEdge(@PathParam("id") UUID edgeId){
        return new IndependentEdge(parentGraph, edgeId);
    }

}
