import programmers.lv1.StringZip;
import org.junit.Test;

public class StringZipTest {

    @Test
    public void qwd() throws Exception{

        StringZip stringZip = new StringZip();

        String asd = "ababcdcdababcdcd";
        String ft = "abcabcabcabcdededededede";
        String se = "aabbaccc";
        String tt ="xababcdcdababcdcd";
        System.out.println(stringZip.solution(asd));
        System.out.println(stringZip.solution(ft));
        System.out.println(stringZip.solution(se));
        System.out.println(stringZip.solution(tt));

    }


}