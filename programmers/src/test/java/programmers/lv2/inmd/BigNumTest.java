package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.BigNum;

import static org.assertj.core.api.Assertions.assertThat;

public class BigNumTest {

    @Test
    public void asd() throws Exception {
        //given
        BigNum bigNum = new BigNum();
        String solution = bigNum.solution("4177252841", 4);
        String solution1 = bigNum.solution("1924", 2);
        String solution2 = bigNum.solution("1231234", 3);
        String solution3 = bigNum.solution("10000", 2);
        assertThat(solution).isEqualTo("775841");
        assertThat(solution1).isEqualTo("94");
        assertThat(solution2).isEqualTo("3234");
        assertThat(solution3).isEqualTo("89124");


        //when

        //then
    }


}