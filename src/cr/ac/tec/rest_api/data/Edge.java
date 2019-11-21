package cr.ac.tec.rest_api.data;

import java.io.Serializable;
import java.util.UUID;

public class Edge implements Serializable {
    private UUID id;
    private UUID startNode;
    private UUID endNode;
    private Double weight;

    public Edge(){ this.id = UUID.randomUUID(); }
    public Edge(UUID id) {this.id = id; }
    public Edge(UUID startNode, UUID endNode, Double weight){
        this();
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = weight;
    }
    public Edge(UUID startNode, UUID endNode){
        this.startNode = startNode;
        this.endNode = endNode;
    }
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getStartNode() { return startNode; }
    public void setStartNode(UUID startNode) { this.startNode = startNode; }
    public UUID getEndNode() { return endNode; }
    public void setEndNode(UUID endNode) { this.endNode = endNode; }
    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }
}
