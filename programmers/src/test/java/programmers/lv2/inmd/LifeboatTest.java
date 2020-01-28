package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.Lifeboat;

import static org.assertj.core.api.Assertions.assertThat;

public class LifeboatTest {
    Lifeboat lifeboat = new Lifeboat();

    @Test
    public void firstTest() throws Exception{
        //given
        int solution = lifeboat.solution(new int[]{70, 50, 80, 50}, 100);
        assertThat(solution).isEqualTo(3);

        int solution2 = lifeboat.solution(new int[]{10, 20, 20, 20, 30, 30, 30, 40, 50, 50}, 100);
        assertThat(solution2).isEqualTo(5);
        //then
    }


}