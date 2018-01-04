//Class defining the graph which is the full network with the 
// nodes and the arcs with each node having an ID and a name
// arcs having a weight wich can be the distance or the travel time 
//the class computes the shortest distance

//package shortRoute;

import java.util.List;

public class Graph {
    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    public Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }



}