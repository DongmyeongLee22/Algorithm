package javainterview.chapter6.TemplateMethod;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class StackPredicateTest {

    private Stack stack;

    @Before
    public void createStack(){
        stack = new Stack();
        IntStream.rangeClosed(1, 10).forEach(i -> stack.push(i));
    }

    @Test
    public void evenPredicate() throws Exception{
        Stack filter = stack.filter(new StackPredicate() {
            @Override
            public boolean isValid(int value) {
                return value % 2 == 0;
            }
        });

        assertThat(filter.pop()).isEqualTo(10);
        assertThat(filter.pop()).isEqualTo(8);
        assertThat(filter.pop()).isEqualTo(6);
    }

    @Test
    public void oddPredicate() throws Exception{
        Stack filter = stack.filter(value -> value % 2 == 1);

        assertThat(filter.pop()).isEqualTo(9);
        assertThat(filter.pop()).isEqualTo(7);
        assertThat(filter.pop()).isEqualTo(5);
    }
}