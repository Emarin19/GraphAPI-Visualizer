package cr.ac.tec.rest_api.resources;

import cr.ac.tec.rest_api.data.Graph;
import cr.ac.tec.rest_api.data.GraphList;
import cr.ac.tec.rest_api.data.Node;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/nodes")
public class NodeHandler {
    private Graph parentGraph;
    public NodeHandler(Graph graph){ this.parentGraph = graph; }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNodes(){
        if (parentGraph!=null){
            return Response.status(200)
                    .entity(parentGraph.getNodes())
                    .build();
        }
        return Response.status(500)
                .entity("Error")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNode(Object requestBody){
        Node newNode = new Node();
        newNode.setEntity(requestBody);
        parentGraph.nodesProperty().add(newNode);
        return Response.status(201)
                .entity(newNode.getId())
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNodes(){
        return Response.status(201)
                .entity(parentGraph.getNodes())
                .build();
    public Response addNode(Node newNode){
        try{
            parentGraph.nodesProperty().add(newNode);
            return Response.status(200)
                    .entity(newNode.getId())
                    .build();
        }catch (Exception e){
            return Response.status(500)
                    .entity("Error")
                    .build();
        }
    }

    @DELETE
    public Response deleteNodes(){
        try {
            parentGraph.nodesProperty().clear();
            return Response.status(200)
                    .entity("Deleted nodes")
                    .build();
        }catch (Exception e){
            return Response.status(500)
                    .entity("Error")
                    .build();
        }
    }

    @Path("{id}")
    public IndependentNode handleSingleNode(@PathParam("id")UUID nodeId){
        return new IndependentNode(parentGraph, nodeId);
    }

}
