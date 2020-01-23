package cracking.sorting;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BinarySearchTest {

    @Test
    public void test() throws Exception{
        //given
        int[]  input1 = {1, 3, 6, 8, 9, 10 ,12, 15, 18};
        int[]  input2 = {1, 3, 2, 8, 2, 2 ,5, 8, 11};
        BinarySearch binarySearch = new BinarySearch();
        //when
        int binarySearch1 = binarySearch.binarySearch(input1, 3);
        int binarySearchRecursive1 = binarySearch.binarySearchRecursive(input1, 3);

        int binarySearch2 = binarySearch.binarySearch(input2, 3);
        int binarySearchRecursive2 = binarySearch.binarySearchRecursive(input2, 3);

        //then
        assertThat(binarySearch1).isEqualTo(1);
        assertThat(binarySearch2).isEqualTo(-1);
        assertThat(binarySearchRecursive1).isEqualTo(1);
        assertThat(binarySearchRecursive2).isEqualTo(-1);
    }


}