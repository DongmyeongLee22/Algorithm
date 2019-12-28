package sort;

//분할 정복법으로 정렬하는 알고리즘
//분할 하여 정복하고 합병 한다.

public class MergeSort {

    private static int[] data = {7, 5 , 2 , 1 , 8 , 9, 2 , 32 ,12 ,22};
    private static int n = data.length;
    private static int[] tmp = new int[n];

    private static void mergeSort(int[] data, int start, int end) {

        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(data, start, middle);
            mergeSort(data, middle + 1, end);
            merge(data, start, middle, end);
        }
    }

    private static void merge(int[] data, int start, int middle, int end) {
        int i = start, k = start;
        int j = middle + 1;

        while (i <= middle && j <= end) {
            if (data[i] < data[j])
                tmp[k++] = data[i++];
            else
                tmp[k++] = data[j++];
        }

        while (i <= middle)
            tmp[k++] = data[i++];


        while (j <= end)
            tmp[k++] = data[j++];

        for(int z = 0; z <= end; z++){
            data[z] = tmp[z];
        }

    }

    public static void main(String[] args) {
        mergeSort(data,0,n-1);

        System.out.println((0+n-1)/2);
        for(int z = 0; z < n; z++){
            System.out.print(data[z] + " ");
        }
    }

}
