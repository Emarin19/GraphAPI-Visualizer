package cr.ac.tec.rest_api.data;

import cr.ac.tec.util.TecList;

import java.util.UUID;

public class Graph {
    private UUID id;
    private TecList<Node> nodes;
    private TecList<Edge> edges;

    public Graph(){ }
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public TecList<Node> getNodes() { return nodes; }
    public void setNodes(TecList<Node> nodes) { this.nodes = nodes; }
    public TecList<Edge> getEdges() { return edges; }
    public void setEdges(TecList<Edge> edges) { this.edges = edges; }
}
