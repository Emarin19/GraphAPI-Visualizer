package cr.ac.tec.rest_api.resources;

import cr.ac.tec.rest_api.data.Graph;
import cr.ac.tec.rest_api.data.Node;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/node")
public class IndependentNode {
    private Node node;
    private Graph parentGraph;
    public IndependentNode(Graph parentGraph, UUID nodeId){
        this.node = new Node(nodeId);
        this.parentGraph = parentGraph;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNode(){
        if (parentGraph.nodesProperty().contains(node)){
            return Response.status(200)
                    .entity(node)
                    .build();
        }
        return Response.status(500)
                .entity("Doesn´t exist")
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateNode(Object requestBody){
        if (parentGraph.nodesProperty().contains(node)){
            node.setEntity(requestBody);
            return Response.status(200)
                    .entity("Updated")
                    .build();
        }
        return Response.status(500)
                .entity("Error")
                .build();
    }

    @DELETE
    public Response deleteNode(){
        if(parentGraph.nodesProperty().contains(node)){
            int index=0;
            while (parentGraph.nodesProperty().get(index)!=node){
                index++;
            }
            parentGraph.nodesProperty().remove(index);
            return Response.status(200)
                    .entity("Deleted node")
                    .build();
        }
        return Response.status(500)
                .entity("Error")
                .build();
    }

}
