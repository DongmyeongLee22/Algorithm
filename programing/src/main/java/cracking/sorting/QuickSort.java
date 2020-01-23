package cracking.sorting;

import java.util.Arrays;

public class QuickSort {


    public void quickSort(int[] arr) {
        System.out.println();
        print(arr);
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int index = getIndex(arr, start, end);
            quickSort(arr, start, index - 1);
            quickSort(arr, index + 1, end);
        }
    }

    /*


    1 1 2 2 4 4 6 6 7 7
    *4*, 6, 1, 2, 7 ,4 ,2, 1, 7, 2
    *4*, 2, 1, 2, 7 ,4 ,2, 1, 7, 6
    *4*, 2, 1, 2, 1 ,4 ,2, 7, 7, 6
    *4*, 2, 1, 2, 1 ,2 ,4, 7, 7, 6

    *2*, 2, 1, 2, 1 / 4 / ,4, 7, 7, 6
    *2*, 2, 1, 2, 1 / 4 / ,4, 7, 7, 6
    *2*, 1, 1, 2, 2 / 4 /,4, 7, 7, 6
    *2*, 1, 1, 2, 2 / 4 /,4, 7, 7, 6

    *1*, 1, 2, 2, 2 / ,4 / 4, 7, 7, 6
    *1*, 1, 2, 2, 2 / ,4 / 4, 7, 7, 6
    *1*, 1, 2, 2, 2 / ,4 / 4, 7, 7, 6

    *3*, 1 ,2 ,6, 7, 8, 0 , 12, 11
    *3*, 1 ,2 ,0, 7, 8, 6 , 12, 11
    *0*, 1 ,2 /3/ 7, 8, 6 , 12, 11
    *0*, 1 ,2 /3/ 7, 8, 6 , 12, 11
    *0*, 1 ,2 /3/ 7, 6, 8 , 12, 11
    *0*, 1 ,2 /3/ 6, / 7 /, 8 , 12, 11
    *0*, 1 ,2 /3/ 6, / 7 /, 8 , 12, 11
    *0*, 1 ,2 /3/ 6, / 7 /, 8 , 12, 11
    *0*, 1 ,2 /3/ 6, / 7 /, 8 , 12, 11

     */

    private int getIndex(int[] arr, int start, int end){
        int pivot = arr[start];
        int left = start + 1;
        int right = end;

        while (left <= right){

            while (left <= end && arr[left] < pivot) left++;
            while (right >= start && arr[right] > pivot) right--;

            if (left <= right){
                swap(arr, left, right);
                print(arr);
                left++;
                right--;
            }
        }

        swap(arr, start,right);
        return right;
    }

    private void print(int[] arr) {
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    /*
    private void quickSort(int[] arr, int start, int end) {
        int index = getIndex(arr, start, end);

        if (start < index - 1) {
            quickSort(arr, start, index - 1);
        }

        if (end > index) {
            quickSort(arr, index, end);
        }
    }

    private int getIndex(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;

            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }
*/

    /**
     public void quickSort(int[] arr) {
     System.out.print("시작 원소: ");print(arr);
     quickSort(arr, 0, arr.length - 1);
     }

     private void quickSort(int[] arr, int start, int end) {
     int index = getIndex(arr, start, end);
     System.out.println("index = " + index + " value: " + arr[index]);
     System.out.println();
     if (start < index -1){
     quickSort(arr, start, index - 1);
     }
     if (index < end){
     quickSort(arr, index, end);
     }
     }

     private int getIndex(int[] arr, int start, int end){
     int pivot = arr[(start + end) / 2];
     System.out.println("pivot: " + pivot);
     while (start <= end){
     while (arr[start] < pivot) start++;
     while (arr[end] > pivot) end--;

     if (start <= end){
     int temp = arr[start];
     arr[start] = arr[end];
     arr[end] = temp;
     start++;
     end--;
     System.out.print("값이 변경: ");print(arr);
     }
     }
     return start;
     }


     private void print(int[] arr) {
     IntStream.range(0, arr.length).forEach(i -> System.out.print(arr[i] + " "));
     System.out.println();
     }
     **/
}
