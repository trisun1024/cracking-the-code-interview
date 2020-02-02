import java.util.Random;

public class RandomNode {

    // You are implementing a binary search tree class from scratch, which, in addition to insert, find,
    // and delete, has a method getRandomNode() which returns a random node from the tree. All nodes should
    // be equally likely to be chosen. Design and implement an algorithm for getRandomNode.

    // Time O(log(N))
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int size = 0;

        TreeNode(int v) {
            this.val = v;
            this.size = 1;
        }

        public TreeNode getRandomNode() {
            int leftSize = left == null ? 0 : left.size();
            Random random = new Random();
            int index = random.nextInt(size);
            if (index < leftSize) {
                return left.getRandomNode();
            } else if (index == leftSize) {
                return this;
            } else {
                return right.getRandomNode();
            }
        }

        public void insertInOrder(int val) {
            if (val <= this.val) {
                if (left == null) {
                    left = new TreeNode(val);
                } else {
                    left.insertInOrder(val);
                }
            } else {
                if (right == null) {
                    right = new TreeNode(val);
                } else {
                    right.insertInOrder(val);
                }
            }
            size++;
        }

        public int size() {
            return this.size;
        }

        public int getVal() {
            return this.val;
        }

        public TreeNode find(int v) {
            if (this.val == v) {
                return this;
            } else if (v <= this.val) {
                return left != null ? left.find(v) : null;
            } else if (v > this.val) {
                return right != null ? right.find(v) : null;
            }
            return null;
        }
    }

    //

}
