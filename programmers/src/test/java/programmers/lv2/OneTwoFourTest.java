package programmers.lv2;

import org.junit.Test;

import java.util.stream.IntStream;

public class OneTwoFourTest {

    @Test
    public void asd() throws Exception {
        OneTwoFour oneTwoFour = new OneTwoFour();
        System.out.println(oneTwoFour.solution(3));
        StringBuilder builder = new StringBuilder();
        oneTwoFour.solution(9);
        IntStream.rangeClosed(1, 100).forEach(i -> System.out.println(oneTwoFour.solution(i)));
    }


}