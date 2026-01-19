public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }
    
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
       
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
   
        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);
        
        // Merge the temp arrays
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
       
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
       
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}