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

    public List<TreeNode> generateTrees(int n) {
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {

        List<TreeNode> result = new ArrayList<>();

        // No nodes
        if (start > end) {
            result.add(null);
            return result;
        }

        // Try every number as root
        for (int root = start; root <= end; root++) {

            // Generate all possible left subtrees
            List<TreeNode> leftTrees = buildTrees(start, root - 1);

            // Generate all possible right subtrees
            List<TreeNode> rightTrees = buildTrees(root + 1, end);

            // Combine every left subtree with every right subtree
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode rootNode = new TreeNode(root);

                    rootNode.left = left;
                    rootNode.right = right;

                    result.add(rootNode);
                }
            }
        }

        return result;
    }
}