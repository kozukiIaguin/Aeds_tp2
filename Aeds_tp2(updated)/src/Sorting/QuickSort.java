package Sorting;
import java.util.Random;

public class QuickSort {

    public int partition(Item[] arr, int low, int high, int[] counts) {
        Random rand = new Random();
        int randomIndex = low + rand.nextInt(high - low + 1);
        Utils.swap(arr, randomIndex, high);
        counts[1]++; // Counting swaps

        int pivot = arr[high].getValue();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            counts[0]++; // Counting comparisons
            if (arr[j].getValue() < pivot) {
                i++;
                Utils.swap(arr, i, j);
                counts[1]++; // Counting swaps
            }
        }

        Utils.swap(arr, i + 1, high);
        counts[1]++; // Counting swaps
        return i + 1;
    }

    public void quick_sort(Item[] arr, int low, int high) {
        int[] counts = {0, 0}; // counts[0] = comparisons, counts[1] = swaps
        if (low < high) {
            int pi = partition(arr, low, high, counts);
            quick_sort(arr, low, pi - 1);
            quick_sort(arr, pi + 1, high);
        }

        System.out.println("QuickSort - Comparisons: " + counts[0] + ", Swaps: " + counts[1]);
    }

    public void iterativeQuickSort(Item[] arr, int l, int h) {
        int[] counts = {0, 0};

        int[] stack = new int[h - l + 1];
        int top = -1;

        stack[++top] = l;
        stack[++top] = h;

        while (top >= 0) {
            h = stack[top--];
            l = stack[top--];

            int p = partition(arr, l, h, counts);

            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }

        System.out.println("IterativeQuickSort - Comparisons: " + counts[0] + ", Swaps: " + counts[1]);
    }

    public void insertionQuickSort(Item[] arr, int low, int high) {
        int[] counts = {0, 0};

        if (high - low + 1 <= 10) {
            InsertionSort.insertion_sort(arr);
        } else if (low < high) {
            int pi = partition(arr, low, high, counts);
            insertionQuickSort(arr, low, pi - 1);
            insertionQuickSort(arr, pi + 1, high);
        }

        System.out.println("InsertionQuickSort - Comparisons: " + counts[0] + ", Swaps: " + counts[1]);
    }

    public void three_median(Item[] arr) {
        int[] counts = {0, 0};
        three_median(arr, 0, arr.length - 1, counts);
        System.out.println("ThreeMedianQuickSort - Comparisons: " + counts[0] + ", Swaps: " + counts[1]);
    }

    private void three_median(Item[] arr, int start, int end, int[] counts) {
        if (start < end) {
            int q = median_partition(arr, start, end, counts);
            three_median(arr, start, q - 1, counts);
            three_median(arr, q + 1, end, counts);
        }
    }

    public int median_partition(Item[] arr, int start, int end, int[] counts) {
        Random rand = new Random();
        int[] indices = new int[3];
        for (int i = 0; i < 3; i++) {
            indices[i] = start + rand.nextInt(end - start + 1);
        }

        if (arr[indices[1]].getValue() < arr[indices[0]].getValue()) {
            Utils.swap(arr, indices[0], indices[1]);
            counts[1]++; // Counting swaps
        }
        if (arr[indices[2]].getValue() < arr[indices[0]].getValue()) {
            Utils.swap(arr, indices[0], indices[2]);
            counts[1]++; // Counting swaps
        }
        if (arr[indices[2]].getValue() < arr[indices[1]].getValue()) {
            Utils.swap(arr, indices[1], indices[2]);
            counts[1]++; // Counting swaps
        }

        Utils.swap(arr, indices[1], end);
        counts[1]++; // Counting swaps
        int pivot = arr[end].getValue();
        int i = start - 1;

        for (int j = start; j < end; j++) {
            counts[0]++; // Counting comparisons
            if (arr[j].getValue() <= pivot) {
                i++;
                Utils.swap(arr, i, j);
                counts[1]++; // Counting swaps
            }
        }

        Utils.swap(arr, i + 1, end);
        counts[1]++; // Counting swaps
        return i + 1;
    }

    public void five_median(Item[] arr) {
        int[] counts = {0, 0};
        five_median(arr, 0, arr.length - 1, counts);
        System.out.println("FiveMedianQuickSort - Comparisons: " + counts[0] + ", Swaps: " + counts[1]);
    }

    private void five_median(Item[] arr, int start, int end, int[] counts) {
        if (start < end) {
            int q = five_median_partition(arr, start, end, counts);
            five_median(arr, start, q - 1, counts);
            five_median(arr, q + 1, end, counts);
        }
    }

    public int five_median_partition(Item[] arr, int start, int end, int[] counts) {
        Random rand = new Random();
        int[] indices = new int[5];
        for (int i = 0; i < 5; i++) {
            indices[i] = start + rand.nextInt(end - start + 1);
        }

        for (int i = 0; i < indices.length; i++) {
            for (int j = i + 1; j < indices.length; j++) {
                counts[0]++; // Counting comparisons
                if (arr[indices[i]].getValue() > arr[indices[j]].getValue()) {
                    Utils.swap(arr, indices[i], indices[j]);
                    counts[1]++; // Counting swaps
                }
            }
        }

        Utils.swap(arr, indices[2], end);
        counts[1]++; // Counting swaps
        int pivot = arr[end].getValue();
        int i = start - 1;

        for (int j = start; j < end; j++) {
            counts[0]++; // Counting comparisons
            if (arr[j].getValue() <= pivot) {
                i++;
                Utils.swap(arr, i, j);
                counts[1]++; // Counting swaps
            }
        }

        Utils.swap(arr, i + 1, end);
        counts[1]++; // Counting swaps
        return i + 1;
    }
}
