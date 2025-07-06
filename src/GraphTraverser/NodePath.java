package GraphTraverser;

// Node Path exist as an object to add into Path Table during traversal
// It will be used to edit weights and previous nodes during the Dijkstra algorithm traversal
public class NodePath {
    private String node = null;
    private int weight = -1; // Default weight set to max value
    private String previousNode = null;

    public NodePath(String node, int weight, String previousNode) {
        this.node = node;
        this.weight = weight;
        this.previousNode = previousNode;
    }

    // Getters and setters
    public String getNode() {

        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public int getWeight() {

        return weight;

    }

    public void setWeight(int weight) {

        this.weight = weight;

    }

    public String getPreviousNode() {

        return previousNode;

    }

    public void setPreviousNode(String previousNode) {
        this.previousNode = previousNode;
    }

}