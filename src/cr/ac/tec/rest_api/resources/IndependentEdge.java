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
        this.parentGraph = parentGraph;
        this.edge = parentGraph.searchEdgeByUUID(edgeId);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEdge(Edge newInfo){
        Node prevStart = parentGraph.searchNodeByUUID(edge.getStartNode());
        Node prevEnd=parentGraph.searchNodeByUUID(edge.getEndNode());
        Node start = parentGraph.searchNodeByUUID(newInfo.getStartNode());
        Node end= parentGraph.searchNodeByUUID(newInfo.getEndNode());
        if (edge!=null && start !=null && end !=null){
            //updating degrees
            prevStart.setOutDegree(prevStart.getOutDegree()-1);
            prevEnd.setInDegree(prevEnd.getInDegree()-1);
            start.setInDegree(start.getInDegree()+1);
            end.setOutDegree(end.getOutDegree()+1);
            //updating info
            edge.setStartNode(start.getId());
            edge.setEndNode(end.getId());
            edge.setWeight(newInfo.getWeight());
            return Response.status(200)
                    .entity("Updated edge")
                    .build();
        }
        if(edge==null){
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
        try {
            if (edge != null) {
                Node start = parentGraph.searchNodeByUUID(edge.getStartNode());
                Node end = parentGraph.searchNodeByUUID(edge.getEndNode());
                start.setOutDegree(start.getOutDegree()-1);
                end.setInDegree(end.getInDegree()-1);

                parentGraph.edgesProperty().removeValue(edge);
                return Response.status(200)
                        .entity("Deleted edge")
                        .build();
            } else {
                return Response.status(404)
                        .entity("Doesn´t exist")
                        .build();
            }
        }catch (Exception e) {
            return Response.status(500)
                    .entity("Error")
                    .build();
        }
    }
}
