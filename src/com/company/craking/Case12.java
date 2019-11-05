package com.company.craking;

import java.util.Arrays;

public class Case12 {

    boolean isPermutation(String str1, String str2){
        return sort(str1).equals(sort(str2));
    }

    private String sort(String str) {

        char [] chars = str.toCharArray();

        Arrays.sort(chars);

        return new String(chars);
    }

    public static void main(String[] args) {
        Case12 case12 = new Case12();

        System.out.println(case12.isPermutation("test", "sett"));
    }

}
