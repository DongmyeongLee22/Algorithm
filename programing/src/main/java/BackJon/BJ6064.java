package BackJon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ6064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i ++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            find_Number(M,N,x,y);
        }

        br.close();
    }

    private static void find_Number(int m, int n, int x, int y) {
        int count = x;
        int temY = x;

        for(int i = 0 ; i < n ; i++){

            temY = temY % n == 0 ? n : temY % n;

            if(temY == y)
                break;

            temY += m;
            count += m;
        }

        int lcm = lcm_get(m,n);

        count = count > lcm ? -1 : count;

        System.out.println(count);
    }

    private static int lcm_get(int m, int n) {
        return (m*n)/gcd_get(m,n);
    }

    private static int gcd_get(int m, int n) {
        while(n!=0){
            int temp = m%n;
            m = n;
            n = temp;
        }
        return m;
    }
}
