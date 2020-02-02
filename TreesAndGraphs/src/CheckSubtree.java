public class CheckSubtree {

    // T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an algorithm to
    // determine if T2 is a subtree of T1.

    // simple approach
    // Time O(N*M) Space O(N+M)
    public boolean containsTree(TreeNode n1, TreeNode n2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        getOrderString(n1, sb1);
        getOrderString(n2, sb2);
        return sb1.indexOf(sb2.toString()) != -1;
    }

    private void getOrderString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("X");
            return;
        }
        sb.append(root.val + " ");
        getOrderString(root.left, sb);
        getOrderString(root.right, sb);
    }

    // alternative approach
    // Time O(N*M) Space O(log(N) + log(M))
    public boolean containsTreeII(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        return subTree(t1, t2);
    }

    private boolean subTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        } else if (t1.val == t2.val && matchTree(t1, t2)) {
            return true;
        }
        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    private boolean matchTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        } else {
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
        }
    }
}
