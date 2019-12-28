package recursion;

public class Recursion1 {

    private int sumEx(int n) {
        if (n == 0)
            return 0;
        else
            return n + sumEx(n - 1);
    }

    private int Factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * Factorial(n - 1);
    }

    private int PowerEx(int x, int n) {
        if (n == 0)
            return 1;
        else
            return x * PowerEx(x, n - 1);
    }

    // F(0) -> 0
    // F(1) -> 1
    // F(n) -> F(n-1) + F(n-2)
    private int FibonacciSeq(int n) {
//        if(n==0)
//            return 0;
//        else if(n==1)
//            return 1;
//
        if (n < 2)
            return n;
        else
            return FibonacciSeq(n - 1) + FibonacciSeq(n - 2);
    }

    //최대공약수는 한번 더 보기
    private int GreatestCommonDivisor(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (a % b == 0)
            return b;
        else
            return GreatestCommonDivisor(b, a%b);
    }

    //순환의 규칙1: 적어도 하나의 base case 가 존재하여야 한다.
    //순환의 규칙2: 모든 case 는 결국 base case 로 수렴하여야 한다.


    public static void main(String[] args) {
        // write your code here
        Recursion1 recursion1 = new Recursion1();
        System.out.println("sum rescursion: " + recursion1.sumEx(5));
        System.out.println("Factorial recursion: " + recursion1.Factorial(5));
        System.out.println(recursion1.PowerEx(2, 5));
        System.out.println(recursion1.FibonacciSeq(5));
        System.out.println(recursion1.GreatestCommonDivisor(25,15));
    }
}
