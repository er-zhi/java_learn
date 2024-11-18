package problem_solving.BinaryTree;
//https://leetcode.com/problems/symmetric-tree

public class IsSymmetric {

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

    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode p, TreeNode q) {
        // there are 3 base case
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        // Recursive call
        return compare(p.left, q.right) && compare(p.right, q.left);
    }

}
