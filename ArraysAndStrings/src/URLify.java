public class URLify {

    // Write a method to replace all spaces in a string with '%20'. You may assume that the string has
    // sufficient space at the end to hold the additional characters, and that you are given the "true"
    // length of the string.

    // Solution using backward to fulfill the char array
    public void replaceSpaces(char[] array, int trueLength) {
        int numberOfSpaces = countOfChar(array, 0, trueLength, ' ');
        int newIndex = trueLength - 1 + numberOfSpaces * 2;
        if (newIndex + 1 < array.length) {
            array[newIndex + 1] = '\0';
        }
        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex--) {
            if (array[oldIndex] == ' ') {
                array[newIndex] = '0';
                array[newIndex - 1] = '2';
                array[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                array[newIndex] = array[oldIndex];
                newIndex--;
            }
        }
    }

    private int countOfChar(char[] array, int start, int end, char target) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (array[i] == target) {
                count++;
            }
        }
        return count;
    }
}
