package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int index = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (Integer integer : prices) {
            queue.add(integer);
        }

        while (!queue.isEmpty()) {
            Integer value = queue.poll();
            int count = 0;
            for (int i = index + 1; i < prices.length; i++) {
                count++;
                if (value > prices[i]) break;
            }
            answer[index++] = count;
        }

        return answer;
    }

    public int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            int value = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (value > prices[j]) break;
            }
            answer[i] = count;
        }

        return answer;
    }
}
