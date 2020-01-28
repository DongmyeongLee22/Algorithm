package programmers.lv2;

import java.util.PriorityQueue;

public class RamenFac {
    public int solution(int stock, int[] dates, int[] supplies, int k) {

        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int index = 0;
        for (int i = 0; i < k; i++) {

            if (index != dates.length && i == dates[index]) {
                pq.add(supplies[index++]);
            }

            if (stock == 0) {
                stock += pq.poll();
                answer++;
            }

            stock--;
        }

        return answer;
    }
}
