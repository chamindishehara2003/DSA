/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Chamindi
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

     public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("Original array: ");
        printArray(arr);
        
        insertionSort(arr);
        
        System.out.print("Sorted array (insertion): ");
        printArray(arr);
    }
}