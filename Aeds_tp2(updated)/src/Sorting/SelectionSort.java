package Sorting;

public class SelectionSort {
    public void selection_sort(Item[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min_index = i;
            for (int j = i+1; j < n; j++) {
                if (arr[min_index].getValue()>arr[j].getValue()) {
                    min_index=j;
                    Utils.swap(arr, min_index, i);
                }
            }
        }
       
    }
}
