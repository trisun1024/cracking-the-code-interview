public class ValidateBST {

    // Implement a function to check if a binary tree is a binary search tree

    public boolean checkBST(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, int left, int right) {
        if (root == null) {
            return true;
        }
        if (root.val < left || root.val > right) {
            return false;
        }
        return checkBST(root.left, left, root.val - 1) && checkBST(root.right, root.val + 1, right);
    }
}
