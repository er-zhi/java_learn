package problem_solving.Search_DFS;

public class IsBalancedTree {

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

    public boolean isBalancedFast(TreeNode root) {
        return dfsFast(root) != -1;
    }

    private int dfsFast(TreeNode root) {
        if (root == null) {
            return 0; // Base case: height of null node is 0.
        }

        int leftHeight = dfsFast(root.left);
        if (leftHeight == -1) return -1; // If left subtree is unbalanced, propagate -1.

        int rightHeight = dfsFast(root.right);
        if (rightHeight == -1) return -1; // If right subtree is unbalanced, propagate -1.

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // If current node is unbalanced, return -1.
        }

        return 1 + Math.max(leftHeight, rightHeight); // Return height if balanced.
    }


    public boolean isBalanced(TreeNode root) {
            return dfs(root).balanced;
        }

        private Ans dfs(TreeNode root) {
            if (root == null) {
                return new Ans(true, 0); // Base case: a null tree is balanced with height 0.
            }

            Ans left = dfs(root.left);
            Ans right = dfs(root.right);

            boolean balanced = Math.abs(left.height - right.height) <= 1
                    && left.balanced
                    && right.balanced;

            int height = 1 + Math.max(left.height, right.height);

            return new Ans(balanced, height);
        }

        private static class Ans {
            boolean balanced;
            int height;

            Ans(boolean balanced, int height) {
                this.balanced = balanced;
                this.height = height;
            }
        }
    }
/*
Time complexity: O(n)
*/
