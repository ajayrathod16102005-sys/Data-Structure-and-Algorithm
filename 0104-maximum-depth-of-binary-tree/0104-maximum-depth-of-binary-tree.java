class Solution {
    public int maxDepth(TreeNode root) {

        // Empty tree
        if (root == null) {
            return 0;
        }

        // Find depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Current node adds 1
        return 1 + Math.max(leftDepth, rightDepth);
    }
}