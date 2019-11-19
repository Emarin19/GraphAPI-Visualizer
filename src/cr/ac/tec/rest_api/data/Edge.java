package cr.ac.tec.rest_api.data;

import java.util.UUID;

public class Edge {
    private UUID id;
    private UUID start;
    private UUID end;
    private int weight;

    public Edge(){ }
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getStart() { return start; }
    public void setStart(UUID start) { this.start = start; }
    public UUID getEnd() { return end; }
    public void setEnd(UUID end) { this.end = end; }
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
}
