package programmers.hash1;

import org.junit.Test;

import static org.junit.Assert.*;

public class SecretMapTest {

    @Test
    public void qwe() throws Exception{
        int a = 28;
        int b = 21;
        int c = 28 | 21;
        // 1 1 1 0 1
        // 0 0 0 0 1
        //

        // 1 1 1 0 1
        // 0 1 1 1 0
        // 0 0 1 1 1
        // 0 0 0 1 1
        // 0 0 0 0 1
        // 16 8 4 1 -> 29
        // 1 1 1 0 1 = 29 #
        // 0 1 1 1 0 - 14 " "
        // 0 0 1 1 1
        // 0 0 0 1 1
        // 0 0 0 0 1
        //
        System.out.println(c == 29);

        for(int i = 0; i < 5; i ++){
            if ((c & 1) == 1){
                System.out.print("#");
            }else {
                System.out.print(" ");
            }

            System.out.println(c);
            c = c >> 1;
        }
    }


}