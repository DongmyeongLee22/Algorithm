package programmers.lv2;

// 탑
public class Top {

    // [6,9,,75,4]	[0,0,2,2,4]
    public int[] solution(int[] heights) {
        int[] ret = new int[heights.length];

        ret[0] = 0;

        for (int i = heights.length - 1; i > 0; i--) {
            int height = heights[i];
            for (int j = i - 1; j >= 0; j--) {

                if (heights[j] > height) {
                    ret[i] = j + 1;
                    break;
                }

                if (j == 0) ret[i] = 0;
            }
        }

        return ret;
    }

    class Value {
        int height;
        int index;

        public Value(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

}
