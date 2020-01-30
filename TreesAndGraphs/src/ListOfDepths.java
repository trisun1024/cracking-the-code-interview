import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepths {

    // Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth.

    public List<List<TreeNode>> createLevelLinkedList(TreeNode root) {
        List<List<TreeNode>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> curLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curLevel.add(cur);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(new LinkedList<>(curLevel));
        }
        return res;
    }
}
