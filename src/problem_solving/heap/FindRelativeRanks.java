package problem_solving.heap;
import java.util.*;

public class FindRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        // PriorityQueue to store value and index, sorted by value in descending order
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < score.length; i++) {
            pq.add(new int[] {score[i], i});
        }

        String[] result = new String[score.length];
        int rank = 1;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int index = curr[1];

            result[index] = placeToStr(rank++);
        }

        return result;
    }

    private static String placeToStr(int place) {
        return switch (place) {
            case 1 -> "Gold Medal";
            case 2 -> "Silver Medal";
            case 3 -> "Bronze Medal";
            default -> place + "";
        };
    }
}
