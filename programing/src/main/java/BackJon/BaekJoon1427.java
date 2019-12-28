package BackJon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaekJoon1427 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0 ; i < input.length(); i++)
            list.add(input.charAt(i) - 48);

        Collections.sort(list);

        for (int i = list.size()-1; i>=0;i--) {
            System.out.print(list.get(i));
        }
        reader.close();
    }

}
