import java.util.HashMap;
import java.util.Map;

public class PathsWithSum {

    // You can given a binary tree in which each node contains an integer value. Design an algorithm to
    // count the number of paths that sum to a given value. The path does not need to start or end at the
    // root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

    // Brute Force
    // Balanced tree Time O(N*log(N)) Worst case Time O(N^2)
    public int countPathsWithSum(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }
        int pathRoot = count(root, target, 0);
        int pathLeft = countPathsWithSum(root.left, target);
        int pathRight = countPathsWithSum(root.right, target);
        return pathRoot + pathLeft + pathRight;
    }

    private int count(TreeNode root, int target, int cur) {
        if (root == null) {
            return 0;
        }
        cur += root.val;
        int tot = 0;
        if (cur == target) {
            tot++;
        }
        tot += count(root.left, target, cur);
        tot += count(root.right, target, cur);
        return tot;
    }

    // Optimized
    // Time O(N) Space O(log(N))
    public int countPathsWithSumII(TreeNode root, int target) {
        return helper(root, target, 0, new HashMap<Integer, Integer>());
    }

    private int helper(TreeNode root, int target, int current, Map<Integer, Integer> pathCount) {
        if (root == null) {
            return 0;
        }
        current += root.val;
        int sum = current - target;
        int totalPaths = pathCount.getOrDefault(sum, 0);
        if (current == target) {
            totalPaths++;
        }
        incrementHashTable(pathCount, current, 1);
        totalPaths += helper(root.left, target, current, pathCount);
        totalPaths += helper(root.right, target, current, pathCount);
        incrementHashTable(pathCount, current, -1);
        return totalPaths;
    }

    private void incrementHashTable(Map<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
}
