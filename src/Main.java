public class Main {
    public static void main(String[] args) {
        int[] unsortedArray = {1, 8, 9, 44, 12, 15, 19, 23};
        int[] sortedArray = {1, 4, 8, 12, 15, 19, 24, 34, 43, 55, 70,
                100, 104, 123, 142, 155, 183, 199, 200, 201, 202, 203, 204, 205, 206,
                207, 299, 300, 344, 351, 400, 450, 490, 491, 493, 494, 500,
                501, 502, 505, 599};

        System.out.println("Linear Search: " + linearSearch(unsortedArray, 44));
        System.out.println("Binary Search: " + binarySearch(sortedArray, 493));
    }


    private static boolean linearSearch(int[] numbers, int search) {
        for (int number : numbers) {
            if (search == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] numbers, int search) {
        return doBinarySearch(numbers, numbers.length / 2, search);
    }

    private static boolean doBinarySearch(
            int[] numbers,
            int index,
            int search
    ) {
        if (index >= numbers.length) {
            return false;
        }

        int midValue = numbers[index];
        if (midValue == search) {
            return true;
        }

        if (midValue > search) {
            int[] partitioned = partition(numbers, 0, index);
            return doBinarySearch(partitioned, partitioned.length / 2, search);
        }
        int[] partitioned = partition(numbers, index, numbers.length);
        return doBinarySearch(partitioned, partitioned.length / 2, search);
    }

    private static int[] partition(int[] numbers, int start, int end) {
        int[] partitioned = new int[(end - start)];
        for (int i = 0; start < end; i++) {
            partitioned[i] = numbers[start++];
        }
        return partitioned;
    }
}