package cr.ac.tec.rest_api.data;

import cr.ac.tec.util.TecList;

import java.io.Serializable;
import java.util.UUID;

public class Graph implements Serializable {
    private UUID id;
    private TecList<Node> nodes;
    private TecList<Edge> edges;

    public Graph(){
        this.id = UUID.randomUUID();
        this.nodes = new TecList<>();
        this.edges = new TecList<>();
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

    //NON JSON FUNCTIONS
    public UUID[] listNodes(){
        UUID[] nodeList = new UUID[nodes.size()];
        int i= 0;
        for (Node node: nodes) {
            nodeList[i] = node.getId();
        }
        return nodeList;
    }
    public Node searchNodeByUUID(UUID id){
        for (Node node:nodes) {
            if (node.getId().equals(id)){
                return node;
            }
        } return null;
    }
    public Edge searchEdgeByUUID(UUID id){
        for (Edge edge:edges) {
            if (edge.getId().equals(id)){
                return edge;
            }
        } return null;
    }
    public TecList<Edge> edgesProperty(){
        return edges;
    }
    public TecList<Node> nodesProperty(){
        return nodes;
    }

    public void refreshEdges() {
        TecList<Edge> toDelete = new TecList<>();
        for (Edge edge: edges) {
            Node start = searchNodeByUUID(edge.getStartNode());
            Node end = searchNodeByUUID(edge.getEndNode());
            if(start==null && end==null) {
                toDelete.add(edge);
            }else if(start==null){
                toDelete.add(edge);
                end.setInDegree(end.getInDegree()-1);
            }
            else if(end==null){
                toDelete.add(edge);
                start.setOutDegree(start.getOutDegree()-1);
            }

        }
        for (Edge edge: toDelete) {
            edges.removeValue(edge);
        }
    }
}
