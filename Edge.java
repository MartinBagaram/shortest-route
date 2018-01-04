//Class defining the arcs in the network. A class has distance,
//a beginning node and a destination node

//package shortRoute;

public class Edge  {
    private final String id;
    private final Vertex source;
    private final Vertex destination;
    private final double weight;
    
    //Constructs the arc with appropriate parameters which are the string, id of the the edge
    // Vertex, destination which is the destination node of the edge and double weight which is the
    // the duration or the distance of the arc in the network from the node source to the node destination
    public Edge(String id, Vertex source, Vertex destination, double weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    
    // returns the id of the edge
    public String getId() {
        return id;
    }
    
    // returns the destination node of the arc
    public Vertex getDestination() {
        return destination;
    }
    
    // returns the source vertex of the arc
    public Vertex getSource() {
        return source;
    }
    
    // returns the the duration or the distance between the source node and the destination node
    // which is the weight of the node
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }


}