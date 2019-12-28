package sort;

import java.util.Scanner;

public class HeapSort {

    private static int[] data;
    private static int[] extract_Max;
    private static int heapSize;

    private static void swap(int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    private static void make_Heap(int[] data, int heap) {

        int i = heap;

        while (i * 2 < heapSize) {
            int node = i * 2 + 1;

            if (node >= heapSize) {
                if (data[node] > data[i])
                    swap(node, i);
                return;
            } else {
                if (data[node + 1] > data[node])
                    node++;

                if (data[node] > data[i]) {
                    swap(node, i);
                    i = node;
                } else {
                    return;
                }
            }

        }
    }

    private static void heap(int[] data) {
        for (int i = ((heapSize + 1) / 2) - 1; i >= 0; i--)
            make_Heap(data, i);
    }

    private static void heapSort(int[] data) {
        heap(data);
        for (int i = heapSize; i >= 1; i--) {
            swap(0, i);
            heapSize--;
            make_Heap(data, 0);
        }
    }

    private static void insert_Heap(int [] data, int value){
        heapSize++;
        data[heapSize] = value;
        int i = heapSize;
        while(heapSize >= 0){
            int parent = (heapSize+1) / 2 -1;
            if(data[parent] < data[heapSize])
                swap(parent,heapSize);
            heapSize = parent;
        }
        for (int j = heapSize; j >= 1; j--) {
            swap(0, i);

            heapSize--;
            make_Heap(data, 0);
        }
    }



    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        heapSize = kb.nextInt() - 1;
        data = new int [10000];
        extract_Max = new int [10000];
        for(int i = 0 ; i <= heapSize; i++){
            data[i] = kb.nextInt();
        }
        heapSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
