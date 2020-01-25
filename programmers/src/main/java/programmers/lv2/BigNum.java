package programmers.lv2;

import java.util.PriorityQueue;

public class BigNum {

    public String solution(String number, int k) {

        PriorityQueue<NumberInfo> pq = new PriorityQueue<>((a, b) -> {
            if (a.value == b.value) {
                return a.index - b.index;
            } else {
                return b.value - a.value;
            }
        });
        StringBuilder builder = new StringBuilder();
        int count = 0;
        int minIndex = 0;
        char[] chars = number.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i] - 48;
            pq.add(new NumberInfo(num, i));
            if (count == k) {
                NumberInfo poll = pq.poll();
                while (!pq.isEmpty()){
                    if (poll.index > minIndex) break;
                    poll = pq.poll();
                }
                    builder.append(poll.value);
                    minIndex = poll.index;
            } else {
                count++;
            }
        }

        return builder.toString();
    }

    class NumberInfo {
        int value;
        int index;

        public NumberInfo(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
