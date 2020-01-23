package programmers.lv2;

import org.junit.Test;

public class HIndexTest {

    @Test
    public void te() throws Exception{
        HIndex hIndex = new HIndex();

        System.out.println(hIndex.solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(hIndex.solution(new int[]{7}));
        System.out.println(hIndex.solution(new int[]{22, 42}));
        System.out.println(hIndex.solution(new int[]{22, 43, 22, 11, 21, 12}));
        System.out.println(hIndex.solution(new int[]{3, 3, 3, 3, 3, 3,3 ,3}));
        System.out.println(hIndex.solution(new int[]{3, 3, 3, 4, 4, 4,4 , 2, 2, 2, 1, 1, 1}));
        System.out.println(hIndex.solution(new int[]{20, 19, 18, 1}));
    }


}