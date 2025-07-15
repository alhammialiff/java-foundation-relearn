//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import Graph.Graph;
import GraphTraverser.Dijkstra;

public class Main {
    public static void main(String[] args) {

        Graph myFirstGraph = new Graph(5);

        myFirstGraph.addEdge("A", "B", 4);
        myFirstGraph.addEdge("A","C", 3);
        myFirstGraph.addEdge("A","D", 2);
        myFirstGraph.addEdge("C","B", 1);
        myFirstGraph.addEdge("C","D", 5);
        myFirstGraph.addEdge("D","E", 3);
        myFirstGraph.addEdge("D","B", 4);

        Dijkstra dijkstra = new Dijkstra(myFirstGraph);
        dijkstra.traverse("A", "E");

    }

}