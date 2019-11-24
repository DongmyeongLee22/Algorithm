package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, CacheItem> map;
    CacheItem head;
    CacheItem tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = null;
        tail = null;
        this.capacity = capacity;
    }
    // (1, 1)
    // (2, 2) - (1, 1)
    // return 1
    // (1, 1) - (2, 2)
    // (3, 3) - (1, 1)
    // return -1

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            CacheItem cur = map.get(key);
            if (cur != head) {
                if (cur == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                // head ..... cur.prev - cur - cur.next
                // cur - head ..... cur.prve - cur.next
                if (cur.prev != null) cur.prev.next = cur.next;
                if (cur.next != null) cur.next.prev = cur.prev;

                head.prev = cur;
                cur.next = head;
                cur.prev = null;
                head = cur;

            }
            return head.value;
        }
    }

    public void put(int key, int value) {
        if (get(key) == -1) {
            //insert
            CacheItem cache = new CacheItem(key, value);

            map.put(key, cache);

            if (head == null) {
                head = cache;
                tail = cache;
            } else {
                //  head .. a - b - c

                head.prev = cache;
                cache.next = head;
                head = cache;

                if (map.size() > capacity) {
                    map.remove(tail.key);
                    tail = tail.prev;
                    tail.next = null;
                }
            }
        } else {
            //update
            CacheItem cur = map.get(key);
            cur.value = value;
        }

    }
}

class CacheItem {
    int key;
    int value;
    CacheItem next;
    CacheItem prev;

    public CacheItem(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }


}
