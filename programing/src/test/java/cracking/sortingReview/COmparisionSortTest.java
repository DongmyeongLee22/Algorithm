package cracking.sortingReview;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class COmparisionSortTest {

    @Test
    public void MergeSortTest() throws Exception{
        //given
        int [] input1 = {4, 6, 1, 2, 7 ,4 ,2, 1, 7, 2};
        int [] input2 = {3, 1 ,2 ,6, 7, 8, 0 , 12, 11};
        int [] input3 = {22, 3, 6, 1, 23, 4,3 , 7,27 ,12 ,123 };

        int[] answer1 = getAnswer(input1);
        int[] answer2 = getAnswer(input2);
        int[] answer3 = getAnswer(input3);

        Arrays.stream(answer1).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(answer2).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(answer3).forEach(i -> System.out.print(i + ", "));
        //when
        ComparisionSort comparisionSort = new ComparisionSort();
        comparisionSort.mergeSort(input1);
        comparisionSort.mergeSort(input2);
        comparisionSort.mergeSort(input3);
        System.out.println();

        Arrays.stream(input1).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(input2).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(input3).forEach(i -> System.out.print(i + ", "));


        //then
        IntStream.range(0, input1.length).forEach((i) -> assertThat(answer1[i]).isEqualTo(input1[i]));
        IntStream.range(0, input2.length).forEach((i) -> assertThat(answer2[i]).isEqualTo(input2[i]));
        IntStream.range(0, input3.length).forEach((i) -> assertThat(answer3[i]).isEqualTo(input3[i]));
    }

    @Test
    public void QuickSortTest() throws Exception{
        //given
        int [] input1 = {4, 6, 1, 2, 7 ,4 ,2, 1, 7, 2};
        int [] input2 = {3, 1 ,2 ,6, 7, 8, 0 , 12, 11};
        int [] input3 = {22, 3, 6, 1, 23, 4,3 , 7,27 ,12 ,123 };

        int[] answer1 = getAnswer(input1);
        int[] answer2 = getAnswer(input2);
        int[] answer3 = getAnswer(input3);

        Arrays.stream(answer1).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(answer2).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(answer3).forEach(i -> System.out.print(i + ", "));
        //when
        ComparisionSort comparisionSort = new ComparisionSort();
        comparisionSort.quickSort(input1);
        comparisionSort.quickSort(input2);
        comparisionSort.quickSort(input3);
        System.out.println();

        Arrays.stream(input1).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(input2).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(input3).forEach(i -> System.out.print(i + ", "));


        //then
        IntStream.range(0, input1.length).forEach((i) -> assertThat(answer1[i]).isEqualTo(input1[i]));
        IntStream.range(0, input2.length).forEach((i) -> assertThat(answer2[i]).isEqualTo(input2[i]));
        IntStream.range(0, input3.length).forEach((i) -> assertThat(answer3[i]).isEqualTo(input3[i]));
    }

    @Test
    public void BubbleSortTest() throws Exception{
        //given
        int [] input1 = {4, 6, 1, 2, 7 ,4 ,2, 1, 7, 2};
        int [] input2 = {3, 1 ,2 ,6, 7, 8, 0 , 12, 11};
        int [] input3 = {22, 3, 6, 1, 23, 4,3 , 7,27 ,12 ,123 };

        int[] answer1 = getAnswer(input1);
        int[] answer2 = getAnswer(input2);
        int[] answer3 = getAnswer(input3);

        Arrays.stream(answer1).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(answer2).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(answer3).forEach(i -> System.out.print(i + ", "));
        //when
        ComparisionSort comparisionSort = new ComparisionSort();
        comparisionSort.bubbleSort(input1);
        comparisionSort.bubbleSort(input2);
        comparisionSort.bubbleSort(input3);
        System.out.println();

        Arrays.stream(input1).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(input2).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(input3).forEach(i -> System.out.print(i + ", "));


        //then
        IntStream.range(0, input1.length).forEach((i) -> assertThat(answer1[i]).isEqualTo(input1[i]));
        IntStream.range(0, input2.length).forEach((i) -> assertThat(answer2[i]).isEqualTo(input2[i]));
        IntStream.range(0, input3.length).forEach((i) -> assertThat(answer3[i]).isEqualTo(input3[i]));
    }

    @Test
    public void SelectSortTest() throws Exception{
        //given
        int [] input1 = {4, 6, 1, 2, 7 ,4 ,2, 1, 7, 2};
        int [] input2 = {3, 1 ,2 ,6, 7, 8, 0 , 12, 11};
        int [] input3 = {22, 3, 6, 1, 23, 4,3 , 7,27 ,12 ,123 };

        int[] answer1 = getAnswer(input1);
        int[] answer2 = getAnswer(input2);
        int[] answer3 = getAnswer(input3);

        Arrays.stream(answer1).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(answer2).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(answer3).forEach(i -> System.out.print(i + ", "));
        //when
        ComparisionSort comparisionSort = new ComparisionSort();
        comparisionSort.selectSort(input1);
        comparisionSort.selectSort(input2);
        comparisionSort.selectSort(input3);
        System.out.println();

        Arrays.stream(input1).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(input2).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(input3).forEach(i -> System.out.print(i + ", "));


        //then
        IntStream.range(0, input1.length).forEach((i) -> assertThat(answer1[i]).isEqualTo(input1[i]));
        IntStream.range(0, input2.length).forEach((i) -> assertThat(answer2[i]).isEqualTo(input2[i]));
        IntStream.range(0, input3.length).forEach((i) -> assertThat(answer3[i]).isEqualTo(input3[i]));
    }


    @Test
    public void InsertSortTest() throws Exception{
        //given
        int [] input1 = {4, 6, 1, 2, 7 ,4 ,2, 1, 7, 2};
        int [] input2 = {3, 1 ,2 ,6, 7, 8, 0 , 12, 11};
        int [] input3 = {22, 3, 6, 1, 23, 4,3 , 7,27 ,12 ,123 };

        int[] answer1 = getAnswer(input1);
        int[] answer2 = getAnswer(input2);
        int[] answer3 = getAnswer(input3);

        Arrays.stream(answer1).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(answer2).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(answer3).forEach(i -> System.out.print(i + ", "));
        //when
        ComparisionSort comparisionSort = new ComparisionSort();
        comparisionSort.insertSort(input1);
        comparisionSort.insertSort(input2);
        comparisionSort.insertSort(input3);
        System.out.println();

        Arrays.stream(input1).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(input2).forEach(i -> System.out.print(i + ", "));
        Arrays.stream(input3).forEach(i -> System.out.print(i + ", "));


        //then
        IntStream.range(0, input1.length).forEach((i) -> assertThat(answer1[i]).isEqualTo(input1[i]));
        IntStream.range(0, input2.length).forEach((i) -> assertThat(answer2[i]).isEqualTo(input2[i]));
        IntStream.range(0, input3.length).forEach((i) -> assertThat(answer3[i]).isEqualTo(input3[i]));
    }

    private int [] getAnswer(int [] arr){
        int[] ret = Arrays.copyOf(arr, arr.length);
        Arrays.sort(ret);
        return ret;
    }


}