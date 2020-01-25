package programmers.lv1;

import org.junit.Test;
import programmers.lv2.Ka2020OpenClose;
import programmers.lv2.Ka2020OpenClose2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Ka2020OpenCloseTest {


    private Ka2020OpenClose2 ka2020OpenClose = new Ka2020OpenClose2();

    @Test
    public void asd() throws Exception{
        String solution = ka2020OpenClose.solution("(()())()");
        assertThat(solution).isEqualTo("(()())()");

        String solution2 = ka2020OpenClose.solution(")(");
        assertThat(solution2).isEqualTo("()");

        String solution3 = ka2020OpenClose.solution("()))((()");
        assertThat(solution3).isEqualTo("()(())()");
    }



    @Test
    public void as21d() throws Exception{
        //given
        String s = "1234";
        System.out.println(s.substring(0, 4));
        System.out.println(s.substring(4));

        //when

        //then
    }


}