import java.util.Arrays;

public class CheckPermutation {

    // Given two strings, write a method to decide if one is a permutations of the other
    // Solution 1 sort the strings
    public boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    private String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    // Solution 2 check if the two string have identical character counts
    public boolean permutationII(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] chars = new int[128];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i) - 'a']--;
            if (chars[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
