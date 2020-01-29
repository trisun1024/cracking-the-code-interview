public class IsUnique {

    // Implement an algorithm to determine if a string has all unique characters. What if you cannot use
    // additional data structures?

    // Time O(N) Space O(1)
    public boolean isUnique(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean[] visited = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (visited[val]) {
                return false;
            }
            visited[val] = true;
        }
        return true;
    }

    // Time O(N) Space O(1)
    // use bit operation
    public boolean isUniqueII(String s) {
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if ((k & (1 << val)) > 0) {
                return false;
            }
            k |= (1 << val);
        }
        return true;
    }

}
