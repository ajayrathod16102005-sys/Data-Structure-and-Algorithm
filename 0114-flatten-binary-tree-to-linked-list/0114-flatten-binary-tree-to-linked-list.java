class Solution {
    public void flatten(TreeNode root) {

        TreeNode current = root;

        while (current != null) {

            // If left subtree exists
            if (current.left != null) {

                // Find the rightmost node of left subtree
                TreeNode predecessor = current.left;

                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                // Connect original right subtree
                // to the rightmost node
                predecessor.right = current.right;

                // Move left subtree to right
                current.right = current.left;

                // Remove left child
                current.left = null;
            }

            // Move to next node
            current = current.right;
        }
    }
}