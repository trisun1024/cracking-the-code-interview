public class PalindromePermutation {

    // Given a string, write a function to check if it is a permutation of a palindrome.

    // Solution 1 use a hash table to count how many times each character appears. Then, we iterate the
    // hash table and ensure that no more than one character has an odd count

    // Time O(N)
    public boolean isPermutationOfPalindrome(String s) {
        int[] table = buildCharFrequency(s);
        return checkMaxOneOdd(table);
    }

    private int[] buildCharFrequency(String s) {
        int[] table = new int[128];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        return table;
    }

    private boolean checkMaxOneOdd(int[] table) {
        boolean odd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (odd) {
                    return false;
                }
                odd = true;
            }
        }
        return odd;
    }

    // Solution 2 we check during the loop
    public boolean isPermutationOfPalindromeII(String s) {
        int countOdd = 0;
        int[] table = new int[128];
        for (char c : s.toCharArray()) {
            int x = c - 'a';
            table[x]++;
            if (table[x] % 2 == 1) {
                countOdd++;
            } else {
                countOdd--;
            }
        }
        return countOdd < 2;
    }

    // Solution 3 use bit vector instead of count
    public boolean isPermutationOfPalindromeIII(String s) {
        int bitVector = createBitVector(s);
        return checkAtMostOneBitSet(bitVector);
    }

    private int createBitVector(String s) {
        int bit = 0;
        for (char c : s.toCharArray()) {
            int x = c - 'a';
            bit = toggle(bit, x);
        }
        return bit;
    }

    private int toggle(int bit, int index) {
        if (index < 0) {
            return bit;
        }
        int mask = 1 << index;
        bit ^= mask;
        return bit;
    }

    private boolean checkAtMostOneBitSet(int bit) {
        return (bit & (bit - 1)) == 0;
    }

}
