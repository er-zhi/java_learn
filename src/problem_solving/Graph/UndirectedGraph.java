package problem_solving.Graph;

import java.util.*;

public class UndirectedGraph {

    /*
   edges = [
        ["i", "j"],
        ["k", "i"],
        ["m", "k"],
        ["k", "l"],
        ["o", "n"]
    ]
    to adjacencyList
    {
        i: [j, k]
        j: [i]
        k: [i, m, l]
        m: [k]
        l: [k]
        o: [n]
        n: [o]
    }
    */

    public static void main(String[] args) {
        // Input edges
        List<List<String>> edges = Arrays.asList(
                Arrays.asList("i", "j"),
                Arrays.asList("k", "i"),
                Arrays.asList("m", "k"),
                Arrays.asList("k", "l"),
                Arrays.asList("o", "n")
        );

        // Convert edges to adjacency list
        Map<String, List<String>> adjacencyList = convertToAdjacencyList(edges);

        // Print the adjacency list
        System.out.println("Adjacency List:");
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static Map<String, List<String>> convertToAdjacencyList(List<List<String>> edges) {
        Map<String, List<String>> adjacencyList = new HashMap<>();

        for (List<String> edge : edges) {
            String node1 = edge.get(0);
            String node2 = edge.get(1);

            // Add node1 to the adjacency list of node2
            if (!adjacencyList.containsKey(node1)) {
                adjacencyList.put(node1, new ArrayList<>());
            }
            adjacencyList.get(node1).add(node2);

            // Add node2 to the adjacency list of node1 (because it's undirected)
            if (!adjacencyList.containsKey(node2)) {
                adjacencyList.put(node2, new ArrayList<>());
            }
            adjacencyList.get(node2).add(node1);
        }

        return adjacencyList;
    }
}
