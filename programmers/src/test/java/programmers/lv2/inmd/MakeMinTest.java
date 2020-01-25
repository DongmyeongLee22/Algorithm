package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.MakeMin;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeMinTest {

    @Test
    public void test() throws Exception{
        //given
        MakeMin makeMin = new MakeMin();
        int solution = makeMin.solution(new int[]{1, 4, 2},
                new int[]{5, 4, 4});

        assertThat(solution).isEqualTo(29);

        int solution2 = makeMin.solution(new int[]{1, 2},
                new int[]{3, 4});

        assertThat(solution2).isEqualTo(10);
    }


}