package data_structures;

public class BinarySearchTree_m {

    public static void main(String[] args) {
        // Create a BinarySearchTree instance
        BinarySearchTree_l<Integer> bst = new BinarySearchTree_l<>();

        // Add elements to the tree
        System.out.println("Adding elements...");
        bst.add(11);
        bst.add(3);
        bst.add(15);
        bst.add(1);
        bst.add(5);
        bst.add(13);
        bst.add(17);

        // Check if elements exist
        System.out.println("\nChecking if elements exist...");
        System.out.println("Contains 3? " + bst.contains(3)); // true
        System.out.println("Contains 20? " + bst.contains(20)); // false

        // In-order traversal (should print elements in sorted order)
        System.out.println("\nIn-order traversal:");
        bst.inOrderTraversal(); // 1 3 5 11 13 15 17

        // Remove an element
        System.out.println("\n\nRemoving element 15...");
        bst.remove(15);

        // In-order traversal after removal
        System.out.println("In-order traversal after removal:");
        bst.inOrderTraversal(); // 1 3 5 11 13 17

        // Adding another element
        System.out.println("\n\nAdding element 9...");
        bst.add(9);

        // In-order traversal after adding
        System.out.println("In-order traversal after adding:");
        bst.inOrderTraversal(); // 1 3 5 9 11 13 17
    }
}

