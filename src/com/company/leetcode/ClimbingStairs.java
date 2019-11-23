package com.company.leetcode;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 7;
        int dina = climbingStaris(n);
        int recu = fibo(n);

        System.out.println(dina);
        System.out.println(recu);
    }


    private static int fibo(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        return fibo(n - 1) + fibo(n - 2);

    }

    private static int climbingStaris(int n) {
        int[] ret = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                ret[i] = 1;
            } else if (i == 2) {
                ret[i] = 2;
            }else{
                ret[i] = ret[i-1] + ret[i-2];
            }

        }

        return ret[n];
    }

}
