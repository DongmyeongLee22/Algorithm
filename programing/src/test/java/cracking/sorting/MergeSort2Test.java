package cracking.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeSort2Test {


    @Test
    public void test() throws Exception {
        //given
        int[] a = new int[20];
        int[] b = new int[10];
        IntStream.rangeClosed(0, 9).forEach(i -> {
            a[i] = i + 1;
            b[i] = i + 2;
        });

        int[] answer = new int[20];
        IntStream.rangeClosed(0, 9).forEach(i -> {
            answer[i] = a[i];
            answer[i+ 10] = b[i];
        });
        Arrays.sort(answer);

        //when
        MergeSort2 mergeSort2 = new MergeSort2();
        mergeSort2.merge(a, b,10, 10);

        //then
        IntStream.range(0, a.length).forEach(i -> {
            assertThat(answer[i]).isEqualTo(a[i]);
        });

        // 2 2 2 2 3 4
        // 2 2 2 3 4 2

    }

}