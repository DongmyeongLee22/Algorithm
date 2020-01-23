package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.NextBigger;

public class NextBiggerTest {
    @Test
    public void test() throws Exception{
        //given
        NextBigger bigger = new NextBigger();
        int an1 = 78;
        int so1 = bigger.solution(an1);
        System.out.println(so1);
        System.out.println(Integer.toBinaryString(an1));
        System.out.println(Integer.toBinaryString(so1));
        int n2 = 15;
        int so2 = bigger.solution(n2);
        System.out.println(so2);
        System.out.println(Integer.toBinaryString(n2));
        System.out.println(Integer.toBinaryString(so2));



        //then
    }

    @Test
    public void te() throws Exception{
        //given
        int i = Integer.parseInt("111111100000", 2);
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(-i));
        System.out.println(Integer.toBinaryString(i & -i));

        //when

        //then
    }


}