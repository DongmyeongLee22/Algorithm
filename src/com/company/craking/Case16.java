package com.company.craking;

public class Case16 {

    void zip(String str){

        StringBuilder builder = new StringBuilder();
        int count = 0;

        for(int i =0 ; i < str.length(); i ++){
            count ++;
            if( i >= str.length()-1 || str.charAt(i) != str.charAt(i+1)){
                builder.append(str.charAt(i)+""+count);
                count = 0;
            }
        }

        System.out.println(builder);
    }

    public static void main(String[] args) {
        String str = "aabccccaaa";
        Case16 case16 = new Case16();
        case16.zip(str);

    }

}
