package BackJon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TwoOneZeroEight {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int sum = 0, max = -4001, min = 4001, temp = 0;
        int [] count = new int [8001];
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(reader.readLine());
            sum += temp;
            if (min > temp)
                min = temp;
            if (max < temp)
                max = temp;
            count[temp+4000]++;

        }
        reader.close();

        System.out.println(Math.round((double) sum / n));

        int c = 0,half = 0;
        boolean isboolean = true;
        sum = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= 8000; i++) {
            if(c < count[i]){
                c = count[i];
                list.clear();
                list.add(i);
            }else if(c == count[i]){
                list.add(i);
            }
            sum += count[i];
            if(isboolean && sum >= (n/2)+1) {
                half = i-4000;
                isboolean = false;
            }
        }

        System.out.println(half);
        int value = 0;
        if(list.size()==1) {
            value = list.get(0) - 4000;
        }else{
            value = list.get(1) - 4000;
        }


        System.out.println(value);
        System.out.println(max - min);

    }

}
