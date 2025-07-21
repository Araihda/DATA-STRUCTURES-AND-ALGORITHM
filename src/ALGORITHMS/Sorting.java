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
            return "Time Complexity: O(n^2)";
        } else if (algorithmName.equalsIgnoreCase("insertion")) {
            return "Time Complexity: O(n^2) average, O(n) best case";
        }
        else if (algorithmName.equalsIgnoreCase("merge")) {
            return "Time Complexity: O(n log n)";
        }
        else if (algorithmName.equalsIgnoreCase("counting")) {
            return "Time Complexity: O(n + k)";
        }
        else if (algorithmName.equalsIgnoreCase("quick")) {
            return "Time Complexity: O(n log n) average, O(n^2) worst case";
        }
        else if (algorithmName.equalsIgnoreCase("heap")) {
            return "Time Complexity: O(n log n)";
        }
        else if (algorithmName.equalsIgnoreCase("shell")) {
            return "Time Complexity: O(n log n) best, O(n^2) worst";
        }
        else if (algorithmName.equalsIgnoreCase("bucket")) {
            return "Time Complexity: O(n + k)";
        }
        else if (algorithmName.equalsIgnoreCase("radix")) {
            return "Time Complexity: O(nk)";
        }


        return "Time Complexity: Unknown";
    }

    public static double[] quickSort(double[] array) {
        if (array == null) {
            System.out.println("Oops! No array found.");
            return null;
        }
        if (array.length == 0) {
            System.out.println("Array is empty. Nothing to sort.");
            return array;
        }
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }
    private static void quickSortHelper(double[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSortHelper(array, low, pi - 1);
            quickSortHelper(array, pi + 1, high);
        }
    }
    private static int partition(double[] array, int low, int high) {
        double pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        double temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static double[] heapSort(double[] array) {
        if (array == null) {
            System.out.println("Oops! No array found.");
            return null;
        }
        if (array.length == 0) {
            System.out.println("Array is empty. Nothing to sort.");
            return array;
        }
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            double temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
        return array;
    }
    private static void heapify(double[] array, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && array[l] > array[largest]) {
            largest = l;
        }
        if (r < n && array[r] > array[largest]) {
            largest = r;
        }
        if (largest != i) {
            double swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapify(array, n, largest);
        }
    }

    public static double[] shellSort(double[] array) {
        if (array == null) {
            System.out.println("Oops! No array found.");
            return null;
        }
        if (array.length == 0) {
            System.out.println("Array is empty. Nothing to sort.");
            return array;
        }
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                double temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
        return array;
    }

    public static double[] bucketSort(double[] array) {
        if (array == null) {
            System.out.println("Oops! No array found.");
            return null;
        }
        if (array.length == 0) {
            System.out.println("Array is empty. Nothing to sort.");
            return array;
        }
        int n = array.length;
        if (n <= 0) return array;
        @SuppressWarnings("unchecked")
        java.util.List<Double>[] buckets = new java.util.ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new java.util.ArrayList<>();
        }
        double max = array[0];
        double min = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }
        double range = (max - min) / n;
        if (range == 0) range = 1;
        for (int i = 0; i < n; i++) {
            int idx = (int)((array[i] - min) / range);
            if (idx == n) idx--;
            buckets[idx].add(array[i]);
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            java.util.Collections.sort(buckets[i]);
            for (double num : buckets[i]) {
                array[idx++] = num;
            }
        }
        return array;
    }

    public static int[] radixSort(int[] array) {
        if (array == null) {
            System.out.println("Oops! No array found.");
            return null;
        }
        if (array.length == 0) {
            System.out.println("Array is empty. Nothing to sort.");
            return array;
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
        return array;
    }
    private static void countingSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

}



