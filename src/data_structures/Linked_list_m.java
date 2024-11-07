package data_structures;

public class Linked_list_m {
    public static void main(String[] args) {
        // Create an instance of Linked_list_l
        Linked_list_l<Integer> list = new Linked_list_l<>();

        // Add elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println("List after adding elements: " + list);

        // Peek at the first and last elements
        System.out.println("First element: " + list.peekFirst());
        System.out.println("Last element: " + list.peekLast());

        // Remove elements
        list.removeFirst();
        System.out.println("List after removing first element: " + list);

        list.removeLast();
        System.out.println("List after removing last element: " + list);

        // Check if the list contains a specific element
        System.out.println("List contains 20: " + list.contains(20));
        System.out.println("List contains 40: " + list.contains(40));

        // Use the iterator to traverse the list
        System.out.print("List elements using iterator: ");
        for (int value : list) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Remove an element by index
        list.removeAt(0);
        System.out.println("List after removing element at index 0: " + list);

        // Clear the list
        list.clear();
        System.out.println("List after clearing: " + list);
    }
}

