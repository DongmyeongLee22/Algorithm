package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.BigSquare;

public class BigSquareTest {

    BigSquare bigSquare = new BigSquare();

    @Test
    public void firstTest() throws Exception {
        int solution = bigSquare.solution(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 1, 1}
        });

        int[][] ints = {
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };

        System.out.println(bigSquare.solution2(ints));




    }


}