package com.company.leetcode;

import java.util.*;

public class InsertDeleteGetRandom {

    class RandomizedSet {

        //key: element
        //value: index
        Map<Integer, Integer> map;
        List<Integer> list;
        Random r = new Random();
        //int size;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            // size = 0;
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            int index = map.get(val);
            map.remove(val);

            if(index != list.size() - 1){
                int swap = list.get(list.size() - 1);
                list.set(index, swap);
                map.put(swap, index);
            }

            list.remove(list.size()-1);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int index = r.nextInt(list.size());
            return list.get(index);
        }
    }

}
