package GraphTraverser;

import Graph.Graph;
import Graph.Edge;

import java.util.*;

public class Dijkstra {

    // What do I need...

    // A graph to traverse
    Graph graph = null;

    // A priority queue to manage the edges based on their weights
    PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

    // Path table to keep track of the paths and weights
    PathTable pathTable = new PathTable();
    Map<String,List<Edge>> adjacencyMap = new HashMap<String,List<Edge>>();


    public Dijkstra(Graph graph) {

        this.graph = graph;

        // Initialize the adjacency map
        // This is to store edges that are connected to the node
        // {A=[], B=[], C=[]...}
        for(Edge edge: graph.getEdges()){

            if(!adjacencyMap.containsKey(edge.getSource())) {
                adjacencyMap.put(edge.getSource(), new ArrayList<Edge>());

            }

            if(!adjacencyMap.containsKey(edge.getDestination())){
                adjacencyMap.put(edge.getDestination(), new ArrayList<Edge>());
                priorityQueue.add(edge);
            }

            if(!priorityQueue.contains(edge)){

                priorityQueue.add(edge);

            }

        }

        // For each node in the adjacency map, we will add the edges that connect to its neighbours
        for(String node: adjacencyMap.keySet()){

            for(Edge edge: graph.getEdges()){


                // For an undirected graph, each edge should be represented in the adjacency list of both its source and its destination.
                // This means if you have an edge between A and B, both A's and B's adjacency lists should include that edge (or a corresponding edge in the opposite direction).
                if(edge.getSource().equals(node)) {
                    // If the edge's source matches the node, add it to the adjacency list
                    adjacencyMap.get(node).add(edge);
                }

                if(edge.getDestination().equals(node)) {
                    // If the edge's destination matches the node, add it to the adjacency list
                    adjacencyMap.get(node).add(edge);
                }

            }

        }


        System.out.println("Adjacency Map: " + adjacencyMap);
        System.out.println("Priority Queue: " + priorityQueue);

    }

    public void traverse(String source, String destination){

        // SET UP THE PATH TABLE
        for(String node: adjacencyMap.keySet()){

            if(node.equals(source)) {

                if(pathTable.getNodePath(node) == null) {
                    // If the node is not already in the path table, add it with a weight of 0 and no previous node
                    pathTable.addNodePath(new NodePath(node, 0, null));
                }


            }else{

                pathTable.addNodePath(new NodePath(node, Integer.MAX_VALUE, null));

            }

        }

        // Traversal begins here
        while(!priorityQueue.isEmpty()){

            // Get the edge with the minimum weight
            Edge currentEdge = priorityQueue.poll();

            // Get the source node of the current edge
            String currentNode = currentEdge.getSource();

            // Get the path information for the current node
            NodePath currentNodePath = pathTable.getNodePath(currentNode);

            // If we reached the destination, we can stop
            if(currentNode.equals(destination)) {
                System.out.println("Reached destination: " + destination);
                break;
            }

            List<Edge> listOfAdjacentEdges = adjacencyMap.get(currentNode);

            // Traverse through all edges connected to the current node
            for(Edge edge: listOfAdjacentEdges){

                // This is to avoid adding weights to nodes, which will wrap over to negative MAX_VALUE
                if (currentNodePath.getWeight() == Integer.MAX_VALUE){
                    continue;
                }

                System.out.println("Current Node " + currentNode + " : " + adjacencyMap.get(currentNode));

                // Calculate the new weight for the neighbour node
                int newWeight = currentNodePath.getWeight() + edge.getWeight();

                // Get path to neighbour node
                String neighbourNode = edge.getDestination();
                NodePath neighbourPath = pathTable.getNodePath(neighbourNode);


                // If the new weight is less than the existing weight, update it
                // and set the previous node to the current node
                if(newWeight < neighbourPath.getWeight()) {

                    neighbourPath.setWeight(newWeight);
                    neighbourPath.setPreviousNode(currentNode);
                    priorityQueue.add(edge); // Add the edge to the priority queue for further processing

                    // Update path table with the new weight
                    pathTable.getNodePath(edge.getDestination()).setWeight(newWeight);

                }

            }

            System.out.println("Path Table: \n" + pathTable.getPathTableAsString());


        }



    }

}
