class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        // Current node must be within the valid range
        if (root.val <= min || root.val >= max) {
            return false;
        }

        // Left subtree: values must be smaller
        // Right subtree: values must be greater
        return check(root.left, min, root.val) &&
               check(root.right, root.val, max);
    }
}