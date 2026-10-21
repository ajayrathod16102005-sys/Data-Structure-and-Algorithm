/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }

    private int findMax(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, findMax(node.left));
        int right = Math.max(0, findMax(node.right));

        int currentSum = node.val + left + right;

        maxSum = Math.max(maxSum, currentSum);

        return node.val + Math.max(left, right);
    }
}
