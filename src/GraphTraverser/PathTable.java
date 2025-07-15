package GraphTraverser;

import java.util.ArrayList;
import java.util.List;

// PathTable class to manage the paths during graph traversal
public class PathTable {

    List<NodePath> pathTable = new ArrayList<>();

    public PathTable() {
        // Initialize the path table if needed
    }

    public void addNodePath(NodePath nodePath) {

        pathTable.add(nodePath);

    }

    public NodePath getNodePath(String node){

        for (NodePath nodePath : pathTable) {

            String currentNode = nodePath.getNode();

            if(currentNode != null && currentNode.equals(node)) {
                return nodePath;
            }
        }

        return null; // Return null if the node is not found

    }

    public String getPathTableAsString() {
        StringBuilder sb = new StringBuilder();
        for (NodePath nodePath : pathTable) {
            sb.append(nodePath.getNode())
              .append(" (Weight: ")
              .append(nodePath.getWeight())
              .append(", Previous: ")
              .append(nodePath.getPreviousNode())
              .append(")\n");
        }
        return sb.toString();
    }


}
