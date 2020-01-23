package programmers.lv2;

import org.junit.Test;

public class BigNumberTest {

    @Test
    public void test() throws Exception{
        BigNumber bigNumber = new BigNumber();

        System.out.println(bigNumber.solution(new int[]{3, 30, 34, 5, 9, 20, 10, 11, 1}));
        System.out.println(bigNumber.solution(new int[]{0, 0, 0, 0}));
        System.out.println(bigNumber.solution(new int[]{000, 0, 0, 0}));
        System.out.println(bigNumber.solution(new int[]{000, 0, 0, 0}));
        System.out.println(bigNumber.solution(new int[]{00, 00, 0, 0}));
        System.out.println(bigNumber.solution(new int[]{12, 121}));

        // 9 5 34 3 30 20 11 1 10
    }


}