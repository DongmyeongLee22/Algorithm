package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.MinMaxSpace;

import static org.assertj.core.api.Assertions.assertThat;

public class MinMaxSpaceTest {
    @Test
    public void asd() throws Exception{
        //given

        MinMaxSpace minMaxSpace = new MinMaxSpace();
        assertThat(minMaxSpace.solution("1 2 3 4")).isEqualTo("1 4");
        assertThat(minMaxSpace.solution("-1 -2 -3 -4")).isEqualTo("-4 -1");
        assertThat(minMaxSpace.solution("-1 -1")).isEqualTo("-1 -1");
        //when

        //then
    }


}