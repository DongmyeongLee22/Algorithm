package programmers.hash1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaratonTest {

    @Test
    public void test() throws Exception{
        //given
        String [] par = {"A", "B", "A", "B", "C"};
        String [] com = {"A", "B", "A","C"};

        Maraton maraton = new Maraton();
        String solution = maraton.solution(par, com);
        assertThat(solution).isEqualTo("B");


        String [] par1 = {"A", "B", "A", "C"};
        String [] com1= {"A", "A","C"};
        String solution1 = maraton.solution(par1, com1);
        assertThat(solution1).isEqualTo("B");

        String [] par2 = {"leo", "kiki", "eden"};
        String [] com2 = {"kiki", "eden"};
        String solution2 = maraton.solution(par2, com2);
        assertThat(solution2).isEqualTo("leo");


    }


}