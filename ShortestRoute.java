import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.io.*;
import java.util.*;

   
public class ShortestRoute {
    public static void main(String[] args) throws FileNotFoundException {
       	introduction();
       	System.out.print("Input file name : ");
       	Scanner console = new Scanner(System.in);
       	String file = console.next();
       	console.close();
       	Scanner input = new Scanner(new File(file));
       	int numNodes = input.nextInt();
       	int numEdges = input.nextInt();
        List<Vertex> nodes = new ArrayList<Vertex>();
        List<Edge> edges = new ArrayList<Edge>();
        
        for (int i = 0; i < numNodes; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }
        
        for (int j = 0; j < numEdges; j++) {
        	addArc("Edge_" + j, input.nextInt(), input.nextInt(), input.nextDouble(), nodes, edges);
        }
        input.close();
        
        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(0));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(numNodes - 1));

       //  assertNotNull(path);
//         assertTrue(path.size() > 0);
//         
        System.out.println();
        System.out.println("The best sequence of steps is the following :");
        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
        
        //prints the total duration of the network considering only the shortest path
        System.out.println();
        System.out.print("The shortest distance or duration of the network is   ");
        System.out.println(dijkstra.getShortestDistance(nodes.get(numNodes - 1)));
    }
    
    //Defines the initial text introducing the behavior and data required from the user
    private static void introduction() {
    	System.out.println("This is the algorithm for solving the shortest distance algorithm problem");
    	System.out.println("Examples of such problems are");
    	System.out.println("     Which section of the road should be built to allow the harvest of the new stand at a minimal cost ?");
    	System.out.println("     What is the best way to build a new road in order to have a minimal envoronmental impact ?");
    	System.out.println();
    	System.out.println("The data must be stored in a text file with this particular structure");
    	System.out.println("The first line must be the number of nodes in the network and the second line the number of arcs");
    	System.out.println("Other lines must be organized as \"from node\"   \"to node\"  \"cost\"");
    	System.out.println();
    }

    private static void addArc(String laneId, int sourceLocNo, int destLocNo,
            double duration, List<Vertex> nodes, List<Edge> edges) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
        edges.add(lane);
    }
}