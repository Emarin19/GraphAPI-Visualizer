package cr.ac.tec.rest_api.resources;

import cr.ac.tec.rest_api.data.Graph;
import cr.ac.tec.rest_api.data.Node;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/degree")
public class SortNodesByDegree {
    private Graph parentGraph;
    public SortNodesByDegree(Graph graph) { this.parentGraph = graph; }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sortNode(Graph graph){
        if (graph.getOrderingWay().equalsIgnoreCase("ASC")){

        }
        else if (graph.getOrderingWay().equalsIgnoreCase("DESC")){

        }
        else {
            return Response.status(500)
                    .entity("Wrong parameter")
                    .build();
        }
    }
}
