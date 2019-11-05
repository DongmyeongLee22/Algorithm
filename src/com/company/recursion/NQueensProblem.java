package com.company.recursion;

public class NQueensProblem {

    private static int N = 8;
    private static int[] data = new int[N + 1];
    private static boolean aBoolean = false;

    private static boolean promising(int level) {
        for (int i = 1; i < level; i++) {
            if (data[level] == data[i])
                return false;
            else if ((level - i) == Math.abs(data[level] - data[i]))
                return false;
        }
        return true;
    }

    private static void queensProblem(int level) {
        if (!promising(level))
            return;
        else if (level == N) {
            aBoolean = true;
            for (int i = 1; i <= N; i++) {
                for(int j = 1; j < data[i]; j++)
                    System.out.print("  ");
                System.out.println(data[i] + " ");
            }
            return;
        }
        for (int i = 1; i <= N; i++) {
            data[level + 1] = i;
            queensProblem(level + 1);
            if(aBoolean)
                return;
        }
    }

    public static void main(String[] args) {
        queensProblem(0);
    }

}
