package problem_solving.BST;
import java.util.*;

public class BST_from_sorted_arr {

    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result =  new ArrayList<>();
        queue.add(currentNode);

        while(!queue.isEmpty()) {
            currentNode = queue.remove();
            result.add(currentNode.value);
            if(currentNode.left != null) queue.add(currentNode.left);
            if(currentNode.right != null) queue.add(currentNode.right);
        }

        return result;
    }

    public void sortedArrayToBST(int[] nums) {
        this.root = sortedArrayToBST(nums, 0, nums.length - 1);
    }
    private Node sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;

        Node node = new Node(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid -1);
        node.right = sortedArrayToBST(nums, mid +1, right);

        return node;
    }

    public void invert() {
        root = invertTree(root);
    }

    private Node invertTree(Node node) {
        if (node == null) return null;

        Node temp = invertTree(node.left);
        node.left = invertTree(node.right);
        node.right = temp;

        return node;
    }

    public Node getRoot() {
        return root;
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderHelper(this.root, result);
        return result;
    }

    private void inorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.value);
        inorderHelper(node.right, result);
    }

    public boolean isBalanced() {
        return height(this.root) != -1;
    }

    private int height(Node node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(node.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

