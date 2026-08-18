class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // Both are null
        if (left == null && right == null) {
            return true;
        }

        // One is null, other is not
        if (left == null || right == null) {
            return false;
        }

        // Values must be equal
        if (left.val != right.val) {
            return false;
        }

        // Check mirror condition
        return isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}