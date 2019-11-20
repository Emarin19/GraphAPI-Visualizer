package cr.ac.tec.rest_api.resources;

import cr.ac.tec.rest_api.data.Edge;
import cr.ac.tec.rest_api.data.GraphList;
import cr.ac.tec.rest_api.data.Graph;
import cr.ac.tec.rest_api.data.Node;
import cr.ac.tec.util.TecList;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


//Defines the base URI for all resource URIs.
@ApplicationPath("/")
//The java class declares root resource and provider classes
public class GraphAPI extends Application{
    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(Graphs.class);
        classes.add(GraphList.class);
        classes.add(TecList.class);
        classes.add(Graph.class);
        classes.add(Node.class);
        classes.add(Edge.class);
        return classes;
    }
}