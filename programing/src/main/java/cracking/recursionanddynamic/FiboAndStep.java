package cracking.recursionanddynamic;

import java.util.Arrays;

public class FiboAndStep {

    int fibonacci(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    int fibonacci1(int i) {
        return fibonacci1(i, new int[i + 1]);
    }

    int fibonacci1(int i, int[] val) {
        if (i == 0 || i == 1) return i;
        if (val[i] == 0) {
            val[i] = fibonacci1(i - 1, val) + fibonacci1(i - 2, val);
        }
        return val[i];
    }

    int fibonacci2(int n) {
        if (n == 0 || n == 1) return n;
        int val[] = new int[n];
        val[0] = 0;
        val[1] = 1;
        for (int i = 2; i < n; i++) {
            val[i] = val[i - 1] + val[i - 2];
        }

        return val[n - 1] + val[n - 2];
    }

    int fibonacci3(int n) {
        if (n == 0 || n == 1) return n;
        int a = 0;
        int b = 1;
        for (int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }

    public static void main(String[] args) {
        FiboAndStep fiboAndStep = new FiboAndStep();
        System.out.println(fiboAndStep.countStep(4));
    }

    int countStep(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return n;
        }

        int[] val = new int[n + 1];
        val[0] = 1;
        val[1] = 1;
        val[2] = 2;

        for (int i = 3; i <= n; i++) {
            val[i] = val[i - 1] + val[i - 2] + val[i - 3];
        }

        return val[n];
    }
    int countStempMemo(int n){
        int memo[] = new int[n+1];
        Arrays.fill(memo, -1);
        return countStepMemorization(n, memo);
    }
    private int countStepMemorization(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if(memo[n] != -1){
            return memo[n];
        } else{
            return countStepMemorization(n - 1, memo) + countStepMemorization(n - 2, memo) + countStepMemorization(n - 3, memo);
        }
    }



}
