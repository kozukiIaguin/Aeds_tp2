package Sorting;

public class SelectionSort {
    public void selection_sort(Item[] arr){
        int comparisonCount = 0;
        int swapCount = 0;

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                comparisonCount++; // Counting comparisons
                if (arr[min_index].getValue() > arr[j].getValue()) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                Utils.swap(arr, min_index, i);
                swapCount++; // Counting swaps
            }
        }

        System.out.println("SelectionSort - Comparisons: " + comparisonCount + ", Swaps: " + swapCount);
    }
}
