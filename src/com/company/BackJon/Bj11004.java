package com.company.BackJon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11004 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());

        int [] data = new int [N];

        for(int i = 0 ; i < N ; i ++)
            data[i] = Integer.parseInt(tokenizer.nextToken());

        reader.close();
        System.out.println(quick_Sort(data,0,data.length-1, K-1));
    }

    private static int quick_Sort(int[] data, int start, int end, int K) {
            int p = get_pivot(data, start, end);
            if(p > K)
                return quick_Sort(data, start, p - 1, K);
            else if(p < K)
                return quick_Sort(data,p+1,end,K);
            else
                return data[K];

    }


    private static  int get_pivot(int[] data, int start, int end) {

        swap(data,end,(start+end)/2);
        int i = start + 1, j = end;

        while (i <= j) {

            while (i <= end && data[i] <= data[start])
                i++;
            while (j > start && data[j] > data[start])
                j--;

            if (i > j)
                swap(data, start, j);
            else
                swap(data, i, j);

        }
        return j;

    }
    private static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
