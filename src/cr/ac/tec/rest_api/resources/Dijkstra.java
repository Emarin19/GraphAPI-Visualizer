package cr.ac.tec.rest_api.resources;

import cr.ac.tec.rest_api.data.Edge;
import cr.ac.tec.rest_api.data.Graph;
import cr.ac.tec.rest_api.data.Node;
import cr.ac.tec.rest_api.data.ShortestPath;
import cr.ac.tec.util.TecList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;


@Path("/dijkstra")
public class Dijkstra {
    private Graph parentGraph;
    public Dijkstra(Graph graph) { this.parentGraph = graph; }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response DijkstraShortestPath(Edge path){
        Node start = parentGraph.searchNodeByUUID(path.getStartNode());
        Node end = parentGraph.searchNodeByUUID(path.getEndNode());
        if (start!=null && end!=null){
            for (Node node: parentGraph.nodesProperty()){
                node.setVisited(false);
            }
            HashMap<Node, Node> changedAt = new HashMap<>();
            changedAt.put(start, null);

            HashMap<Node, Double> shortestPathMap = new HashMap<>();

            for (Node node: parentGraph.nodesProperty()){
                if (node == start)
                    shortestPathMap.put(start, 0.0);
                else
                    shortestPathMap.put(node, Double.POSITIVE_INFINITY);
            }

            for (Edge edge: parentGraph.edgesProperty()){
                Node s = parentGraph.searchNodeByUUID(edge.getStartNode());
                Node e = parentGraph.searchNodeByUUID(edge.getEndNode());
                if (s == start){
                    shortestPathMap.put(e, edge.getWeight());
                    changedAt.put(e, start);
                }
            }
            start.setVisited(true);

            while (true){
                Node currentNode = closestReachableUnvisited(shortestPathMap);
                if (currentNode == null){
                    return Response.status(404)
                            .entity("There isn´t a path between " + start.getEntity() + " and " + end.getEntity())
                            .build();
                }
                if (currentNode == end){
                    Node child = end;
                    TecList<Node> paths = new TecList<>();
                    paths.add(end);
                    while (true){
                        Node parent = changedAt.get(child);
                        if (parent==null){
                            break;
                        }
                        paths.add(parent);
                        child = parent;
                    }
                    ShortestPath shortestPath = new ShortestPath(shortestPathMap.get(end), paths);
                    return Response.status(200)
                            .entity(shortestPath)
                            .build();
                }
                currentNode.setVisited(true);

                for (Edge edge: parentGraph.edgesProperty()){
                    Node s = parentGraph.searchNodeByUUID(edge.getStartNode());
                    Node e = parentGraph.searchNodeByUUID(edge.getEndNode());
                    if (s == currentNode){
                        if (e.isVisited())
                            continue;
                        if (shortestPathMap.get(currentNode)+ edge.getWeight() < shortestPathMap.get(e)){
                            shortestPathMap.put(e, shortestPathMap.get(currentNode)+edge.getWeight());
                            changedAt.put(e,s);
                        }
                    }
                }
            }
        }
        return Response.status(500)
                .entity("Error")
                .build();
    }

    private Node closestReachableUnvisited(HashMap<Node, Double> shortestPathMap){
        double shortestDistance = Double.POSITIVE_INFINITY;
        Node closestReachableNode = null;
        for (Node node: parentGraph.nodesProperty()){
            if (node.isVisited())
                continue;

            double currentDistance = shortestPathMap.get(node);
            if (currentDistance == Double.POSITIVE_INFINITY)
                continue;

            if (currentDistance < shortestDistance){
                shortestDistance = currentDistance;
                closestReachableNode = node;
            }
        }
        return closestReachableNode;
    }
}
