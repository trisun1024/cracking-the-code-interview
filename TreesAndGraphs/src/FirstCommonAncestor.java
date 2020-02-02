public class FirstCommonAncestor {

    // Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
    // Avoid storing additional nodes in a data structure.

    static class TreeNodeP {
        int val;
        TreeNodeP left;
        TreeNodeP right;
        TreeNodeP parent;

        TreeNodeP(int v) {
            this.val = v;
            left = null;
            right = null;
            parent = null;
        }
    }

    // With links to Parents
    // Time O(H) H - height
    public TreeNodeP commonAncestor(TreeNodeP p, TreeNodeP q) {
        int delta = depth(p) - depth(q);
        TreeNodeP first = delta > 0 ? q : p;
        TreeNodeP second = delta < 0 ? p : q;
        second = goUpBy(second, Math.abs(delta));
        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null : first;
    }

    private TreeNodeP goUpBy(TreeNodeP node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }
        return node;
    }

    private int depth(TreeNodeP node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }

    // Time O(N)
    public TreeNodeP commonAncestorII(TreeNodeP root, TreeNodeP p, TreeNodeP q) {
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        } else if (covers(p, q)) {
            return p;
        } else if (covers(q, p)) {
            return q;
        }
        TreeNodeP sibling = getSibling(p);
        TreeNodeP parent = p.parent;
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    private boolean covers(TreeNodeP root, TreeNodeP p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return covers(root.left, p) || covers(root.right, p);
    }

    private TreeNodeP getSibling(TreeNodeP root) {
        if (root == null || root.parent == null) {
            return null;
        }
        TreeNodeP parent = root.parent;
        return parent.left == root ? parent.right : parent.left;
    }

    // Without links to Parents
    // Time O(N) on a balanced tree
    public TreeNode commonAncestorIII(TreeNode root, TreeNode p, TreeNode q) {
        if (!belongs(root, p) || !belongs(root, q)) {
            return null;
        }
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        boolean pIsOnLeft = belongs(root.left, p);
        boolean qIsOnLeft = belongs(root.left, q);
        if (pIsOnLeft != qIsOnLeft) {
            return root;
        }
        TreeNode childSide = pIsOnLeft ? root.left : root.right;
        return helper(childSide, p, q);
    }

    private boolean belongs(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return belongs(root.left, p) || belongs(root.right, p);
    }

    // Optimized
    // belongs function search all nodes under root for p and q, including the nodes in each subtree. Then
    // it picks one of those subtrees and searches all of its nodes. Each subtree is searched over and over
    // again.

    public TreeNode commonAncestorIV(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = findLCA(root, p, q);
        if (lca == p) {
            return findNode(p, q) ? lca : null;
        } else if (lca == q) {
            return findNode(q, p) ? lca : null;
        }
        return lca;
    }

    private TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        // left and right is not null then lca is root
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    // find node p is in the Tree root or not
    private boolean findNode(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return findNode(root.left, p) || findNode(root.right, p);
    }
}
