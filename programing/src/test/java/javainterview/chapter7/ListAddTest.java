package javainterview.chapter7;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListAddTest {

@Test
public void updateTest() throws Exception{
    List<Integer> list = Arrays.asList(1, 3, 6, 7, 9, -1, -2);

    List<Integer> getList = ListAdd.updateList(list, value -> value - 10);

    int index = 0;

    for (Integer integer : getList) {
        assertThat(integer).isEqualTo(list.get(index++) -10);
    }
}


}