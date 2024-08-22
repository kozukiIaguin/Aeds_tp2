import Sorting.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 10; // Length of the array
        Item[] arr;

        // Create instances of sorting algorithms
        BubbleSort bubble = new BubbleSort();
        InsertionSort insertion = new InsertionSort();
        SelectionSort selection = new SelectionSort();
        QuickSort quick = new QuickSort();

        // Menu for sorting algorithm choice
        System.out.println("Choose a sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Quick Sort (Standard)");
        System.out.println("5. Quick Sort (Median of Three)");
        System.out.println("6. Quick Sort (Median of Five)");
        System.out.println("7. Iterative Quick Sort");
        System.out.println("8- Insertion Quick Sort");
        System.out.print("Enter your choice (1-8):");
        int choice = scanner.nextInt();

        // Perform the chosen sorting algorithm
        switch (choice) {
            case 1:
                // Test BubbleSort
                arr = generateRandomArray(n);
                System.out.println("\nOriginal array:");
                Utils.printArray(arr, n);
                bubble.bubble_sort(arr, n);
                System.out.println("Bubble sorted array:");
                Utils.printArray(arr, n);
                break;

            case 2:
                // Test InsertionSort
                arr = generateRandomArray(n);
                System.out.println("\nOriginal array:");
                Utils.printArray(arr, n);
                insertion.insertion_sort(arr);
                System.out.println("Insertion sorted array:");
                Utils.printArray(arr, n);
                break;

            case 3:
                // Test SelectionSort
                arr = generateRandomArray(n);
                System.out.println("\nOriginal array:");
                Utils.printArray(arr, n);
                selection.selection_sort(arr);
                System.out.println("Selection sorted array:");
                Utils.printArray(arr, n);
                break;

            case 4:
                // Test QuickSort (Standard)
                arr = generateRandomArray(n);
                System.out.println("\nOriginal array:");
                Utils.printArray(arr, n);
                quick.quick_sort(arr, 0, arr.length - 1);
                System.out.println("Quick sorted array:");
                Utils.printArray(arr, n);
                break;

            case 5:
                // Test QuickSort with median of three
                arr = generateRandomArray(n);
                System.out.println("\nOriginal array:");
                Utils.printArray(arr, n);
                quick.three_median(arr);
                System.out.println("Three median quick sorted array:");
                Utils.printArray(arr, n);
                break;

            case 6:
                // Test QuickSort with median of five
                arr = generateRandomArray(n);
                System.out.println("\nOriginal array:");
                Utils.printArray(arr, n);
                quick.five_median(arr);
                System.out.println("Five median quick sorted array:");
                Utils.printArray(arr, n);
                break;

            case 7:
                // Test Iterative QuickSort
                arr = generateRandomArray(n);
                System.out.println("\nOriginal array:");
                Utils.printArray(arr, n);
                quick.iterativeQuickSort(arr, 0, n - 1);
                System.out.println("Iterative Quick Sort:");
                Utils.printArray(arr, n);
                break;
            case 8:
                arr = generateRandomArray(n);
                System.out.println("\nOriginal array:");
                Utils.printArray(arr, n);
                quick.insertionQuickSort(arr, 0, arr.length - 1);
                System.out.println("Insertion Quick sorted array:");
                Utils.printArray(arr, n);
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                break;
        }

        scanner.close();
    }

    // Generates an array of random Items with values between 1 and 100
    private static Item[] generateRandomArray(int size) {
        Random rand = new Random();
        Item[] arr = new Item[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Item(rand.nextInt(100) + 1);
        }
        return arr;
    }
}
