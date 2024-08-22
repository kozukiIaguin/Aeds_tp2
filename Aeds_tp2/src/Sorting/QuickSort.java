package Sorting;

public class QuickSort {
    public int partition(Item[] arr, int low, int high) {
        int pivot = arr[high].getValue();
        int i = low - 1;
        // go trought arr[] and move all smaller elements
        // on the left side
        for (int j = low; j < high; j++) {
            if (arr[j].getValue() < pivot) {
                i++;
                Utils.swap(arr, i, j);
            }
            // moves the pivot after smaller elements and returns his index
        }
        Utils.swap(arr, i + 1, high);
        return i + 1;

    }
    public void quick_sort(Item []arr,int low,int high){
        
       
        if (low<high) {
            int pi = partition(arr, low, high);//pi is the partition index

            //recursive call for smaller elements and greater/equal elements
            quick_sort(arr,low,pi-1);//smaller
            quick_sort(arr, pi+1, high);//greater
        }
       
    }
    
}
