package BackJon;

import java.util.Scanner;

public class BJ2292 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum =1;
        int count = 1;

        while(n>sum){
            sum += (6 * count++);
        }

        System.out.println(count);
    }
}
