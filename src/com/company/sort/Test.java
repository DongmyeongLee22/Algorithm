package com.company.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    private static int [] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] data = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++)
            data[i] = Integer.parseInt(reader.readLine());

        quick_Sort(data,0,n - 1);

        for (int i = 0; i < n; i++)
            System.out.println(data[i]);

    }

    private static void heap_Sort(int [] data, int n){
        for(int i = (n+1)/2 -1 ; i >= 0; i--){
            max_hipify(data,i, n);
        }

        for(int i = n; i > 0; i--) {
            swap(data, i, 0);
            max_hipify(data,0,i-1);
        }
    }

    private static void max_hipify(int [] data, int heap, int n) {

        int i = heap;

        while(i*2 < n){
            int node = i*2 + 1;

            if(node == n){
                if(data[node] > data[i])
                    swap(data,node,i);
                return;
            }else{
                if(data[node] < data[node+1])
                    node++;

                if(data[node] > data[i]) {
                    swap(data, node, i);
                    i = node;
                }
                else {
                    return;
                }
            }
        }

    }

    private static void quick_Sort(int [] data, int start, int end){

        if(start < end)
        {
            int p = get_Pivot(data, start, end);
            quick_Sort(data,start,p-1);
            quick_Sort(data,p+1,end);
        }else
            return;
    }

    private static int get_Pivot(int [] data, int start, int end){

        int p = start, i = start +1;
        int j = end;

        while( i <= j){

            while( i <= end  && data[i] < data[p])
                i++;

            while( j > start && data[j] >= data[p])
                j--;

            if(i > j)
                swap(data,p,j);

            else
                swap(data,i,j);
        }

        return j;

    }



    private static void merge_Sort(int [] data, int start, int end){
        if(start < end) {
            int middle = (start + end) / 2;
            merge_Sort(data,start,middle);
            merge_Sort(data,middle+1,end);
            merge(data,start,middle,end);
        }
    }

    private static void merge(int [] data, int start, int middle, int end){
        int i = start, z = start;
        int j = middle+1;
        while(i <= middle && j <=end){
            if(data[i] < data[j])
                tmp[z++] = data[i++];
            else
                tmp[z++] = data[j++];
        }

        while(i <= middle)
            tmp[z++] = data[i++];

        while(j <= end)
            tmp[z++] = data[j++];

        for(int x = 0; x <=end; x++)
            data[x] = tmp[x];

    }


    private static void insertion_Sort(int[] data, int n) {
        int j, i;
        for (i = 1; i <= n; i++) {
            int tmp = data[i];
            for (j = i - 1; j >= 0 && data[j] > data[i]; j--) {
                  data[j+1] = data[j];
            }
            data[j+1] = tmp;
        }
    }

    private static void bubble_Sort(int[] data, int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                if (data[j] > data[j + 1])
                    swap(data, j, j + 1);
            }
        }
    }

    private static void selection_Sort(int[] data, int n) {
        int max = 0;
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[i])
                    swap(data, i, j);
            }
        }
    }

    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
