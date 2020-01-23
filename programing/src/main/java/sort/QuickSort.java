package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] data = new int [n];
        for(int i = 0 ; i < n; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        quickSort(data,0,n-1);

        for(int i = 0; i < n; i ++){
            System.out.println(data[i]);
        }

    }

    private static void quickSort(int[] data, int start, int end) {

        if (start < end) {
            int lowerIndex = start;
            for (int i = start; i <= end-1; i++) {
                if (data[end] > data[i]) {
                    int temp = data[i];
                    data[i] = data[lowerIndex];
                    data[lowerIndex++] = temp;
                }
            }
            int tmp = data[lowerIndex];
            data[lowerIndex] = data[end];
            data[end] = tmp;
            int q =  lowerIndex;


            quickSort(data, start, q -1);
            quickSort(data, q + 1, end);
        }
        else
            return;
    }



}
