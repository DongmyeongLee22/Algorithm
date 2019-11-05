package com.company.BackJon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2775 {


    static int people [][] = new int [15][15];

    public static void main(String[] args) throws IOException {

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(rd.readLine());

        int k =0, n = 0 ;

        for(int i =1; i<people.length;i++)
            people[0][i] = i;

        int sum = 0;

        for(int i = 1; i <= 14; i++){
            for(int  j = 1 ; j <= 14; j++){
                sum += people[i-1][j];
                people[i][j] = sum;
            }
            sum = 0;
        }

        for(int i = 0 ; i < T ; i ++){
            k = Integer.parseInt(rd.readLine());
            n = Integer.parseInt(rd.readLine());
            System.out.println(people[k][n]);
        }

        rd.close();

    }


}
