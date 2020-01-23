package javainterview.chapter6.TemplateMethod;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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

    @Test
    public void decoratorPattern() throws Exception{
        File f = new File("target", "out.bin");
        FileOutputStream fos = new FileOutputStream(f);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeBoolean(true);
        oos.writeInt(42);
        oos.writeObject(new ArrayList<Integer>());

        oos.flush();
        oos.close();
        bos.close();
        fos.close();

    }

@Test
public void sameInteger(){
    Integer a = Integer.valueOf(56);
    Integer b = Integer.valueOf(56);
    assertThat(a).isSameAs(b);

    Integer c = 56;
    Integer d = 56;
    assertThat(c).isSameAs(d);

    Integer e = new Integer(56);
    Integer f = new Integer(56);
    assertThat(e).isNotSameAs(f);

    Integer g = Integer.valueOf(330);
    Integer h = Integer.valueOf(330);
    assertThat(g).isNotSameAs(h);

    Integer i = 330;
    Integer j = 330;
    assertThat(g).isNotSameAs(h);
}
}