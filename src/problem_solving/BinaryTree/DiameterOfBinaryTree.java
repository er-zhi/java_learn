package problem_solving.BinaryTree;

public class DiameterOfBinaryTree {
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
     }
    private int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calcMaxDepth(root, 0);
        return maxDepth;
    }

    public int calcMaxDepth(TreeNode node, int currD) {
        if (node == null) return currD;

        int leftD = calcMaxDepth(node.left, currD);
        int rightD = calcMaxDepth(node.right, currD);

        currD = leftD + rightD;

        maxDepth = Math.max(currD, maxDepth);

        return 1 + Math.max(leftD, rightD);
    }
}
/**
 Time Complexity: O(n)
 Reason: Each of the n nodes is visited once.
 Operations: Constant time operations at each node.
 Space Complexity: O(h)
 Reason: Maximum depth of recursion is the height h of the tree.
 Best Case: O(log n) for a balanced tree.
 Worst Case: O(n) for a completely unbalanced tree.
 */

