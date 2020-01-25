package programmers.lv2;

import javafx.scene.control.Alert;

import java.util.Arrays;

public class MakeMin {
    public int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int length = A.length;
        int answer = 0;

        for (int i = 0; i < length; i++) {
            int mux = A[i] * B[length - i - 1];
            answer += mux;
        }

        return answer;
    }
}
