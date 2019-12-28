package BackJon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1011 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(rd.readLine());


        for(int i = 0 ; i < n ; i ++){
            StringTokenizer st = new StringTokenizer(rd.readLine());
                int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            min_Distance(end - start);
        }
        rd.close();


    }

    private static void min_Distance(int value) {
        int sqrt = (int) Math.ceil(Math.sqrt(value));
        if(value <= sqrt*sqrt - sqrt){
            System.out.println(sqrt*2-2);
        }else{
            System.out.println(sqrt*2-1);
        }
    }
}
