package programmers.lv2;

import java.util.PriorityQueue;

public class MoreHot {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);

        for (int i : scoville) {
            pq.add(i);
        }

        while(!pq.isEmpty() && pq.peek() < K){
            int firstMin = pq.poll();
            if (!pq.isEmpty()){
                int secondMin = pq.poll();
                pq.add(firstMin + secondMin * 2);
                answer++;
            }else{
                return -1;
            }
        }

        return answer;
    }
}
