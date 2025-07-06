package GraphTraverser;

import Graph.Graph;
import Graph.Edge;

import java.util.*;

public class Dijkstra {

    // What do I need...
    Graph graph = null;
    PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
    PathTable pathTable = new PathTable();


    public Dijkstra(Graph graph) {

        // Initialize the Dijkstra algorithm with a graph
        this.graph = graph;

        // Initialize the path table with nodes from the graph
        for(Edge edge : graph.getEdges()) {

            String nodeToAdd = null;

            if(this.pathTable.getNodePath(String.valueOf(edge.getSource())) == null) {
                nodeToAdd = String.valueOf(edge.getSource());

                NodePath nodePath = new NodePath(nodeToAdd, Integer.MAX_VALUE, null);
                this.pathTable.addNodePath(nodePath);
            }

            if(this.pathTable.getNodePath(String.valueOf(edge.getDestination())) == null) {
                nodeToAdd = String.valueOf(edge.getDestination());

                NodePath nodePath = new NodePath(nodeToAdd, Integer.MAX_VALUE, null);
                this.pathTable.addNodePath(nodePath);
            }

        }

        System.out.println("Path Table: \n" + this.pathTable.getPathTableAsString());


    }

    public void traverse(String source, String destination){

        // Add PQ

        // Initialize the source node

        // Get the source node from the path table and set its weight to 0

        // Explore adjacent nodes from source node

        // ...

    }

}
