package javainterview.chapter7;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringLengthOperationTest {

@Test
public void stringLengths() throws Exception{
    List<String> strings = Arrays.asList("apple", "banana", "orange", "123456789");

    int [] test = {1, 2, 3, 4, 5};

    double v = Arrays.stream(test).sum() / (double) test.length;
    System.out.println(v);
    List<Integer> lengthList = StringLengthOperation.mapList(strings, new StringLengthOperation());

    List<Integer> answer = Arrays.asList(5, 6, 6, 9);

    assertThat(lengthList).isEqualTo(answer);
}


}