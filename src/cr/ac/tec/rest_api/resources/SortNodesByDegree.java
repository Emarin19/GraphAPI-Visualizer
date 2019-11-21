package cr.ac.tec.rest_api.resources;

import cr.ac.tec.rest_api.data.Graph;

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
        parentGraph.setOrderingWay(graph.getOrderingWay());
        if (parentGraph.nodesProperty()!=null) {
            if (parentGraph.getOrderingWay().equalsIgnoreCase("DESC")) {
                parentGraph.sortNodesDESC();
                return Response.status(200)
                        .entity(parentGraph.getNodes())
                        .build();
            }
            if (parentGraph.getOrderingWay().equalsIgnoreCase("ASC")) {
                parentGraph.sortNodesACS();
                return Response.status(200)
                        .entity(parentGraph.getNodes())
                        .build();
            } else {
                return Response.status(500)
                        .entity("Wrong parameter")
                        .build();
            }
        }
        return Response.status(404)
                .entity("Graph doesn´t has nodes")
                .build();
    }
}
