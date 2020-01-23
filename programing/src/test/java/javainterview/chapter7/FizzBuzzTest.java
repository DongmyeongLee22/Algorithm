package javainterview.chapter7;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {
    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void fizzBuzz() throws Exception {


        List<String> strings = fizzBuzz.makeFizzBuzz(30);

        strings.forEach(System.out::println);
    }

    @Test
    public void fibo() throws Exception {
        assertThat(fizzBuzz.fibo(0)).isEqualTo(new int[]{});
        assertThat(fizzBuzz.fibo(1)).isEqualTo(new int[]{0});
        assertThat(fizzBuzz.fibo(2)).isEqualTo(new int[]{0, 1});
        assertThat(fizzBuzz.fibo(3)).isEqualTo(new int[]{0, 1, 1});
        assertThat(fizzBuzz.fibo(5)).isEqualTo(new int[]{0, 1, 1, 2, 3});
        assertThat(fizzBuzz.fibo(7)).isEqualTo(new int[]{0, 1, 1, 2, 3, 5, 8});
    }

    @Test
    public void fibovalue() throws Exception {
        long start = System.nanoTime();
        assertThat(fizzBuzz.fiboRecursion(45)).isEqualTo(1134903170);
        long end = System.nanoTime();
        System.out.println("재귀 시간 : " + (end - start));

        start = System.nanoTime();
        assertThat(fizzBuzz.fiboDinamic(45)).isEqualTo(1134903170);
        end = System.nanoTime();
        System.out.println("일반 동적 프로그래밍 시간 : " + (end - start));

        start = System.nanoTime();
        assertThat(fizzBuzz.fiboBest(45)).isEqualTo(1134903170);
        end = System.nanoTime();
        System.out.println("최상의 방법의 시간 : " + (end - start));
    }

    @Test
    public void fact() throws Exception {
        assertThat(fizzBuzz.facto(1)).isEqualTo(1);
        assertThat(fizzBuzz.facto(2)).isEqualTo(2);
        assertThat(fizzBuzz.facto(3)).isEqualTo(6);
        assertThat(fizzBuzz.facto(4)).isEqualTo(24);
        assertThat(fizzBuzz.facto(5)).isEqualTo(120);
    }


@Test
public void reverse() throws Exception{
    String str1 = "abcde";
    String str2 = "acxqwe";
    assertThat(fizzBuzz.reverse(str1)).isEqualTo(new StringBuilder(str1).reverse().toString());
    assertThat(fizzBuzz.reverse(str2)).isEqualTo(new StringBuilder(str2).reverse().toString());
}



}