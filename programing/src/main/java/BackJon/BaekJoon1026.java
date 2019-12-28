package BackJon;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1026 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int [] A = new int [n];
        int [] B = new int [n];

        for(int i = 0 ; i < n  ;i ++)
            A[i] = scanner.nextInt();

        for(int i = 0 ; i < n  ;i ++)
            B[i] = scanner.nextInt();

        scanner.close();

        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for(int i = 0 ; i < n ; i ++){
            sum += A[i]*B[n-1-i];
        }
        System.out.println(sum);
    }

}
