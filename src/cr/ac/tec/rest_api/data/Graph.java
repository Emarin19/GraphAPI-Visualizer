package cr.ac.tec.rest_api.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Graph implements Serializable {
    private UUID id;
    private ArrayList<Node> nodes = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();

    public Graph(){
        this.id = UUID.randomUUID();
    }
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public ArrayList getNodes() { return nodes; }
    public void setNodes(ArrayList nodes) { this.nodes = nodes; }
    public ArrayList getEdges() { return edges; }
    public void setEdges(ArrayList edges) { this.edges = edges; }
}
