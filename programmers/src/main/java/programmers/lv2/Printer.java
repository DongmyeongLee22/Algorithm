package programmers.lv2;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        for (int priority : priorities) {
            pq.add(priority);

        }

        while (!pq.isEmpty()){
            for(int i = 0 ; i < priorities.length; i++){
                if (pq.peek() == priorities[i]){
                    pq.poll();
                    answer++;
                    if (location == i){
                        pq.clear();
                        break;
                    }
                }
            }
        }

        return answer;
    }

}
