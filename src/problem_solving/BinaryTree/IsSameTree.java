package problem_solving.BinaryTree;

public class IsSameTree {

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

    private boolean ans = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // recursive compare
        compare(p, q);

        return ans;
    }

    public void compare(TreeNode p, TreeNode q) {

        if (p == null && q == null) return;

        if (p == null || q == null) {
            ans = false;
            return;
        }

        if (p.val != q.val) {
            ans = false;
            return;
        };

        compare(p.left, q.left);
        compare(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        // Base cases
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        // Check current node values
        if (p.val != q.val) {
            return false;
        }

        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
