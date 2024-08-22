import Sorting.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 10; // Length of the array
        Item[] arr;

        // Create instances of sorting algorithms
        BubbleSort bubble = new BubbleSort();
        InsertionSort insertion = new InsertionSort();
        SelectionSort selection = new SelectionSort();
        QuickSort quick = new QuickSort();

        // Test BubbleSort
        arr = generateRandomArray(n);
        System.out.println("Original array:");
        Utils.printArray(arr, n);
        bubble.bubble_sort(arr, n);
        System.out.println("Bubble sorted array:");
        Utils.printArray(arr, n);

        // Test InsertionSort
        arr = generateRandomArray(n);
        System.out.println("\nOriginal array:");
        Utils.printArray(arr, n);
        insertion.insertion_sort(arr);
        System.out.println("Insertion sorted array:");
        Utils.printArray(arr, n);

        // Test SelectionSort
        arr = generateRandomArray(n);
        System.out.println("\nOriginal array:");
        Utils.printArray(arr, n);
        selection.selection_sort(arr);
        System.out.println("Selection sorted array:");
        Utils.printArray(arr, n);

        // Test QuickSort (Standard)
        arr = generateRandomArray(n);
        System.out.println("\nOriginal array:");
        Utils.printArray(arr, n);
        quick.quick_sort(arr, 0, arr.length - 1);
        System.out.println("Quick sorted array:");
        Utils.printArray(arr, n);

        // Test QuickSort with median of three
        arr = generateRandomArray(n);
        System.out.println("\nOriginal array:");
        Utils.printArray(arr, n);
        quick.three_median(arr);
        System.out.println("Three median quick sorted array:");
        Utils.printArray(arr, n);

        // Test QuickSort with median of five
        arr = generateRandomArray(n);
        System.out.println("\nOriginal array:");
        Utils.printArray(arr, n);
        quick.five_median(arr);
        System.out.println("Five median quick sorted array:");
        Utils.printArray(arr, n);
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
