package cr.ac.tec.rest_api.data;

import java.io.Serializable;
import java.util.UUID;

public class Edge implements Serializable {
    private UUID id;
    private UUID startNode;
    private UUID endNode;
    private int weight;

    public Edge(){ this.id = UUID.randomUUID(); }
    public Edge(UUID id) {this.id = id; }
    public Edge(UUID startNode, UUID endNode, int weight){
        this();
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = weight;
    }
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getStartNode() { return startNode; }
    public void setStartNode(UUID startNode) { this.startNode = startNode; }
    public UUID getEndNode() { return endNode; }
    public void setEndNode(UUID endNode) { this.endNode = endNode; }
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
}
