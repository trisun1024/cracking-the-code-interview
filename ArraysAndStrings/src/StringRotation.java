public class StringRotation {

    // Assume you have a method isSubstring which checks if one word is a substring of another. Given two
    // strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring.

    public boolean isRotation(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == len2 && len1 > 0) {
            String ss = s1 + s1;
            return isSubstring(ss, s2);
        }
        return false;
    }

    private boolean isSubstring(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                for (int j = 0; j < s2.length(); j++) {
                    if (s1.charAt(i + j) != s2.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
