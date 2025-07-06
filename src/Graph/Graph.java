package Graph;

import java.util.ArrayList;
import java.util.List;


public class Graph {

    // Number of vertices in the graph
    private int vertices;
    // List to store edges as pairs of integers (source, destination)
    private List<Edge> edges = new ArrayList<>();

    // Constructor to initialize the graph with a given number of vertices
    public Graph(int vertices){

        this.vertices = vertices;

    }

    public void addEdge(String source, String destination, int weight){

//        if(source < 0 || source >= vertices || destination < 0 || destination >= vertices) {
//            throw new IllegalArgumentException("Source or destination vertex is out of bounds");
//        }

        this.edges.add(new Edge(source, destination, weight));

        System.out.println("Edges: " + java.util.Arrays.deepToString(this.edges.toArray()));

    }

    public List<Edge> getEdges() {

        return this.edges;

    }

    public List<Integer> getNodes(){

        List<Integer> verticesList = new ArrayList<>();

        for(int i = 0; i < this.vertices; i++){

            verticesList.add(i);

        }

        return verticesList;

    }


}
