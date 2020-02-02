public class BinaryToString {

    // Given a real number between 0 and 1 that is passed in as a double, print the binary representation.
    // If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR".

    public String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        while (num > 0) {
            if (sb.length() >= 32) {
                return "ERROR";
            }
            double r = num * 2;
            if (r >= 1) {
                sb.append(1);
                num = r - 1;
            } else {
                sb.append(0);
                num = r;
            }
        }
        return sb.toString();
    }

    public String printBinaryII(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder();
        double frac = 0.5;
        sb.append(".");
        while (num > 0) {
            if (sb.length() > 32) {
                return "ERROR";
            }
            if (num >= frac) {
                sb.append(1);
                num -= frac;
            } else {
                sb.append(0);
            }
            frac /= 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BinaryToString sol = new BinaryToString();
        System.out.println(sol.printBinary(0.5));
        System.out.println(sol.printBinaryII(0.5));
    }
}
