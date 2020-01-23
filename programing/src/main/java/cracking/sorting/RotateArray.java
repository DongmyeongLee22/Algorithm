package cracking.sorting;

public class RotateArray {

    int findRotateArray(int[] arr, int x){
        return search(arr, x, 0, arr.length-1);
    }

    private int search(int[] arr, int x, int start, int end) {
        int mid = (start + end) / 2;

        if (arr[mid] == x){
            return mid;
        }

        if (end < start){
            return -1;
        }

        if (arr[start] < arr[mid]){
            if(x >= arr[start] && x <= arr[mid]){
                return search(arr, x, start, mid -1);
            }
            return search(arr, x, mid + 1, end);
        }else if(arr[start] > arr[mid]){
            if(x >= arr[mid] && x <= arr[end]){
                return search(arr, x, mid+1, end);
            }

            return search(arr, x, start, mid - 1);
        }else if(arr[start] == arr[mid]){
            if (arr[end] != arr[mid]){
                return search(arr, x, mid+1, end);
            }
            int result = search(arr, x, start, mid - 1);
            if (result == -1){
                return search(arr, x, mid + 1, end);
            }

            return result;
        }

        return -1;
    }
}
