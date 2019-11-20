package cr.ac.tec.rest_api.data;

import java.io.Serializable;
import java.util.UUID;

public class Node implements Serializable {
    private UUID id;
    private int inDegree;
    private int outDegree;
    private Object data;

    public Node(){ this.id = UUID.randomUUID(); }
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public int getInDegree() { return inDegree; }
    public void setInDegree(int inDegree) { this.inDegree = inDegree; }
    public int getOutDegree() { return outDegree; }
    public void setOutDegree(int outDegree) { this.outDegree = outDegree; }
    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }
}
