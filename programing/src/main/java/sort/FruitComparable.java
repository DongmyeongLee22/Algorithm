package sort;

public class FruitComparable implements Comparable<FruitComparable> {
    public String name;
    public int quantity;

    public FruitComparable(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }



    @Override
    public int compareTo(FruitComparable other) {
        return quantity - other.quantity;
    }

    //    @Override
//    public int compareTo(FruitComparable other) {
//        return name.compareTo(other.name);
//    }

    @Override
    public String toString() {
        return "FruitComparable{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
