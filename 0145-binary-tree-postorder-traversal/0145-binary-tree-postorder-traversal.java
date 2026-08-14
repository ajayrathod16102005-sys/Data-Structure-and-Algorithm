class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        postorder(root, result);

        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        // Left
        postorder(root.left, result);

        // Right
        postorder(root.right, result);

        // Root
        result.add(root.val);
    }
}