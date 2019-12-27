package com.company.cracking.hash;

public class Test {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        hashTable.put("dong", 321);
        hashTable.put("lee", 123);
        hashTable.put("hee", 111);
        hashTable.put("myeong", 000);

        System.out.println(hashTable.get("dong"));
        System.out.println(hashTable.get("lee"));
        System.out.println(hashTable.get("hee"));
        System.out.println(hashTable.get("myeong"));
    }
}
