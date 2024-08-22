package Sorting;
import java.util.Random;
public class QuickSort {
    
    // Partitions the array using a randomly chosen pivot
    public int partition(Item[] arr, int low, int high) {
        // Selects a random index for the pivot and swaps it with the last element
        Random rand = new Random();
        int randomIndex = low + rand.nextInt(high - low + 1);
        Utils.swap(arr, randomIndex, high);
    
        int pivot = arr[high].getValue();
        int i = low - 1;
    
        // Partitions the array with respect to the pivot
        for (int j = low; j < high; j++) {
            if (arr[j].getValue() < pivot) {
                i++;
                Utils.swap(arr, i, j);
            }
        }
    
        // Places the pivot in its correct position
        Utils.swap(arr, i + 1, high);
        return i + 1; // Returns the pivot's index
    }
    
    // Main QuickSort method
    public void quick_sort(Item[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // pi is the partition index

            // Recursively sorts elements before and after the partition
            quick_sort(arr, low, pi - 1); // Elements smaller than the pivot
            quick_sort(arr, pi + 1, high); // Elements greater than or equal to the pivot
        }
    }

    // Interative Quick Sort
    public void iterativeQuickSort(Item[] arr, int l, int h) {
        // Create a stack of Item objects
        Item[] stack = new Item[h - l + 1];
        for (int i = 0; i < stack.length; i++) {
            stack[i] = new Item();
        }

        // Initialize top of stack
        int top = -1;

        // Push initial values of l and h to stack
        stack[++top].setValue(l);
        stack[++top].setValue(h);

        // Keep popping from stack while it is not empty
        while (top >= 0) {
            // Pop h and l
            h = stack[top--].getValue();
            l = stack[top--].getValue();

            // Set pivot element at its correct position in sorted array
            int p = partition(arr, l, h);

            // If there are elements on the left side of pivot,
            // push left side to stack
            if (p - 1 > l) {
                stack[++top].setValue(l);
                stack[++top].setValue(p - 1);
            }

            // If there are elements on the right side of pivot,
            // push right side to stack
            if (p + 1 < h) {
                stack[++top].setValue(p + 1);
                stack[++top].setValue(h);
            }
        }
    }

    // Quicksort + Insertionsort
    public void insertionQuickSort(Item[] arr, int low, int high) {
        if (high - low + 1 <= 10) {
            InsertionSort.insertion_sort(arr);
        } else if (low < high) {
            int pi = partition(arr, low, high);
            insertionQuickSort(arr, low, pi - 1);
            insertionQuickSort(arr, pi + 1, high);
        }
    }
    
    // Initiates QuickSort using the median of three random elements as the pivot
    public void three_median(Item[] arr) {
        three_median(arr, 0, arr.length - 1);
    }
    
    // Recursive method to perform QuickSort with the median of three random elements
    private void three_median(Item[] arr, int start, int end) {
        if (start < end) {
            // Partitions the array using the median of three random elements
            int q = median_partition(arr, start, end);
            // Recursively sorts the partitions
            three_median(arr, start, q - 1);
            three_median(arr, q + 1, end);
        }
    }
    
    // Partitions the array using the median of three random elements as the pivot
    public int median_partition(Item[] arr, int start, int end) {
        Random rand = new Random();
    
        // Selects three random indices
        int[] indices = new int[3];
        for (int i = 0; i < 3; i++) {
            indices[i] = start + rand.nextInt(end - start + 1);
        }
    
        // Sorts the three values to find the median
        if (arr[indices[1]].getValue() < arr[indices[0]].getValue()) {
            Utils.swap(arr, indices[0], indices[1]);
        }
        if (arr[indices[2]].getValue() < arr[indices[0]].getValue()) {
            Utils.swap(arr, indices[0], indices[2]);
        }
        if (arr[indices[2]].getValue() < arr[indices[1]].getValue()) {
            Utils.swap(arr, indices[1], indices[2]);
        }
    
        // Places the median at the end to be used as the pivot
        Utils.swap(arr, indices[1], end);
        int pivot = arr[end].getValue();
        int i = start - 1;
    
        // Partitions the array with respect to the pivot
        for (int j = start; j < end; j++) {
            if (arr[j].getValue() <= pivot) {
                i++;
                Utils.swap(arr, i, j);
            }
        }
    
        // Places the pivot in its correct position
        Utils.swap(arr, i + 1, end);
        return i + 1; // Returns the pivot's index
    }
    
    // Initiates QuickSort using the median of five random elements as the pivot
    public void five_median(Item[] arr) {
        five_median(arr, 0, arr.length - 1);
    }
    
    // Recursive method to perform QuickSort with the median of five random elements
    private void five_median(Item[] arr, int start, int end) {
        if (start < end) {
            // Partitions the array using the median of five random elements
            int q = five_median_partition(arr, start, end);
            // Recursively sorts the partitions
            five_median(arr, start, q - 1);
            five_median(arr, q + 1, end);
        }
    }
    
    // Partitions the array using the median of five random elements as the pivot
    public int five_median_partition(Item[] arr, int start, int end) {
        Random rand = new Random();
    
        // Selects five random indices
        int[] indices = new int[5];
        for (int i = 0; i < 5; i++) {
            indices[i] = start + rand.nextInt(end - start + 1);
        }
    
        // Sorts the five values to find the median
        for (int i = 0; i < indices.length; i++) {
            for (int j = i + 1; j < indices.length; j++) {
                if (arr[indices[i]].getValue() > arr[indices[j]].getValue()) {
                    Utils.swap(arr, indices[i], indices[j]);
                }
            }
        }
    
        // Places the median at the end to be used as the pivot
        Utils.swap(arr, indices[2], end); // The median is the third value of the five sorted
        int pivot = arr[end].getValue();
        int i = start - 1;
    
        // Partitions the array with respect to the pivot
        for (int j = start; j < end; j++) {
            if (arr[j].getValue() <= pivot) {
                i++;
                Utils.swap(arr, i, j);
            }
        }
    
        // Places the pivot in its correct position
        Utils.swap(arr, i + 1, end);
        return i + 1; // Returns the pivot's index
    }
}
