package com.company.sort;

import java.util.Comparator;

public class Fruit {

    private String name;
    private int quantity;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }


    //어나니머스 클래스 라고 부른다.
    //컴래퍼터 인터페이스를 상속하는 클래스를 만들어 그것의 객체를 생성한다.
    //그 클래스는 캠패어라는 멤버 메서드를 무조건 구현해야하므로
    //그 객체를 바로 만들어서 quantity로 만들겠다라는 뜻.
    //이 method만 필요하니 굳이 따로 클래스 만들 필요 없음.
    public static Comparator<Fruit> quantityComparator = new Comparator<Fruit>() {
        @Override
        public int compare(Fruit o1, Fruit o2) {
            return o1.quantity - o2.quantity;
        }
    };

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public static Comparator<Fruit> nameComparator = new Comparator<Fruit>() {
        @Override
        public int compare(Fruit o1, Fruit o2) {
            return o1.name.compareTo(o2.name);
        }
    };
}
