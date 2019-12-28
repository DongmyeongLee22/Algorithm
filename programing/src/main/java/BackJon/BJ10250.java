package BackJon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10250 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i =  0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int layer = Integer.parseInt(st.nextToken());
            int room = Integer.parseInt(st.nextToken());
            int guest = Integer.parseInt(st.nextToken());

            find_Room(layer, room, guest);
        }

    }

    private static void find_Room(int layer, int room, int guest) {

        int room_Number = (guest-1)/layer + 1;
        int layer_Number = guest % layer;

        if(layer_Number == 0)
            layer_Number = layer;

        if(room_Number < 10)
            System.out.println(layer_Number + "0" + room_Number);
        else
            System.out.println(layer_Number + "" + room_Number);

    }

}
