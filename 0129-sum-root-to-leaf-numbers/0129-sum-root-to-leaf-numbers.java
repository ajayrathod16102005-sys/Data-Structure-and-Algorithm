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

    public int sumNumbers(TreeNode root)
     {

        return dfs(root, 0);
        
    }

    private int dfs(TreeNode node, int currentNumber) {

        // If node is null
        if (node == null) {
            return 0;
        }

        // Add current digit to the number
        currentNumber = currentNumber * 10 + node.val;

        // If this is a leaf node, return the number
        if (node.left == null && node.right == null) {
            return currentNumber;
        }

        // Find sum from left and right subtrees
        int leftSum = dfs(node.left, currentNumber);
        int rightSum = dfs(node.right, currentNumber);

        return leftSum + rightSum;
    }
}

