package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.SequenceNum;

import static org.assertj.core.api.Assertions.assertThat;

public class SequenceNumTest {

    SequenceNum sequenceNum = new SequenceNum();

    @Test
    public void asd() throws Exception{
        assertThat(sequenceNum.solution(15)).isEqualTo(4);
    }


}