package Sorting;

public class BubbleSort {

    private int comparisonCount;
    private int swapCount;

    public BubbleSort() {
        this.comparisonCount = 0;
        this.swapCount = 0;
    }

    public int[] bubbleSort(Item[] arr, int n) {

        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Traverse the array until n-i-1
            for (int j = 0; j < n - i - 1; j++) {
                // Compare the values using getValue()
                if (arr[j].getValue() > arr[j + 1].getValue()) {
                    comparisonCount++;
                    // Swap the elements using the swap method
                    Utils.swap(arr, j, j + 1);
                    swapped = true;
                    if (swapped) {
                        swapCount++;
                    }
                }
            }
        }
        // Convert the Item array to int[] (assuming each Item has a getValue() method)
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = arr[i].getValue();
        }
        return res;
    }

    public int getComparisonCount() {
        return comparisonCount;
    }

    public int getSwapCount() {
        return swapCount;
    }
}
