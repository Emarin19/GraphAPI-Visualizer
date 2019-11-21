package cr.ac.tec.rest_api.data;

import java.io.Serializable;
import java.util.UUID;


public class Node implements Serializable {
    private UUID id;
    private int inDegree;
    private int outDegree;
    private Object entity;
    private boolean visited;

    public Node(){
        this.id = UUID.randomUUID();
        this.inDegree = this.outDegree = 0;
    }

    public Node(Object entity){
        super();
        this.entity = entity;
    }
    public Node(UUID id){ this.id = id; }
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public int getInDegree() { return inDegree; }
    public void setInDegree(int inDegree) { this.inDegree = inDegree; }
    public int getOutDegree() { return outDegree; }
    public void setOutDegree(int outDegree) { this.outDegree = outDegree; }
    public Object getEntity() { return entity; }
    public void setEntity(Object entitySrc) { this.entity = entitySrc; }
    public boolean isVisited() { return visited; }
    public void setVisited(boolean visited) { this.visited = visited; }
}
