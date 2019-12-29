package cracking.recursionanddynamic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindPathTest {

    private FindPath findPath = new FindPath();

    @Test
    public void magicIndexTest() throws Exception {
        //given
        int[] arr = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        int[] arr2 = {-2, -1, 0, 1, 2, 5, 6};
        //when
        int index1 = findPath.magicIndex2(arr);
        int index2 = findPath.magicIndex2(arr2);
        //then
        assertThat(index1).isEqualTo(7);
        assertThat(index2).isEqualTo(5);

        int[] arr3 = {-10, 5, 2, 2, 2, 3, 4, 7 ,9, 12, 13};

        int index3 = findPath.magicIndex3(arr3);

        assertThat(index3).isEqualTo(2);
    }

    @Test
    public void fundGroup() throws Exception{
        //given
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //when
        List<List<Integer>> group = findPath.findGroup(list, 0);
        List<List<Integer>> group2 = findPath.findg(list, 0);

        //then
        System.out.println(group);
        System.out.println(group2);
    }


    @Test
    public void sumProduct(){

        int answer1 = findPath.multiply(3, 7);
        int answer2 = findPath.multiply(5, 3);
        int answer3 = findPath.multiply(5, 2);
        int answer4 = findPath.multiply(5, 6);
        int answer5 = findPath.multiply(5, 1);

        assertThat(answer1).isEqualTo(21);
        assertThat(answer2).isEqualTo(15);
        assertThat(answer3).isEqualTo(10);
        assertThat(answer4).isNotEqualTo(10);
        assertThat(answer5).isNotEqualTo(10);

    }

    @Test
    public void sumProductWithMemo(){

        int answer1 = findPath.multiply2(3, 7);
        int answer2 = findPath.multiply2(5, 3);
        int answer3 = findPath.multiply2(5, 2);
        int answer4 = findPath.multiply2(5, 6);
        int answer5 = findPath.multiply2(5, 1);

        assertThat(answer1).isEqualTo(21);
        assertThat(answer2).isEqualTo(15);
        assertThat(answer3).isEqualTo(10);
        assertThat(answer4).isNotEqualTo(10);
        assertThat(answer5).isNotEqualTo(10);

    }

}