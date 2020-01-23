package programmers.hash1;

import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void test() throws Exception {
        long n = 25;

        double sqrt = Math.sqrt(n);

        double v = sqrt - (int) sqrt;
        System.out.println(v);
        System.out.println(sqrt == (int) sqrt);
        System.out.println(v == 0);
    }


}