//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {

        Graph myFirstGraph = new Graph(5);

        myFirstGraph.addEdge(0, 1, 5);
        myFirstGraph.addEdge(0, 2, 10);
        myFirstGraph.addEdge(0, 3, 2);
        myFirstGraph.addEdge(2, 1, 1);
        myFirstGraph.addEdge(2, 4, 5);
    }
}1