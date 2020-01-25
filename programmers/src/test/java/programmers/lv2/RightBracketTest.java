package programmers.lv2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RightBracketTest {

    RightBracket rightBracket = new RightBracket();

    @Test
    public void setRightBracket() throws Exception {
        assertThat(rightBracket.solution("()()")).isTrue();
        assertThat(rightBracket.solution("()())()")).isFalse();
        assertThat(rightBracket.solution("()(((())))")).isTrue();
    }


}