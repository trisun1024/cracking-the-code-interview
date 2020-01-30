public class MinimalBST {

    // Given a sorted array with unique integer elements, write an algorithm to create a binary search tree
    // with minimal height.

    public TreeNode createMinimalBST(int[] arr) {
        return helper(arr, 0, arr.length - 1);
    }

    private TreeNode helper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode n = new TreeNode(mid / 2);
        n.left = helper(arr, start, mid - 1);
        n.right = helper(arr, mid + 1, end);
        return n;
    }

    // basic idea is using the binary search to split the array into two parts
}
