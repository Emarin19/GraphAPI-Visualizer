package cr.ac.tec.rest_api.data;

import cr.ac.tec.util.TecList;

import java.io.Serializable;
import java.util.UUID;

public class Graph implements Serializable {
    private UUID id;
    private String orderingWay;
    private TecList<Node> nodes;
    private TecList<Edge> edges;

    public Graph(){
        this.id = UUID.randomUUID();
        this.nodes = new TecList<>();
        this.edges = new TecList<>();
    }
    public Graph(String orderingWay){
        this.setOrderingWay(orderingWay);
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
    public String getOrderingWay() { return orderingWay; }
    public void setOrderingWay(String orderingWay) { this.orderingWay = orderingWay; }

    //Bubble sort
    public Node[] sortNodesACS(){
        int n = nodesProperty().size();
        Node temp = null;
        boolean stop = false;
        while(!stop) {
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int valueA = (nodesProperty().get(i).getInDegree()+nodesProperty().get(i).getOutDegree())/2;
                    int valueB = (nodesProperty().get(j).getInDegree()+nodesProperty().get(j).getOutDegree())/2;
                    if(valueA > valueB){
                        temp = nodesProperty().get(i);
                        nodesProperty().reinsert(nodesProperty().get(j), i);
                        nodesProperty().reinsert(temp, j);
                        c++;
                    }
                }
            }
            if (c == 0) { stop = true; }
        }
        return getNodes();
    }

    public Node[] sortNodesDESC(){
        Node[] ACS = sortNodesACS();
        Node[] DESC = new Node[ACS.length];
        int j = ACS.length;
        for (int i=0; i<ACS.length; i++){
            DESC[j-1] = ACS[i];
            j = j-1;
        }
        setNodes(DESC);
        return DESC;
    }
}
