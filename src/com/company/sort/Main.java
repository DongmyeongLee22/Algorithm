package com.company.sort;

import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

        long begin = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int c = 10001;
        int [] data = new int [c];

        for(int i = 0; i < n; i++){
            data[Integer.parseInt(reader.readLine())]++;
        }


        for(int i = 1; i < c; i++){
            for(int j = 0; j < data[i]; j++)
                writer.write(Integer.toString(i) + "\n");
        }
        reader.close();
        writer.close();

    }

}

