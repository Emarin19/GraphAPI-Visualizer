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
        this.parentGraph = parentGraph;
        this.node = parentGraph.searchNodeByUUID(nodeId);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateNode(Object requestBody){
        if (node!=null){
            node.setEntity(requestBody);
            return Response.status(200)
                    .entity("Updated")
                    .build();
        }else {
            return Response.status(500)
                    .entity("Error")
                    .build();
        }
    }

    @DELETE
    public Response deleteNode(){
        if(node!=null){
            parentGraph.nodesProperty().removeValue(node);
            parentGraph.refreshEdges();
            return Response.status(200)
                    .entity("Deleted node")
                    .build();
        }else {
            return Response.status(500)
                    .entity("Error")
                    .build();
        }
    }

}
