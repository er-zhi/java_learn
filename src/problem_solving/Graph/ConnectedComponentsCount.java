package problem_solving.Graph;

import java.util.*;

public class ConnectedComponentsCount {
    public static int connectedComponentsCount(Map<String, List<String>> graph) {
        Set<String> visited = new HashSet<>();
        int count = 0;

        for (String node : graph.keySet()) {
            if (traverse(graph, node, visited)) {
                count++;
            }
        }

        return count;
    }

    private static boolean traverse(Map<String, List<String>> graph, String currNode, Set<String> visited) {
        if (visited.contains(currNode)) return false;

        visited.add(currNode);

        for (String neighbor : graph.getOrDefault(currNode, new ArrayList<>())) {
            traverse(graph, neighbor, visited);
        }

        return true;
    }
}
