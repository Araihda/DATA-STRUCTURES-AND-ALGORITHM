import java.util.Scanner;
import ALGORITHMS.Sorting;
import ALGORITHMS.Searching;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println(" Welcome to the Algorithm Application!");

        while (keepRunning) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Sorting");
            System.out.println("2. Searching");
            System.out.println("3. Exit");

            System.out.print("Enter your choice (1–3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleSorting(scanner);
                    break;
                case 2:
                    handleSearching(scanner);
                    break;
                case 3:
                    System.out.println(" Exiting program. Thank you for using the Algorithm App!");
                    keepRunning = false;
                    break;
                default:
                    System.out.println(" Invalid choice. Please enter 1, 2 or 3.");
            }
        }

        scanner.close();
    }

    //  Sorting handler
    private static void handleSorting(Scanner scanner) {
        System.out.println("\n Choose a sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Counting Sort (only for non-negative integers)");

        System.out.print("Enter your choice (1–5): ");
        int option = scanner.nextInt();

        if (option == 5) {
            System.out.print("How many numbers do you want to sort? ");
            int n = scanner.nextInt();
            int[] array = new int[n];

            System.out.println("Enter your numbers (integers only):");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            int[] sorted = Sorting.countingSort(array);
            System.out.println("Sorted array:");
            for (int num : sorted) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println(Sorting.getTimeComplexity("counting"));
        } else {
            System.out.print("How many numbers do you want to sort? ");
            int n = scanner.nextInt();
            double[] array = new double[n];

            System.out.println("Enter your numbers (decimals or whole numbers):");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextDouble();
            }

            double[] sorted = null;
            String algo = "";

            switch (option) {
                case 1:
                    sorted = Sorting.bubbleSort(array);
                    algo = "bubble";
                    break;
                case 2:
                    sorted = Sorting.selectionSort(array);
                    algo = "selection";
                    break;
                case 3:
                    sorted = Sorting.insertionSort(array);
                    algo = "insertion";
                    break;
                case 4:
                    sorted = Sorting.mergeSort(array);
                    algo = "merge";
                    break;
                default:
                    System.out.println("Invalid sorting option.");
                    return;
            }

            System.out.println("Sorted array:");
            for (double num : sorted) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println(Sorting.getTimeComplexity(algo));
        }
    }

    //  Searching handler
    private static void handleSearching(Scanner scanner) {
        System.out.println("\n🔍 Choose a searching algorithm:");
        System.out.println("1. Linear Search (works on any array)");
        System.out.println("2. Binary Search (array must be sorted)");

        System.out.print("Enter your choice (1 or 2): ");
        int option = scanner.nextInt();

        System.out.print("How many numbers are in your list? ");
        int n = scanner.nextInt();
        double[] array = new double[n];

        System.out.println("Enter your numbers:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextDouble();
        }

        System.out.print("What number do you want to search for? ");
        double target = scanner.nextDouble();

        int index = -1;
        String algo = "";

        switch (option) {
            case 1:
                index = Searching.linearSearch(array, target);
                algo = "linear";
                break;
            case 2:
                index = Searching.binarySearch(array, target);
                algo = "binary";
                break;
            default:
                System.out.println(" Invalid search option.");
                return;
        }

        if (index != -1) {
            System.out.println("Found " + target + " at index " + index);
        } else {
            System.out.println( target + " was not found in the array.");
        }

        System.out.println(Searching.getTimeComplexity(algo));
    }
}
