package cracking.recursionanddynamic;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FiboAndStepTest {

    private FiboAndStep fiboAndStep = new FiboAndStep();

    @Test
    public void timeTest() {


        long start = System.currentTimeMillis();
        int fibonacci = fiboAndStep.fibonacci(30);
        long end = System.currentTimeMillis();
        System.out.println(fibonacci + " 재귀 시간 -> " + (end - start));
        long recursionTime = end - start;

        start = System.currentTimeMillis();
        fibonacci = fiboAndStep.fibonacci1(30);
        end = System.currentTimeMillis();
        System.out.println(fibonacci + "메모이제이션 시간" + (end - start));
        long memoizationTime = end - start;

        start = System.currentTimeMillis();
        fibonacci = fiboAndStep.fibonacci2(30);
        end = System.currentTimeMillis();
        System.out.println(fibonacci + "동적 시간" + (end - start));
        long dynamicTime = end - start;

        start = System.currentTimeMillis();
        fibonacci = fiboAndStep.fibonacci3(30);
        end = System.currentTimeMillis();
        System.out.println(fibonacci + "동적2 시간" + (end - start));
        long dynamic2Time = end - start;


    }

    @Test
    public void countingStep() throws Exception {
        int step1 = fiboAndStep.countStep(4);
        int step2 = fiboAndStep.countStep(5);
        assertThat(step1).isEqualTo(7);
        assertThat(step2).isEqualTo(13);

        int memo1 = fiboAndStep.countStempMemo(4);
        int memo2 = fiboAndStep.countStempMemo(5);
        assertThat(memo1).isEqualTo(step1);
        assertThat(memo2).isEqualTo(step2);


    }


}