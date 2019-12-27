package com.company.cracking.bitmanipulation;

public class Test {
    public static void main(String[] args) {
        String s = "ABCDE";
        String s1 = "ABCDEF";
        String s2 = "ABCDEFD";
        reversString(s.toCharArray(), 0, s.length() - 1);
        reversString(s1.toCharArray(), 0, s1.length() - 1);
        reversString(s2.toCharArray(), 0, s2.length() - 1);
        StringBuilder a = new StringBuilder("ABCDE");
        System.out.println(a.reverse().toString());
        System.out.println(s);
    }

    private static void reversString(char[] chars, int start, int end) {
        if (start < end) {
            return;
        }

        char temp = chars[start];
        chars[start++] = chars[end];
        chars[end--] = temp;

        reversString(chars, start, end);
    }
}

