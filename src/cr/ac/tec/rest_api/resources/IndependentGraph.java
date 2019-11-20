package cr.ac.tec.rest_api.resources;

import cr.ac.tec.rest_api.data.Graph;
import cr.ac.tec.rest_api.data.GraphList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/graph")
public class IndependentGraph {
    private Graph graph;
    public IndependentGraph(UUID graphId){
        this.graph = GraphList.graphs.get(graphId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGraph(){
        if (graph!=null){
            return Response.status(200)
                    .entity(graph)
                    .build();
        }
        return Response.status(404)
                .entity("Doesn't exist")
                .build();
    }

    @DELETE
    public Response deleteGraph(){
        if (graph!=null){
            GraphList.graphs.remove(graph.getId());
            return Response.status(200)
                    .entity("Graph removed")
                    .build();
        }
        return Response.status(404)
                .entity("Doesn´t exist")
                .build();
    }

    @Path("nodes")
    public NodeHandler handleNodes(){ return new NodeHandler(graph); }

    @Path("edges")
    public EdgeHandler handleEdges(){
        return new EdgeHandler(graph);
    }
}
