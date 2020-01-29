public class StringCompression {

    // Implement a method to perform basic string compression using the counts of repeated characters.

    // use StringBuilder
    public String compress(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i));
                sb.append(count);
                count = 0;
            }
        }
        return sb.toString();
    }
}
