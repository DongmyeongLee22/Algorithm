package com.company.sort;

import java.util.Random;

public class countingSort {

    public static void main(String[] args) {

        Random random = new Random();
        int n = 20;
        int k = 6;
        int[] data = new int[n];
        int[] b = new int[n];
        int[] c = new int[k];
        for (int i = 0; i < n; i++)
            data[i] = random.nextInt(k);

        for (int i = 0; i < n; i++) {
            System.out.print(data[i] + " ");
            c[data[i]]++;
        }

        System.out.println("");

        for (int i = 0; i < k; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println("");

        for (int i = 1; i < k; i++) {
            c[i] += c[i - 1];
        }
        for(int i = 0; i < k; i++){
            System.out.print(c[i] + " ");
        }
        System.out.println("");

        for (int i = n - 1; i >= 0; i--) {
            b[c[data[i]] - 1] = data[i];
            c[data[i]]--;
        }
        for (int i = 0; i < n; i++)
            System.out.print(b[i] + " ");
        System.out.println("");


    }


}
