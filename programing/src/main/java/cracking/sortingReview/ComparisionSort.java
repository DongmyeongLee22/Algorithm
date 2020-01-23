package cracking.sortingReview;

public class ComparisionSort {

    public void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, temp, start, mid);
            mergeSort(arr, temp, mid + 1, end);
            merge(arr, temp, start, mid, end);
        }
    }

    private void merge(int[] arr, int[] temp, int start, int mid, int end) {

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        int left = start;
        int right = mid + 1;
        int current = start;

        while (left <= mid && right <= end) {
            if (temp[left] < temp[right]) {
                arr[current++] = temp[left++];
            } else {
                arr[current++] = temp[right++];
            }
        }
        // 3 2 1 4 2
        int remaining = mid - left;

        for (int i = 0; i <= remaining; i++) {
            arr[current + i] = temp[left + i];
        }
    }

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

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

        int left = start;
        int right = end;

        while (left <= right) {

            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            for(int j = 1; j < arr.length - i; j++){
                if (arr[j-1] > arr[j]) swap(arr, j, j-1);
            }
        }
    }

    public void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i; j < arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }
    // 2 3 5 6 2 5 1 2 3

    public void insertSort(int [] arr){
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            while(i > 0 && arr[i-1] > temp){
                arr[i] = arr[i-1];
                i--;
            }
            arr[i] = temp;
        }
    }
}
