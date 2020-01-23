package programmers.lv2;

import org.junit.Test;

public class TruckTest {

    @Test
    public void sad() throws Exception{

        Truck truck = new Truck();

        truck.solution(100, 100 , new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
    }


}