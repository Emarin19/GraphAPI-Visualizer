package cr.ac.tec.rest_api.data;

import cr.ac.tec.util.TecList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Graph implements Serializable {
    private UUID id;
    private TecList<Node> nodes = new TecList<>();
    private TecList<Edge> edges = new TecList<>();
    public Graph(){
        this.id = UUID.randomUUID();
    }
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Node[] getNodes() {
        Node[] serialized = new Node[nodes.size()];
        int i = 0;
        for (Node nodo: nodes) {
            serialized[i]= nodo;
            i++;
        }
        return serialized;
    }
    public void setNodes(Node[] nodesSrc) {
        nodes = new TecList<>();
        for (Node node: nodesSrc) {
            nodes.add(node);
        }
    }
    public Edge[] getEdges() {
        Edge[] serialized = new Edge[edges.size()];
        int i = 0;
        for (Edge edge: edges) {
            serialized[i]= edge;
            i++;
        }
        return serialized;
    }
    public void setEdges(Edge[] edgesSrc) {
        edges = new TecList<>();
        for (Edge edge: edgesSrc) {
            edges.add(edge);
        }
    }

    public TecList edgesProperty(){
        return edges;
    }
    public TecList nodesProperty(){
        return nodes;
    }
}
