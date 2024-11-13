package problem_solving.BinaryTree;
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

public class SortedArrayToBST{

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

 public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        return buildBST(nums, 0, nums.length -1);
    }
    public TreeNode buildBST(int[] nums, int start, int end) {
        // Base case: If the current subarray is invalid, return null
        if(start > end) return null;

        int midIndex = start + (end - start) / 2;

        TreeNode node = new TreeNode(nums[midIndex]);

        node.left = buildBST(nums, start, midIndex - 1);
        node.right = buildBST(nums, midIndex + 1, end);

        return node;

    }
}
