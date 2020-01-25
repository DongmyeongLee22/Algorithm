package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.Baseball;

import java.util.Queue;

public class BaseballTest {

    Baseball baseball = new Baseball();
    @Test
    public void initTEst() throws Exception{
        //given
        Queue<String> allPossible = baseball.getAllPossible();

        while (!allPossible.isEmpty()){
            System.out.println(allPossible.poll());
        }
        //when

        //then
    }

    @Test
    public void test() throws Exception{
        //given


        //when

        //then
    }



}