package problem_solving.heap;
import java.util.*;

public class KthLargest {

    private int k;
    private PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>(); // Default min-heap behavior ((a, b)-> a - b);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        heap.add(val);
        if (heap.size() > k) {
            heap.poll(); // Remove smallest element
        }

        return heap.peek(); // The kth largest element
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
