package cracking.sorting;

public class BinarySearch {

    public int binarySearch(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] < x) {
                start = mid + 1;
            } else if (arr[mid] > x) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int binarySearchRecursive(int[] arr, int x) {
        return binarySearchRecursive(arr, x, 0, arr.length - 1);
    }

    private int binarySearchRecursive(int[] arr, int x, int start, int end) {
        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (arr[mid] > x){
            return binarySearchRecursive(arr, x, start, mid - 1);
        }

        if (arr[mid] < x){
            return binarySearchRecursive(arr, x, mid + 1, end);
        }

        return mid;
    }
}
