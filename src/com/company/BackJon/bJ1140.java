package com.company.BackJon;

import java.io.IOException;

public class bJ1140 {

    public static void main(String[] args) throws IOException {

        System.out.println(solve(92, 10, 90, 20, 170));
        System.out.println(solve(90, 10, 90, 20, 170));
        System.out.println(solve(99, 10, 90, 20, 170));

    }

    public static int solve(int T, int PK1, int P1, int PK2, int P2) {

        if (PK1 > PK2) {
            int temp1 = PK1;
            int temp2 = P1;
            PK1 = PK2;
            P1 = P2;
            PK2 = temp1;
            P2 = temp2;
        }

        //PK개 P원
        int ret = 0;
        int cur = T;

        if (P1 / PK1 < P2 / PK2) {
            int count = cur / PK1;
            ret += P1 * count;
            cur -= count * PK1;
        } else {
            int count = cur / PK2;
            ret += P2 * count;
            cur -= count * PK2;
        }

        if (cur == 0)
            return ret;

        int p1min = P1 + 10 * (cur % PK1);
        int min = 10 * cur;

        ret += Math.min(p1min, Math.min(min, P2));

        // 0, 19, 9

        return ret;
    }
}
