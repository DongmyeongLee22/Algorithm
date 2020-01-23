package programmers.lv2.inmd;

import org.junit.Test;
import programmers.lv2.EndingGame;

public class EndingGameTest {

    @Test
    public void as() throws Exception {
        EndingGame endingGame = new EndingGame();

        int[] solution = endingGame.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        int[] solution2 = endingGame.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
        int[] solution3 = endingGame.solution(2, new String[]{"land", "dream", "mom", "mom", "ror"});
        System.out.println(solution[0] + " " + solution[1]);
        System.out.println(solution2[0] + " " + solution2[1]);
        System.out.println(solution3[0] + " " + solution3[1]);
    }


}