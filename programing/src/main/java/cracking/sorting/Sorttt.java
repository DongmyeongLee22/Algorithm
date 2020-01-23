package cracking.sorting;

public class Sorttt {

    void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];

            while(i > 0 && arr[i -1] > temp){
                arr[i] = arr[i-1];
                i--;
            }


        }
    }
}
