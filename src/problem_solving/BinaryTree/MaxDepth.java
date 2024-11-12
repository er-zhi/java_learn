package problem_solving.BinaryTree;

public class MaxDepth {

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

        private int maximumDepth = 0;
        public int maxDepth(TreeNode root) {
            calcDepth(root, 0);
            return maximumDepth;
        }

        public int calcDepth(TreeNode node, int currDepth) {
            if(node == null) return 1;

            int left = calcDepth(node.left, currDepth);
            int right = calcDepth(node.right, currDepth);

            int currMaxDepth = Math.max(left, right);

            maximumDepth = Math.max(maximumDepth, currMaxDepth);

            return 1 + currMaxDepth;
    }
}
