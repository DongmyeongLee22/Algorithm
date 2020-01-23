package programmers.hash1;

import java.util.ArrayList;
import java.util.List;

public class FailPer {

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int player = stages.length;
        int[] stagePlayers = new int[N + 1];

        for (int stage : stages) {
            stagePlayers[stage - 1]++; // 각 스테이지에 존재하는 사람의 수
        }

        List<PerStage> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (stagePlayers[i] == 0) {
                list.add(new PerStage(0, i));
            } else {
                double failPer = stagePlayers[i] / (double) player;
                list.add(new PerStage(failPer, i));
            }
            player -= stagePlayers[i];
        }


        list.sort((a, b) -> Double.compare(b.failPer, a.failPer));

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).state + 1;
        }

        return answer;
    }

    class PerStage {

        double failPer;
        int state;

        public PerStage(double failPer, int state) {
            this.failPer = failPer;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        FailPer failPer = new FailPer();

        failPer.solution(7, new int[]{3, 3, 2, 4, 7, 8, 2, 6, 7});
    }


}
