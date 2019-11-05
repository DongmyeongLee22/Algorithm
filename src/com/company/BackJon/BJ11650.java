package com.company.BackJon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BJ11650 {

    public static class Location_XY {
        int x;
        int y;

        Location_XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Location_XY [] data = new Location_XY[n];

        for(int i = 0 ; i < n ; i ++){
            data[i] = new Location_XY(sc.nextInt(),sc.nextInt());
        }

        sc.close();
        Arrays.sort(data, new Comparator<Location_XY>() {
            @Override
            public int compare(Location_XY o1, Location_XY o2) {
                if(o1.x == o2.x)
                    return o1.y - o2.y;
                else
                    return o1.x - o2.x;
            }
        });

        for (int i = 0 ; i < n ; i ++)
            System.out.println(data[i].x + " " + data[i].y);
    }
}
