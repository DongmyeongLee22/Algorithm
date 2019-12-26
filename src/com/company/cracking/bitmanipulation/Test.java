package com.company.cracking.bitmanipulation;

public class Test {
    public static void main(String[] args) {
        BitReverse bitReverse = new BitReverse();
        NextValue nextValue = new NextValue();
        System.out.println(bitReverse.revers(1775));
        System.out.println(bitReverse.revers(439));
        System.out.println(bitReverse.bestPractice(1775));
        System.out.println(bitReverse.bestPractice(439));
        int val = nextValue.getLargeButSmallestValue(Integer.parseInt("110011100", 2));
        System.out.println(Integer.toBinaryString(val));

        int val2 = nextValue.getSmallButLargest(Integer.parseInt("10011110000011", 2));
        System.out.println(Integer.toBinaryString(val2));

    }
}

