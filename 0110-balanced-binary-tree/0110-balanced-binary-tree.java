class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        // Empty tree is balanced
        if (root == null) {
            return 0;
        }

        // Height of left subtree
        int leftHeight = height(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        // Height of right subtree
        int rightHeight = height(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        // Check balance condition
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return height of current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}