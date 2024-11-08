package data_structures;
/*

             11
           /   \
          3     15
         / \    / \
        1   5  13  17

     Summary of Time Complexities for Binary Search Tree Operations:

| Operation         | Best Case      | Worst Case     | Average Case    |
|-------------------|----------------|----------------|-----------------|
| Add               | O(log n)       | O(n)           | O(log n)        |
| Contains          | O(1)           | O(n)           | O(log n)        |
| Remove            | O(log n)       | O(n)           | O(log n)        |
| Find Min/Max      | O(1)           | O(n)           | O(log n)        |
| Traversal         | O(n)           | O(n)           | O(n)            |
| Height            | O(log n)       | O(n)           | O(log n)        |

*/


public class BinarySearchTree_l<T extends Comparable<T>> {

    private class Node {
        T data;
        Node left, right;

        Node(T data) {
            this.data = data;
        }
    }

    private Node root;

    // Add a new element to the tree
    public void add(T value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, T value) {
        if (current == null) {
            return new Node(value);
        }

        if (value.compareTo(current.data) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.data) > 0) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    // Check if the tree contains a specific value
    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node current, T value) {
        if (current == null) {
            return false;
        }

        if (value.compareTo(current.data) == 0) {
            return true;
        }

        return value.compareTo(current.data) < 0
                ? containsRecursive(current.left, value)
                : containsRecursive(current.right, value);
    }

    // Remove a value from the tree
    public void remove(T value) {
        root = removeRecursive(root, value);
    }

    private Node removeRecursive(Node current, T value) {
        if (current == null) {
            return null;
        }

        if (value.compareTo(current.data) == 0) {
            // Node to delete found

            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: one child
            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            // Case 3: two children
            T smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = removeRecursive(current.right, smallestValue);
            return current;

        } else if (value.compareTo(current.data) < 0) {
            current.left = removeRecursive(current.left, value);
        } else {
            current.right = removeRecursive(current.right, value);
        }
        return current;
    }

    private T findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    public void inOrderTraversal() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.data + " ");
            inOrderRecursive(node.right);
        }
    }
}
