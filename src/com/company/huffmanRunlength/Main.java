package com.company.huffmanRunlength;

public class Main {
    public static void main(String[] args) {
        int a = 3;
        int b = 0 << 1;
        int c = b << 1;
        int d = c << 1;
        int e = d << 1;
        String x = Integer.toBinaryString(a);
        int i = Integer.parseInt(x);
        String format = String.format("%0" + 5 + "d", x);
        System.out.println(x);
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(d));
        System.out.println(Integer.toBinaryString(e));
        System.out.println(i);
        System.out.println(format);
    }
}
