package problem_solving.BinaryTree;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
import java.util.*;

public class LevelOrder {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        traverse(root, 0, ans);
        return ans;
    }

    private void traverse(TreeNode node, int level, List<List<Integer>> ans) {
        if (node == null) return;

        // If we're at a new level we haven't seen before, add a new list
        if (ans.size() == level) ans.add(new ArrayList<>());

        // Add the current node's value to its corresponding level list
        ans.get(level).add(node.val);

        // Recurse on left and right children, incrementing the level
        traverse(node.left, level + 1, ans);
        traverse(node.right, level + 1, ans);
    }
}
