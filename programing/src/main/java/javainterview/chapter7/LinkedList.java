package javainterview.chapter7;

public class LinkedList<T> {

    public T item;
    public LinkedList<T> next;


    public LinkedList(T item, LinkedList<T> next) {
        this.item = item;
        this.next = next;
    }


    public static <T> LinkedList<T> reverse(LinkedList<T> original){
        if(original == null){
            throw new NullPointerException("첫번째 값은 Null이 될수 없습니다.");
        }

        if (original.next == null){
            return original;
        }

        LinkedList<T> next = original.next;
        original.next = null;

        LinkedList<T> reversedList = reverse(next);

        next.next = original;

        return reversedList;
    }

}
