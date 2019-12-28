package BackJon;

import java.util.Scanner;

public class BJ2839 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int box = 0;

        while(n>0){

            if(n%5 == 0){
               box += n/5;
               n %= 5;
            }
            else if(n<3){
                n -= 3;
                box = -1;
            }
            else{
                n -= 3;
                box++;
            }


        }

        System.out.println(box);
    }
}
