package BackJon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1003 {



    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] data = new int[n];
        int[][] count = new int[41][2];

        for (int i = 0; i < count.length; i++) {

            if (i == 0) {
                count[i][0] = 1;
                count[i][1] = 0;
            } else if (i == 1) {
                count[i][0] = 0;
                count[i][1] = 1;
            } else {
                count[i][0] = count[i - 2][0] + count[i - 1][0];
                count[i][1] = count[i - 2][1] + count[i - 1][1];
            }
        }

        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(reader.readLine());
        }

        for(int i : data)
            System.out.println(count[i][0] + " " + count[i][1]);

        reader.close();

    }
}

