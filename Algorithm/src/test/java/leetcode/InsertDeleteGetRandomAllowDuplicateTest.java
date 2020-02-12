package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class InsertDeleteGetRandomAllowDuplicateTest {


    @Test
    public void firstTest() throws Exception {
        InsertDeleteGetRandomAllowDuplicate allowDuplicate = new InsertDeleteGetRandomAllowDuplicate();

        allowDuplicate.insert(1);
        allowDuplicate.insert(2);
        allowDuplicate.insert(3);
        allowDuplicate.insert(1);
        allowDuplicate.insert(3);
        allowDuplicate.insert(1);
        allowDuplicate.insert(3);
        allowDuplicate.insert(2);
        allowDuplicate.insert(2);

        allowDuplicate.printKeyList();

        allowDuplicate.remove(3);
        allowDuplicate.printKeyList();
    }

/*
    ["RandomizedCollection","insert","insert","insert","insert",
            "insert","remove","remove","remove","insert","remove"
            ,"getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom"]
            [[],[1],[1],[2],[2],[2],[1],[1],[2],[1],[2],[],[],[],[],[],[],[],[],[],[]]
            */

    @Test
    public void test2() throws Exception {
        InsertDeleteGetRandomAllowDuplicate allowDuplicate = new InsertDeleteGetRandomAllowDuplicate();
        allowDuplicate.insert(1);
        System.out.println("insert");
        allowDuplicate.printKeyList();
        allowDuplicate.insert(1);
        System.out.println("insert");
        allowDuplicate.printKeyList();
        allowDuplicate.insert(2);
        System.out.println("insert");
        allowDuplicate.printKeyList();
        allowDuplicate.insert(2);
        System.out.println("insert");
        allowDuplicate.printKeyList();
        allowDuplicate.insert(2);
        allowDuplicate.printKeyList();


        allowDuplicate.remove(1);
        System.out.println("remove");
        allowDuplicate.printKeyList();
        allowDuplicate.remove(1);
        System.out.println("remove");
        allowDuplicate.printKeyList();
        allowDuplicate.remove(2);
        System.out.println("remove");
        allowDuplicate.printKeyList();
        allowDuplicate.remove(1);
        System.out.println("remove");
        allowDuplicate.printKeyList();
        allowDuplicate.remove(2);
        System.out.println("remove");
        allowDuplicate.printKeyList();


    }

    @Test
    public void test() throws Exception{
        //given
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();

        set1.add(3);
        set1.add(5);
        set1.add(1);
        set1.add(2);

        for (Integer integer : set1) {
            System.out.print(integer);
        }

        System.out.println();
        set2.add(3);
        set2.add(5);
        set2.add(1);
        set2.add(2);

        for (Integer integer : set2) {
            System.out.print(integer);
        }
        //when

        //then
    }


}