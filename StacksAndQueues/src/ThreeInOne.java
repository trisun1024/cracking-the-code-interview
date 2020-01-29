public class ThreeInOne {

    // Describe how you could use a single array to implement three stacks

    // implement a fixed array
    static class FixedMultiStack {
        private int numberOfStack = 3;
        private int stackCapacity;
        private int[] values;
        private int[] sizes;

        public FixedMultiStack(int stackSize) {
            this.stackCapacity = stackSize;
            this.values = new int[stackSize * numberOfStack];
            this.sizes = new int[numberOfStack];
        }

        // push
        public boolean push(int stackNum, int value) {
            if (isFull(stackNum)) {
                return false;
            }
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
            return true;
        }

        // pop
        public Integer pop(int stackNum) {
            if (isEmpty(stackNum)) {
                return null;
            }
            int topIndex = indexOfTop(stackNum);
            int val = values[topIndex];
            values[topIndex] = 0;
            sizes[stackNum]--;
            return val;
        }

        // peek
        public Integer peek(int stackNum) {
            if (isEmpty(stackNum)) {
                return null;
            }
            return values[indexOfTop(stackNum)];
        }

        public boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        }

        private boolean isFull(int stackNum) {
            return sizes[stackNum] == stackCapacity;
        }

        private int indexOfTop(int stackNum) {
            int offset = stackNum * stackCapacity;
            int size = sizes[stackNum];
            return offset + size - 1;
        }
    }

    // implement a flexible array

}
