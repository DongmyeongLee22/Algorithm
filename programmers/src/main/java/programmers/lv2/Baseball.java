package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Baseball {
    public int solution(int[][] baseball) {
        int answer = 0;
        Queue<String> numbers = getAllPossible();
        while (!numbers.isEmpty()) {
            String curNumbers = numbers.poll();
            if (isAnswerable(baseball, curNumbers)) answer++;
        }
        return answer;
    }

    private boolean isAnswerable(int[][] baseball, String curNumbers) {
        for (int[] game : baseball) {
            String target = String.valueOf(game[0]);
            int targetStrike = game[1];
            int targetBall = game[2];

            int myStrike = 0, myBall = 0;

            for (int i = 0; i < target.length(); i++) {
                if (curNumbers.charAt(i) == target.charAt(i)) myStrike++;
                else if (isContain(curNumbers, target.charAt(i))) myBall++;
            }

            if (targetStrike != myStrike || targetBall != myBall) return false;

        }
        return true;
    }

    private boolean isContain(String curNumbers, char charAt) {
        for (char c : curNumbers.toCharArray()) {
            if (c == charAt) return true;
        }
        return false;
    }

    public Queue<String> getAllPossible() {
        return initPossible();
    }

    private Queue<String> initPossible() {
        Queue<String> ret = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i == j || i == k || j == k) continue;
                    ret.add(String.valueOf((i * 100) + (j * 10) + k));
                }
            }
        }
        return ret;
    }
}
