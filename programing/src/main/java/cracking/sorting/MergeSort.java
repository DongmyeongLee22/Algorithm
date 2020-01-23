package cracking.sorting;

 public class MergeSort {

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
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int left = start;
        int right = mid + 1;
        int current = start;

        while (left <= mid && right <= end) {
            if (temp[left] <= temp[right]) {
                arr[current] = temp[left];
                left++;
            } else {
                arr[current] = temp[right];
                right++;
            }

            current++;
        }

        int remaining = mid - left;
        for (int i = 0; i <= remaining; i++) {
            arr[current + i] = temp[left + i];
        }
    }
}
