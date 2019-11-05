package com.company.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class sortForJava {

    public static void main(String[] args) {

        int capacity = 100;
        int [] data = new int [capacity];

        //int , double, long 다 된다.
        Arrays.sort(data);
        Arrays.sort(data, 0 , 50);


        //배열
        String [] fruits = { "Pineapple", "Apple", "Orange", "Banana"};
        Arrays.sort(fruits);
        for(String name : fruits)
            System.out.println(name);


        //Collection
        List<String> fruits2= new ArrayList<String>();
        fruits2.add("Pineapple");
        fruits2.add("Apple");
        fruits2.add("Orange");
        fruits2.add("Banana");

        Collections.sort(fruits2);
        for(String name : fruits2)
            System.out.println(name);

        Fruit [] f = new Fruit[4];
        f[0] = new Fruit("Pinapple", 20);
        f[1] = new Fruit("Apple", 10);
        f[2] = new Fruit("Orange", 40);
        f[3] = new Fruit("Banana", 60);

        // 그냥 이렇게하면 에러난다
        //Arrays.sort(f);

        FruitComparable [] fc = new FruitComparable[4];
        fc[0] = new FruitComparable("Pinapple", 20);
        fc[1] = new FruitComparable("Apple", 10);
        fc[2] = new FruitComparable("Orange", 40);
        fc[3] = new FruitComparable("Banana", 60);

        //따로 Comparable을 구현해줘야함
        Arrays.sort(fc);

        //Comparable 은 한가지의 value 만 비교 할수 있다.
        for(FruitComparable name : fc)
            System.out.println(name.toString());

        Arrays.sort(f,Fruit.nameComparator);

        for(Fruit name : f)
            System.out.println(name.toString());

        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit("test1", 30));
        fruitList.add(new Fruit("test2", 10));
        fruitList.add(new Fruit("test3", 70));
        fruitList.add(new Fruit("test4", 40));

        Collections.sort(fruitList,Fruit.quantityComparator);

        for(Fruit fruit : fruitList)
            System.out.println(fruit.toString());
    }
}
