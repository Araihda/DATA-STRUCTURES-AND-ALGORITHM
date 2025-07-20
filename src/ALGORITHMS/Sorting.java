package ALGORITHMS;

public class Sorting {
    public static double[] bubbleSort(double[] array) {
        // Check if the array is null
        if (array == null) {
            System.out.println("Oops! No array found.");
            return null;
        }

        // Check if the array is empty
        if (array.length == 0) {
            System.out.println("Array is empty. Nothing to sort.");
            return array;
        }

        // Bubble Sort starts here
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // Compare two numbers
                if (array[j] > array[j + 1]) {
                    // Swap them if the left one is bigger
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
       }

    public static double[] selectionSort ( double[] array){
            if (array == null) {
                System.out.println("Oops! No array found.");
                return null;
            }

            if (array.length == 0) {
                System.out.println("Array is empty. Nothing to sort.");
                return array;
            }

            int n = array.length;

            for (int i = 0; i < n - 1; i++) {
                // Assume the current index has the smallest value
                int minIndex = i;

                // Find the index of the smallest value from i to the end
                for (int j = i + 1; j < n; j++) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                }

                // Swap the smallest value with the first unsorted element
                if (minIndex != i) {
                    double temp = array[i];
                    array[i] = array[minIndex];
                    array[minIndex] = temp;
                }
            }

            return array;
        }


    public static double[] insertionSort(double[] array) {
        if (array == null) {
            System.out.println("Oops! No array found.");
            return null;
        }

        if (array.length == 0) {
            System.out.println("Array is empty. Nothing to sort.");
            return array;
        }

        // The real insertion sort logic starts here
        for (int i = 1; i < array.length; i++) {
            double current = array[i]; // The value we are going to insert
            int j = i - 1;

            // Move elements that are greater than current one position ahead
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];  // shift the number right
                j--;  // go back one index
            }

            // Insert the current value at its correct position
            array[j + 1] = current;
        }

        return array;
    }


    public static double[] mergeSort(double[] array) {
        if (array == null) {
            System.out.println("Oops! No array found.");
            return null;
        }

        if (array.length <= 1) {
            // Already sorted (0 or 1 item)
            return array;
        }

        // Split the array into two halves
        int mid = array.length / 2;

        double[] left = new double[mid];
        double[] right = new double[array.length - mid];

        // Copy data to left and right
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        // Recursively sort the left and right parts
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge the sorted parts
        return merge(left, right);
    }


    private static double[] merge(double[] left, double[] right) {
        double[] result = new double[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // Compare and merge elements
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Copy remaining elements
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }


    public static int[] countingSort(int[] array) {
        if (array == null) {
            System.out.println("Oops! No array found.");
            return null;
        }

        if (array.length == 0) {
            System.out.println("Array is empty. Nothing to sort.");
            return array;
        }


        int max = array[0];
        for (int num : array) {
            if (num < 0) {
                System.out.println("Counting sort does not support negative numbers.");
                return array;
            }
            if (num > max) {
                max = num;
            }
        }

        int[] count = new int[max + 1];

        // Count each element
        for (int num : array) {
            count[num]++;
        }

        // Rebuild the sorted array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                array[index++] = i;
                count[i]--;
            }
        }

        return array;
    }




    // Just returns the theoretical time complexity
    public static String getTimeComplexity(String algorithmName) {
        if (algorithmName.equalsIgnoreCase("bubble")) {
            return "Time Complexity: O(n^2)";
        } else if (algorithmName.equalsIgnoreCase("selection")) {
            return "Time Complexity: O(n^2) — but fewer swaps than bubble sort";
        } else if (algorithmName.equalsIgnoreCase("insertion")) {
            return "Time Complexity: O(n^2) average, but O(n) if the list is nearly sorted";
        }
        else if (algorithmName.equalsIgnoreCase("merge")) {
            return "Time Complexity: O(n log n) — very efficient even for large lists!";
        }
        else if (algorithmName.equalsIgnoreCase("counting")) {
            return "Time Complexity: O(n + k) — Fast but only for non-negative integers";
        }


        return "Time Complexity: Unknown";
    }

}



