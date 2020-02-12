package leetcode;

import java.util.*;

class InsertDeleteGetRandom {

    Random r;
    List<Integer> list;
    HashMap<Integer, Integer> map;

    public InsertDeleteGetRandom() {
        r = new Random();
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }


    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        // 삭제될 값의 인덱스
        int index = map.get(val);

        // 마지막의 값
        int changeVal = list.get(list.size() - 1);

        map.put(changeVal, index);
        list.set(index, changeVal);

        map.remove(val);
        list.remove(list.size() - 1);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }

    public void printKeyList(){
        map.keySet().forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}

