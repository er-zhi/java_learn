package problem_solving.Graph;

import java.util.*;

public class Traversal {
    //
    public static void main(String[] args) {
        // Define the adjacency list
        Map<String, List<String>> adjacencyList = new HashMap<>();
        adjacencyList.put("A", Arrays.asList("B", "C", "D"));
        adjacencyList.put("B", Arrays.asList("A", "D", "E"));
        adjacencyList.put("C", Arrays.asList("A", "D"));
        adjacencyList.put("D", Arrays.asList("A", "B", "C", "E"));
        adjacencyList.put("E", new ArrayList<>()); // E has no neighbors

        // Perform DFS and print nodes, recursive
        System.out.println("DFS Traversal:");
        dfsTraversal("A", adjacencyList, new HashSet<>());

        // Perform DFS and print nodes
        System.out.println("\nDFS Traversal (Iterative):");
        dfsIterative("A", adjacencyList);

        // Perform BFS and print nodes
        System.out.println("\nBFS Traversal:");
        bfs("A", adjacencyList);
    }

    // DFS function
    public static void dfsTraversal(String node, Map<String, List<String>> graph, Set<String> visited) {
        // Mark the current node as visited
        visited.add(node);
        // Print the current node
        System.out.print(node + " ");

        // Visit all the unvisited neighbors
        for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsTraversal(neighbor, graph, visited);
            }
        }
    }

    public static void dfsIterative(String startNode, Map<String, List<String>> graph) {
        // Stack for DFS
        Stack<String> stack = new Stack<>();
        // Set to track visited nodes
        Set<String> visited = new HashSet<>();

        // Start the DFS from the given node
        stack.push(startNode);

        while (!stack.isEmpty()) {
            // Get the top node from the stack
            String currentNode = stack.pop();

            // If the node has not been visited, process it
            if (!visited.contains(currentNode)) {
                // Mark the node as visited
                visited.add(currentNode);
                // Print the current node
                System.out.print(currentNode + " ");

                // Add all unvisited neighbors to the stack
                // We reverse the list to maintain order similar to recursion
                List<String> neighbors = graph.getOrDefault(currentNode, new ArrayList<>());
                Collections.reverse(neighbors);
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public static void bfs(String startNode, Map<String, List<String>> graph) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            String currNode = queue.poll();
            System.out.print(currNode + " ");

            for (String neighbor : graph.getOrDefault(currNode, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}
