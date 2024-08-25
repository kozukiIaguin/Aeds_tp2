package Sorting;

public class InsertionSort {
    public static void insertion_sort(Item[] arr){
        int comparisonCount = 0;
        int swapCount = 0;

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i].getValue();
            int j = i - 1;

            while (j >= 0 && arr[j].getValue() > key) {
                comparisonCount++; // Counting comparisons
                Utils.swap(arr, j + 1, j);
                swapCount++; // Counting swaps
                j -= 1;
            }
            if (j >= 0) comparisonCount++; // Counting the comparison that failed in the while loop
        }

        System.out.println("InsertionSort - Comparisons: " + comparisonCount + ", Swaps: " + swapCount);
    }
}
