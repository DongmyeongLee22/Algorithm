package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.JaDenCase;

import static org.assertj.core.api.Assertions.assertThat;

public class JaDenCaseTest {

    @Test
    public void asd() throws Exception{
        JaDenCase jaDenCase = new JaDenCase();
        String solution = jaDenCase.solution("3people unFollowed me");
        assertThat(solution).isEqualTo("3people Unfollowed Me");

        String solution2 = jaDenCase.solution("for the last week");
        assertThat(solution2).isEqualTo("For The Last Week");

        System.out.println(jaDenCase.solution("FOR tAS lASDst weASk"));
        System.out.println(jaDenCase.solution("for the last week "));
    }


}