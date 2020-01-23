package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.MakeDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeDecimalTest {

    @Test
    public void decimal() throws Exception{
        //given
        MakeDecimal makeDecimal = new MakeDecimal();
        int four = makeDecimal.solution(new int[]{1, 2, 7, 6, 4});

        assertThat(four).isEqualTo(4);
    }


}