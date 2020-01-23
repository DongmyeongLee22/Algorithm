package programmers.lv2;

import org.junit.Test;

public class TargetNumTest {

    @Test
    public void ts() throws Exception{

        TargetNum targetNum = new TargetNum();

        System.out.println(targetNum.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }


}