package com.company.BackJon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BJ10814 {

    public static class Location_XY {
        int age;
        String name;

        Location_XY(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Location_XY [] data = new Location_XY[n];

        for(int i = 0 ; i < n ; i ++){
            data[i] = new Location_XY(sc.nextInt(),sc.next());
        }

        sc.close();

        Arrays.sort(data, new Comparator<Location_XY>() {
            @Override
            public int compare(Location_XY o1, Location_XY o2) {
                if(o1.age == o2.age)
                    return 0;
                else
                    return o1.age - o2.age;
            }
        });

        for (int i = 0 ; i < n ; i ++)
            System.out.println(data[i].age + " " + data[i].name);
    }
}
