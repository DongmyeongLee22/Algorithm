package com.company.BackJon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BaekJoon1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String [] data = new String [n];

        for(int i = 0 ; i < n; i ++) {
            data[i] = reader.readLine();
        }

        Arrays.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length())
                    return o1.compareTo(o2);
                else if(o1.length() > o2.length())
                    return 1;
                else
                    return -1;

            }
        });
        System.out.println(data[0]);
        for(int i = 1 ; i < n; i ++) {
            if(data[i-1].equals(data[i])) continue;
            System.out.println(data[i]);
        }
        reader.close();

    }

}
