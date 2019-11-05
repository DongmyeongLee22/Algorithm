package com.company.BackJon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] data;

    private static int[] count;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        data = new int[n][n];

        count = new int[3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                data[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }

        br.close();


        divide_Paper(0, 0, n);

        for (int i : count)
            System.out.println(i);

    }

    static void divide_Paper(int rowStart, int colStart, int len) {

        if (len >= 1) {

            if (!count_Paper(rowStart, colStart, len)) {

                len /= 3;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        divide_Paper(rowStart + i * len, colStart + j * len, len);
                    }
                }
            }
        }
    }

    private static boolean count_Paper(int rowStart, int colStart, int len) {

        if (len == 1) {
            count[data[rowStart][colStart]]++;
            return true;
        }

        int temp = data[rowStart][colStart];
        for (int i = rowStart; i < rowStart + len; i++) {
            for (int j = colStart; j < colStart + len; j++) {
                if (temp != data[i][j])
                    return false;
            }
        }
        count[temp]++;
        return true;

    }

}



