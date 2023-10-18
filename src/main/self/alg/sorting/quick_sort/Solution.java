package self.alg.sorting.quick_sort;

/**
 * https://towardsdatascience.com/an-overview-of-quicksort-algorithm-b9144e314a72
 */
public class Solution {
    public int[] quickSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        _quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void _quickSort(int[] arr, int start, int end) {
        if (start < end) { // no need to sort array with length 1
            int pivot = partition(arr, start, end);

            _quickSort(arr, start, pivot - 1);
            _quickSort(arr, pivot + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) { // equal must have
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int tmp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = tmp;
        return i + 1;
    }
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
//    int partition(int arr[], int low, int high)
//    {
//        int pivot = arr[high];
//        int i = (low-1); // index of smaller element
//        for (int j=low; j<high; j++)
//        {
//            // If current element is smaller than or
//            // equal to pivot
//            if (arr[j] <= pivot)
//            {
//                i++;
//
//                // swap arr[i] and arr[j]
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//
//        // swap arr[i+1] and arr[high] (or pivot)
//        int temp = arr[i+1];
//        arr[i+1] = arr[high];
//        arr[high] = temp;
//
//        return i+1;
//    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
//    void sort(int arr[], int low, int high)
//    {
//        if (low < high)
//        {
//            /* pi is partitioning index, arr[pi] is
//              now at right place */
//            int pi = partition(arr, low, high);
//
//            // Recursively sort elements before
//            // partition and after partition
//            sort(arr, low, pi-1);
//            sort(arr, pi+1, high);
//        }
//    }
}
