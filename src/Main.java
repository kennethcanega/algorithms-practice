import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] unsortedArray = {1, 8, 9, 44, 12, 15, 19, 23, 29, 394, 92, 192, 99, 182, 94, 12, 42, 323, 42,
                822, 134, 442, 382, 992, 984, 8482, 1000, 10428, 2872, 7393, 92323, 9292, 1, 3, 4, 88};

        int[] sortedArray = {1, 4, 8, 12, 15, 19, 24, 34, 43, 55, 70,
                100, 104, 123, 142, 155, 183, 199, 200, 201, 202, 203, 204, 205, 206,
                207, 299, 300, 344, 351, 400, 450, 490, 491, 493, 494, 500,
                501, 502, 505, 599};

//        System.out.println("Linear Search: " + linearSearch(unsortedArray, 44));
//        System.out.println("Binary Search: " + binarySearch(sortedArray, 493));
//        System.out.println("Selection Sort: " + Arrays.toString(selectionSort(unsortedArray)));
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleSort(unsortedArray)));
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

    private static int[] selectionSort(int[] numbers) {
        int sortedIndex = 0;
        int size = numbers.length;
        int currentIndex = 0;
        int minIndex = 0;
        while (sortedIndex < size) {
            if (numbers[currentIndex] < numbers[minIndex]) {
                minIndex = currentIndex;
            }

            if (currentIndex == size - 1) {
                int tempValue = numbers[sortedIndex];
                numbers[sortedIndex] = numbers[minIndex];
                numbers[minIndex] = tempValue;
                sortedIndex++;
                currentIndex = sortedIndex;
                minIndex = sortedIndex;
                continue;
            }
            currentIndex++;
        }
        return numbers;
    }

    private static int[] bubbleSort(int[] numbers) {
        int sorted = numbers.length;
        int leftIndex = 0;
        int rightIndex = 1;
        while (sorted > 0) {
            if (numbers[leftIndex] > numbers[rightIndex]) {
                int temp = numbers[rightIndex];
                numbers[rightIndex] = numbers[leftIndex];
                numbers[leftIndex] = temp;
            }

            if (rightIndex == sorted - 1 || leftIndex == sorted - 1) {
                sorted--;
                leftIndex = 0;
                rightIndex = 1;
                continue;
            }
            leftIndex++;
            rightIndex++;
        }
        return numbers;
    }
}