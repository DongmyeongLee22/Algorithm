package leetcode;

import java.util.*;

class InsertDeleteGetRandomAllowDuplicate {

    Random r;
    List<Integer> list;
    HashMap<Integer, List<Integer>> map;

    public InsertDeleteGetRandomAllowDuplicate() {
        r = new Random();
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            List<Integer> insert = new ArrayList<>();
            insert.add(list.size());
            map.put(val, insert);
        }else{
            List<Integer> insert = map.get(val);
            insert.add(list.size());
        }

        list.add(val);
        return true;
    }


    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        // 삭제될 값의 인덱스
        List<Integer> deleteList = map.get(val);

        int index = deleteList.get(deleteList.size() - 1);
        int changeVal = list.get(list.size() - 1);
        List<Integer> changeList = map.get(changeVal);
        if(val != changeVal){
            changeList.add(0, index);
            list.set(index, changeVal);
            changeList.remove(changeList.size() - 1);
        }

        if (deleteList.size() == 1){
            map.remove(val);
        }else{
            deleteList.remove(deleteList.size() - 1);
        }

        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }

    public void printKeyList(){
        System.out.println("================================");
        Set<Integer> set = map.keySet();
        for(int i : set){
            System.out.print("key: " + i + "   Value: ");
            List<Integer> list = map.get(i);
            list.forEach(v -> System.out.print(v + ", "));
            System.out.println();
        }
        System.out.println("================================\n\n");
    }
}

