package com.company.craking;

public class Case11 {

    boolean isUniqueChars(String str){

        int [] count = new int [128];

        for(char i : str.toCharArray()){
            int x = Character.getNumericValue(i);
            count[x]++;
            if(count[x] > 1)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Case11 case11 = new Case11();

        System.out.println(case11.isUniqueChars("name"));
    }


}
