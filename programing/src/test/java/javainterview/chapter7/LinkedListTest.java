package javainterview.chapter7;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {

@Test
public void reverseList() throws Exception{
    LinkedList<Integer> three = new LinkedList<>(3, null);
    LinkedList<Integer> two = new LinkedList<>(2, three);
    LinkedList<Integer> one = new LinkedList<>(1, two);


    LinkedList<Integer> reverse = LinkedList.reverse(one);

    assertThat(reverse.item).isEqualTo(3);
    assertThat(reverse.next.item).isEqualTo(2);
    assertThat(reverse.next.next.item).isEqualTo(1);
}


}