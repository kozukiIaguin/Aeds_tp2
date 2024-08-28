package Sorting;

public class SelectionSort {
    private int comparisonCount;
    private int swapCount;

    public SelectionSort() {
        this.comparisonCount = 0;
        this.swapCount = 0;
    }

    public void selection_sort(Item[] arr) {
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

    public int getComparisonCount() {
        return comparisonCount;
    }

    public int getSwapCount() {
        return swapCount;
    }
}
