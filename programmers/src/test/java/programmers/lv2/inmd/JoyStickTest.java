package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.JoyStick;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class JoyStickTest {

    JoyStick joyStick = new JoyStick();

    @Test
    public void alphaTest() throws Exception {
        char a = 'A';
        char z = 'B';

        System.out.println((int) a);
        System.out.println((int) z);

        // 26 개
        // JEROEN
        IntStream.rangeClosed(0, 28).forEach(i -> {
            System.out.println(i + ": -> " + (char) (i + 65));
        });

        // JEROEN
        // 9
        // 1 + 4
        // 1 + 9
        // 1 + 12
        // 1 + 4
        // 1 + 13

        assertThat((91 - (int) 'R')).isEqualTo(9);
    }

    @Test
    public void jumpCountTest() throws Exception {
        int jeroen = joyStick.solution("JEROEN");
        assertThat(jeroen).isEqualTo(56);

        int a = joyStick.solution("AAABA");
        assertThat(a).isEqualTo(3);


    }

    @Test
    public void get() throws Exception{
        //given
        int a = joyStick.getCharCount('A');
        int b = joyStick.getCharCount('B');
        int c = joyStick.getCharCount('C');
        int r = joyStick.getCharCount('R');

        assertThat(a).isEqualTo(0);
        assertThat(b).isEqualTo(1);
        assertThat(c).isEqualTo(2);
        assertThat(r).isEqualTo(9);


    }


}