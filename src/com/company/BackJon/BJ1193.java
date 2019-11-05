package com.company.BackJon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1193 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        reader.close();


        int sum = 1;
        int count = 1;

        while (n >= sum) {
            sum += count++;
        }
        count = count - 1;
        int diff = sum - 1 - n;

        int value1 = (count - diff);
        int value2 = (1 + diff);

        if (count % 2 == 0)
            System.out.println(value1 + "/" + value2);
        else
            System.out.println(value2 + "/" + value1);
    }
}
