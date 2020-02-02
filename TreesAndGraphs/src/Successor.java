public class Successor {

    // Write an algorithm to find the "next" node of a given node in a binary search tree. You may assume
    // that each node has a link to its parent

    public Node inorderSucc(Node root) {
        if (root == null) {
            return null;
        }
        if (root.right != null) {
            return leftMostChild(root.right);
        } else {
            Node cur = root;
            Node par = cur.parent;
            while (par != null && par.left != cur) {
                cur = par;
                par = par.parent;
            }
            return par;
        }
    }

    private Node leftMostChild(Node root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node parent;

        Node(int val) {
            this.val = val;
            left = null;
            right = null;
            parent = null;
        }
    }
}
