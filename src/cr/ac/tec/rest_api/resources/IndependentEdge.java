package cr.ac.tec.rest_api.resources;

import cr.ac.tec.rest_api.data.Edge;
import cr.ac.tec.rest_api.data.Graph;
import cr.ac.tec.rest_api.data.Node;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/edge")
public class IndependentEdge {
    private Edge edge;
    private Graph parentGraph;
    public IndependentEdge(Graph parentGraph, UUID edgeId){
        this.edge = new Edge(edgeId);
        this.parentGraph = parentGraph;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEdge(Edge newEdge){
        if (parentGraph.edgesProperty().contains(edge)){
            edge.setStartNode(newEdge.getStartNode());
            edge.setEndNode(newEdge.getEndNode());
            edge.setWeight(newEdge.getWeight());
            return Response.status(200)
                    .entity("Updated edge")
                    .build();
        }
        if(!parentGraph.edgesProperty().contains(edge)){
            return Response.status(404)
                    .entity("Doesn´t exist")
                    .build();
        }
        return Response.status(500)
                .entity("Error")
                .build();
    }

    @DELETE
    public Response deleteEdge(){
        if(parentGraph.edgesProperty().contains(edge)){
            parentGraph.edgesProperty().removeValue(edge);
            return Response.status(200)
                    .entity("Deleted edge")
                    .build();
        }
        if (!parentGraph.edgesProperty().contains(edge)){
            return Response.status(404)
                    .entity("Doesn´t exist")
                    .build();
        }
        return Response.status(500)
                .entity("Error")
                .build();
    }
}
