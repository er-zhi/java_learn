package data_structures;

public class Queue_m {
    public static void main(String[] args) {
        // Create an instance of Queue_l
        Queue_l<Integer> queue = new Queue_l<>();

        // Add elements to the queue
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        // Print the queue elements using for-each loop
        System.out.println("Queue elements:");
        for (int num : queue) {
            System.out.println(num);
        }

        // Peek at the front element
        System.out.println("Front element (peek): " + queue.peek());

        // Remove elements from the queue
        System.out.println("Removing elements:");
        while (!queue.isEmpty()) {
            System.out.println("Pulled: " + queue.pull());
        }

        // Attempt to pull from an empty queue (will throw exception)
        try {
            queue.pull();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}

