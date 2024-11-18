package problem_solving.heap;
import  java.util.*;

public class FindKthSmallest {
    // using custom heap
    public static int findKthSmallest(int[] nums, int k) {
        // Initialize a new Heap instance.
        Heap maxHeap = new Heap();

        // Iterate over every number in the input array.
        for (int num : nums) {
            // Insert current number into the heap.
            // Heap property is maintained after each insertion.
            maxHeap.insert(num);

            // Check if heap size exceeds 'k'.
            if (maxHeap.getHeap().size() > k) {
                // If size exceeds 'k', remove the largest number.
                // Heap property is maintained after each removal.
                maxHeap.remove();
            }
        }

        // At this point, the heap contains the smallest 'k' numbers.
        // The largest number in the heap is the kth smallest number in the array.
        // Therefore, we remove and return it.
        return maxHeap.remove();
    }
    // use java heap. Perfect solution
    public static int findKthSmallest1(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.add(num);

            // Ensure the heap size doesn't exceed k
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove largest element
            }
        }

        // Root of the heap contains the kth smallest element
        return maxHeap.peek();
    }

    // Dont do like that!
    public static int findKthSmallest2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all elements to the min-heap
        for (int num : nums) {
            minHeap.add(num);
        }

        // Poll the heap k-1 times to get to the kth smallest element
        for (int i = 1; i < k; i++) {
            minHeap.poll();
        }

        // The root of the heap is now the kth smallest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {7, 10, 4, 3, 20, 15};
        // 20,10,15,7,
        int k1 = 3;
        System.out.println("Test case 1:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallest(nums1, k1));
        System.out.println();

        // Test case 2
        int[] nums2 = {2, 1, 3, 5, 6, 4};
        int k2 = 2;
        System.out.println("Test case 2:");
        System.out.println("Expected output: 2");
        System.out.println("Actual output: " + findKthSmallest(nums2, k2));
        System.out.println();

        // Test case 3
        int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
        int k3 = 5;
        System.out.println("Test case 3:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallest(nums3, k3));
        System.out.println();


        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1:
            Expected output: 7
            Actual output: 7

            Test case 2:
            Expected output: 2
            Actual output: 2

            Test case 3:
            Expected output: 7
            Actual output: 7

        */
    }
}
