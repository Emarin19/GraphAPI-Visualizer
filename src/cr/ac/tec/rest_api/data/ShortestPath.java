package cr.ac.tec.rest_api.data;

import cr.ac.tec.util.TecList;

public class ShortestPath {
    private Double duration;
    private TecList<Node> path;

    public ShortestPath(){}
    public ShortestPath(Double duration, TecList<Node> path){
        this.setDuration(duration);
        this.setPath(path);
    }
    public Double getDuration() { return duration; }
    public void setDuration(Double duration) { this.duration = duration; }
    public TecList<Node> getPath() { return path; }
    public void setPath(TecList<Node> path) { this.path = path; }
}
