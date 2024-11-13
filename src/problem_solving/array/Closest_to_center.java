package problem_solving.array;

import java.util.*;
// https://leetcode.com/problems/k-closest-points-to-origin/

public class Closest_to_center {

    public int[][] kClosest(int[][] points, int k) {
        // PriorityQueue to store the k closest points as a max-heap
        PriorityQueue<Map.Entry<Integer, int[]>> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getKey(), a.getKey()) // Reverse order for max-heap
        );// Compare distances (reverse order for max-heap)

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            // Calculate distance from origin
            int distance = x * x + y * y;

            // Add the distance and point to the PriorityQueue
            maxHeap.offer(Map.entry(distance, point));

            // If the size exceeds k, remove the point with the largest distance
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Prepare the result array
        int[][] ans = new int[k][2];
        int index = 0;

        while (!maxHeap.isEmpty()) {
            ans[index++] = maxHeap.poll().getValue();
        }

        return ans;
    }

    // public int[][] kClosest(int[][] points, int k) {
    //     List<Map.Entry<Double, int[]>> distances = new ArrayList<>();

    //     for (int i = 0; i < points.length; i++) {
    //         int x = points[i][0];
    //         int y = points[i][1];

    //         double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    //         distances.add(Map.entry(distance, new int[]{x, y}));
    //     }

    //     // Sort by distance (ascending)
    //     distances.sort(Comparator.comparingDouble(Map.Entry::getKey));

    //     // Prepare the result array for the k closest points
    //     int[][] ans = new int[k][2];
    //     for (int i = 0; i < k; i++) {
    //         ans[i] = distances.get(i).getValue(); // Get the [x, y] point
    //     }

    //     return ans;
    // }
}
