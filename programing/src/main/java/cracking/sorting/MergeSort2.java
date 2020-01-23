package cracking.sorting;

public class MergeSort2 {

    public void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int lastIndex = lastA + lastB - 1;

        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]){
                a[lastIndex--] = a[indexA--];
            }else {
                a[lastIndex--] = b[indexB--];
            }
        }
    }
}
