package com.company.cracking.hash;

public class HashTable<K, V> {

    private Node<?, ?>[] table;
    private int size;

    public HashTable(int size) {
        this.table = new Node<?, ?>[size];
        this.size = size;
    }

    private void createNode(K key, V value) {
        int hashCode = key.hashCode();
        int index = getIndex(key);
        table[index] = new Node<>(key, value);
        table[index].next = null;
    }

    V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> node = (Node<K, V>) table[index];

        while (node != null) {

            if (node.key.equals(key)) {
                V ret = node.value;
                node.value = value;
                return ret;
            }

            node = node.next;
        }
        createNode(key, value);
        return null;
    }

    V remove(K key) {
        int index = getIndex(key);
        Node<K, V> node = (Node<K, V>) table[index];

        Node<K, V> prev = null;

        while (node != null) {

            if (node.key.equals(key)) {
                V deletedValue = node.value;
                if (prev == null) {
                    node = node.next;
                } else {
                    prev.next = node.next;
                }
                return deletedValue;
            }

            prev = node;
            node = node.next;
        }

        throw new IllegalArgumentException("키에 맞는 값이 존재하지 않습니다.");
    }

    V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = (Node<K, V>) table[index];

        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }

        throw new IllegalArgumentException("키에 맞는 값이 존재하지 않습니다.");
    }

    private int getIndex(K key) {
        return makeIndex(key.hashCode(), size);
    }

    private int makeIndex(int hashCode, int size) {
        return Math.abs(hashCode) % size;
    }

    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
