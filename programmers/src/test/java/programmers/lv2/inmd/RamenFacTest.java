package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.RamenFac;

import static org.assertj.core.api.Assertions.assertThat;

public class RamenFacTest {

    RamenFac ramenFac = new RamenFac();

    @Test
    public void firstTest() throws Exception{
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int solution = ramenFac.solution(4, dates, supplies, 30);

        int[] dates2 = {4, 7, 10, 13, 17};
        int[] supplies2 = {10, 11, 13, 15, 40};
        int solution2 = ramenFac.solution(4, dates2, supplies2, 30);

        assertThat(solution).isEqualTo(2);
        assertThat(solution2).isEqualTo(3);
    }


}