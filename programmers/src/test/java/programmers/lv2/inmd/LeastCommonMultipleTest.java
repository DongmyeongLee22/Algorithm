package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.LeastCommonMultiple;

import static org.assertj.core.api.Assertions.assertThat;

public class LeastCommonMultipleTest {

    @Test
    public void te() throws Exception {
        //given
        LeastCommonMultiple multiple = new LeastCommonMultiple();
        int solution = multiple.solution(new int[]{2, 6, 8, 14});
        int solution2 = multiple.solution(new int[]{1, 2, 3});

        assertThat(solution).isEqualTo(168);
        assertThat(solution2).isEqualTo(6);
    }


}