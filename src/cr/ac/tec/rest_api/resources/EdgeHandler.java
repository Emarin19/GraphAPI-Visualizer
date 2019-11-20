package cr.ac.tec.rest_api.resources;

import cr.ac.tec.rest_api.data.Edge;
import cr.ac.tec.rest_api.data.Graph;
import cr.ac.tec.rest_api.data.Node;

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
                .entity(parentGraph.getEdges())
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEdge(Edge e){
        Node out = parentGraph.searchNodeByUUID(e.getStartNode());
        Node in = parentGraph.searchNodeByUUID(e.getEndNode());
        if (out!=null && in!=null){
            parentGraph.edgesProperty().add(e);
            out.setOutDegree(out.getOutDegree()+1);
            in.setInDegree(in.getInDegree()+1);
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
            for (Node  node: parentGraph.nodesProperty()) {
                node.setInDegree(0);
                node.setOutDegree(0);
            }
            return Response.status(200)
                    .entity("Deleted edges")
                    .build();
        }
        if (parentGraph.edgesProperty().isEmpty()){
            return Response.status(404)
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
