package com.company.BackJon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630 {

    private static int whiteColor = 0;

    private static int blueColor = 0;

    private static int[][] data;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        data = new int[n][n];

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        br.close();

        divide_Paper(0, n - 1, 0, n - 1);
        System.out.println(whiteColor);
        System.out.println(blueColor);

    }

    static void divide_Paper(int rowStart, int rowEnd, int colStart, int colEnd) {

        if (rowStart <= rowEnd) {

            if (!count_Paper(rowStart, rowEnd, colStart, colEnd)) {

                int rowMiddle = (rowStart + rowEnd) / 2;
                int colMiddle = (colStart + colEnd) / 2;

                divide_Paper(rowStart, rowMiddle, colStart, colMiddle);
                divide_Paper(rowMiddle + 1, rowEnd, colStart, colMiddle);
                divide_Paper(rowStart, rowMiddle, colMiddle + 1, colEnd);
                divide_Paper(rowMiddle + 1, rowEnd, colMiddle + 1, colEnd);


            }

        }

    }

    private static boolean count_Paper(int rowStart, int rowEnd, int colStart, int colEnd) {


        if (rowStart == rowEnd)  {
            count_Color(rowStart, colStart);
            return true;
        }

        int i = 0, j = 0;

        int temp = data[rowEnd][colStart];
        for (i = rowStart; i <= rowEnd; i++) {
            for (j = colStart; j <= colEnd; j++) {
                if (temp != data[i][j])
                    return false;

            }
        }

        count_Color(i - 1, j - 1);
        return true;
    }

    private static void count_Color(int rowStart, int colStart) {

        if (data[rowStart][colStart] == 1) {
            blueColor++;
        } else {
            whiteColor++;
        }
    }


}
