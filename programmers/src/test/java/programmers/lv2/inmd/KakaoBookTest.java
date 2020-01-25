package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.KakaoBook;

import static org.assertj.core.api.Assertions.*;

public class KakaoBookTest {

    @Test
    public void test() throws Exception {
        //given
        KakaoBook kakaoBook = new KakaoBook();
        int[][] arr = new int[][]{
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1}
        };

        int[][] ints = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

        int[] solution = kakaoBook.solution(6, 4, arr);
        int[] solution2 = kakaoBook.solution(6, 4, ints);

        //when
        assertThat(solution).isEqualTo(new int[]{2, 6});
        assertThat(solution2).isEqualTo(new int[]{4, 5});
        //then
        int[][] ints1 = {
                {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                {1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}
        };

        int[] answer = kakaoBook.solution(ints1.length, ints1[0].length, ints1);
        assertThat(answer).isEqualTo(new int[]{16, 126});
        System.out.println(answer[0]);
        System.out.println(answer[1]);

        int[][] sol22 = {{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0}, {
                0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {
                0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0}, {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0}, {
                0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {
                0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};

        long start = System.nanoTime();
        long end = System.nanoTime();
        System.out.println("시간: " + (end - start));

        start = System.nanoTime();
        int[] solution1 = kakaoBook.solution(13, 16, sol22);
        end = System.nanoTime();
        System.out.println("시간: " + (end - start));
    }

    @Test
    public void asd() throws Exception{
        //given
        int[][] ints = new int[100][100];
        KakaoBook kakaoBook = new KakaoBook();
        ints[1][1] = 1;
        ints[11][1] = 1;
        ints[13][1] = 1;
        ints[15][1] = 1;

        int[] solution = kakaoBook.solution(100, 100, ints);

        assertThat(solution).isEqualTo(new int[]{4, 1});

        //when

        //then
    }

}