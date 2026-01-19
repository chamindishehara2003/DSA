public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index
            int pi = partition(arr, low, high);
            
            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        // Choose pivot (using last element)
        int pivot = arr[high];
        
        // Index of smaller element
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    // Optimized Quick Sort with median-of-three pivot selection
    public static void optimizedQuickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        optimizedQuickSort(arr, 0, arr.length - 1);
    }
    
    private static void optimizedQuickSort(int[] arr, int low, int high) {
        // Use insertion sort for small arrays (optimization)
        if (high - low + 1 < 10) {
            insertionSort(arr, low, high);
            return;
        }
        
        if (low < high) {
            int pi = optimizedPartition(arr, low, high);
            optimizedQuickSort(arr, low, pi - 1);
            optimizedQuickSort(arr, pi + 1, high);
        }
    }
    
    private static int optimizedPartition(int[] arr, int low, int high) {
        // Median of three pivot selection
        int mid = low + (high - low) / 2;
        
        // Sort low, mid, high
        if (arr[mid] < arr[low]) swap(arr, low, mid);
        if (arr[high] < arr[low]) swap(arr, low, high);
        if (arr[high] < arr[mid]) swap(arr, mid, high);
        
        // Place median at high-1
        swap(arr, mid, high - 1);
        int pivot = arr[high - 1];
        
        int i = low;
        int j = high - 1;
        
        while (true) {
            while (arr[++i] < pivot);
            while (arr[--j] > pivot);
            
            if (i >= j) break;
            
            swap(arr, i, j);
        }
        
        swap(arr, i, high - 1);
        return i;
    }
    
    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
