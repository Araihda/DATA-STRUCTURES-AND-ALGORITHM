package ALGORITHMS;

public class Searching {


    public static int linearSearch(double[] array, double target) {
        if (array == null || array.length == 0) {
            System.out.println("Empty or null array. Nothing to search.");
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }

        return -1;
    }


    public static int binarySearch(double[] array, double target) {
        if (array == null || array.length == 0) {
            System.out.println("Empty or null array. Nothing to search.");
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return -1;
    }


    public static String getTimeComplexity(String searchName) {
        if (searchName.equalsIgnoreCase("linear")) {
            return "Time Complexity: O(n) — checks one by one";
        } else if (searchName.equalsIgnoreCase("binary")) {
            return "Time Complexity: O(log n) — super fast but needs sorted data";
        }

        return "Time Complexity: Unknown";
    }
}
