package problem_solving.Graph;

import java.util.*;

public class HashPath {

    public static boolean hasPathBFS(Map<String, List<String>> graph, String src, String dst) {
        // Queue for BFS
        Queue<String> queue = new LinkedList<>();
        // Set to track visited nodes
        Set<String> visited = new HashSet<>();

        // Start BFS from the source node
        queue.add(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            String currentNode = queue.poll();

            // If destination is found, return true
            if (currentNode.equals(dst)) {
                return true;
            }

            // Add neighbors to the queue
            for (String neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        // If no path was found
        return false;
    }

    public static boolean hasPathDFSRecursive(Map<String, List<String>> graph, String src, String dst, Set<String> visited) {
        // If the source is the destination, a path exists
        if (src.equals(dst)) {
            return true;
        }

        // Mark the source as visited
        visited.add(src);

        // Recur for all unvisited neighbors
        for (String neighbor : graph.getOrDefault(src, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (hasPathDFSRecursive(graph, neighbor, dst, visited)) {
                    return true;
                }
            }
        }

        // If no path was found
        return false;
    }

    // Wrapper function for recursive DFS
    public static boolean hasPathDFSRecursive(Map<String, List<String>> graph, String src, String dst) {
        return hasPathDFSRecursive(graph, src, dst, new HashSet<>());
    }

    public static boolean hasPathDFSIterative(Map<String, List<String>> graph, String src, String dst) {
        // Stack for DFS
        Stack<String> stack = new Stack<>();
        // Set to track visited nodes
        Set<String> visited = new HashSet<>();

        // Start DFS from the source node
        stack.push(src);

        while (!stack.isEmpty()) {
            String currentNode = stack.pop();

            // If destination is found, return true
            if (currentNode.equals(dst)) {
                return true;
            }

            // Mark the current node as visited
            if (!visited.contains(currentNode)) {
                visited.add(currentNode);

                // Add neighbors to the stack
                for (String neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        // If no path was found
        return false;
    }
}
