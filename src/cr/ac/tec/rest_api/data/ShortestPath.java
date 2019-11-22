package cr.ac.tec.rest_api.data;

import cr.ac.tec.util.TecList;

public class ShortestPath {
    private Double duration;
    private TecList<Node> path;

    public ShortestPath(){
        this.duration = 0.0;
        this.path = new TecList<>();
    }
    public ShortestPath(Double duration, TecList<Node> path){
        this.duration = duration;
        this.path = path;
    }
    public Node[] getPath() {
        Node[] serialized = new Node[path.size()];
        int i = 0;
        for (Node nodo: path) {
            serialized[i]= nodo;
            i++;
        }
        Node[] ordered = new Node[serialized.length];
        int j = serialized.length;
        for (int n=0; n<serialized.length; n++){
            ordered[j-1] = serialized[n];
            j = j-1;
        }
        return ordered;
    }
    public void setPath(Node[] nodesSrc) {
        path = new TecList<>();
        for (Node node: nodesSrc) {
            path.add(node);
        }
    }
    public Double getDuration() { return duration; }
    public void setDuration(Double duration) { this.duration = duration; }
    public TecList<Node> pathProperty(){
        return path;
    }
}
