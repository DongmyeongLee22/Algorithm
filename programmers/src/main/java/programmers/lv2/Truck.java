package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {



        int time = 0;
        int index = 0;
        Queue<Value> queue = new LinkedList<>();

        int truck_weight = truck_weights[index++];
        queue.add(new Value(truck_weight, bridge_length));
        weight -= truck_weight;


        while (!queue.isEmpty()){

            time ++;

            if (queue.peek().endTime == time){
                weight += queue.poll().weigh;
            }

            if (index < truck_weights.length && truck_weights[index] <= weight){
                int t_weight = truck_weights[index++];
                weight -= t_weight;
                queue.add(new Value(t_weight, time + bridge_length));
            }

        }

        return time + 1;
    }


    class Value{
        int weigh;
        int endTime;

        public Value(int weigh, int endTime) {
            this.weigh = weigh;
            this.endTime = endTime;
        }
    }
}
