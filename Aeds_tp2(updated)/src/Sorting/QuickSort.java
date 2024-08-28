package Sorting;
import java.util.Random;

public class QuickSort {
    private int comparisonCount;
    private int swapCount;
 

    public QuickSort() {
        this.comparisonCount = 0;
        this.swapCount = 0;
    }

    public int partition(Item[] arr, int low, int high) {
        Random rand = new Random();
        int randomIndex = low + rand.nextInt(high - low + 1);
        Utils.swap(arr, randomIndex, high);
        swapCount++; // Counting swaps

        int pivot = arr[high].getValue();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisonCount++; // Counting comparisons
            if (arr[j].getValue() < pivot) {
                i++;
                Utils.swap(arr, i, j);
                swapCount++; // Counting swaps
            }
        }

        Utils.swap(arr, i + 1, high);
        swapCount++; // Counting swaps
        return i + 1;
    }

    public void quick_sort(Item[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quick_sort(arr, low, pi - 1);
            quick_sort(arr, pi + 1, high);
        }

        
    }

    public void iterativeQuickSort(Item[] arr, int l, int h) {
        int[] stack = new int[h - l + 1];
        int top = -1;

        stack[++top] = l;
        stack[++top] = h;

        while (top >= 0) {
            h = stack[top--];
            l = stack[top--];

            int p = partition(arr, l, h);

            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }

        
    }

    public void insertionQuickSort(Item[] arr, int low, int high) {
        if (high - low + 1 <= 10) {
            InsertionSort insertionSort = new InsertionSort();
            insertionSort.insertion_sort(arr);
        } else if (low < high) {
            int pi = partition(arr, low, high);
            insertionQuickSort(arr, low, pi - 1);
            insertionQuickSort(arr, pi + 1, high);
        }

        
    }

    public void three_median(Item[] arr) {
        three_median(arr, 0, arr.length - 1);
        
    }

    private void three_median(Item[] arr, int start, int end) {
        if (start < end) {
            int q = median_partition(arr, start, end);
            three_median(arr, start, q - 1);
            three_median(arr, q + 1, end);
        }
    }

    public int median_partition(Item[] arr, int start, int end) {
        Random rand = new Random();
        int[] indices = new int[3];
        for (int i = 0; i < 3; i++) {
            indices[i] = start + rand.nextInt(end - start + 1);
        }

        // Sorting the median indices
        if (arr[indices[1]].getValue() < arr[indices[0]].getValue()) {
            Utils.swap(arr, indices[0], indices[1]);
            swapCount++; // Counting swaps
        }
        if (arr[indices[2]].getValue() < arr[indices[0]].getValue()) {
            Utils.swap(arr, indices[0], indices[2]);
            swapCount++; // Counting swaps
        }
        if (arr[indices[2]].getValue() < arr[indices[1]].getValue()) {
            Utils.swap(arr, indices[1], indices[2]);
            swapCount++; // Counting swaps
        }

        Utils.swap(arr, indices[1], end);
        swapCount++; // Counting swaps
        int pivot = arr[end].getValue();
        int i = start - 1;

        for (int j = start; j < end; j++) {
            comparisonCount++; // Counting comparisons
            if (arr[j].getValue() <= pivot) {
                i++;
                Utils.swap(arr, i, j);
                swapCount++; // Counting swaps
            }
        }

        Utils.swap(arr, i + 1, end);
        swapCount++; // Counting swaps
        return i + 1;
    }

    public void five_median(Item[] arr) {
        five_median(arr, 0, arr.length - 1);

    }

    private void five_median(Item[] arr, int start, int end) {
        if (start < end) {
            int q = five_median_partition(arr, start, end);
            five_median(arr, start, q - 1);
            five_median(arr, q + 1, end);
        }
    }

    public int five_median_partition(Item[] arr, int start, int end) {
        Random rand = new Random();
        int[] indices = new int[5];
        for (int i = 0; i < 5; i++) {
            indices[i] = start + rand.nextInt(end - start + 1);
        }

        // Sorting the five median indices
        for (int i = 0; i < indices.length; i++) {
            for (int j = i + 1; j < indices.length; j++) {
                comparisonCount++; // Counting comparisons
                if (arr[indices[i]].getValue() > arr[indices[j]].getValue()) {
                    Utils.swap(arr, indices[i], indices[j]);
                    swapCount++; // Counting swaps
                }
            }
        }

        Utils.swap(arr, indices[2], end);
        swapCount++; // Counting swaps
        int pivot = arr[end].getValue();
        int i = start - 1;

        for (int j = start; j < end; j++) {
            comparisonCount++; // Counting comparisons
            if (arr[j].getValue() <= pivot) {
                i++;
                Utils.swap(arr, i, j);
                swapCount++; // Counting swaps
            }
        }

        Utils.swap(arr, i + 1, end);
        swapCount++; // Counting swaps
        return i + 1;
    }

    public int getComparisonCount() {
        return comparisonCount;
    }

    public int getSwapCount() {
        return swapCount;
    }
}
