package programmers.lv2;

public class BigSquare {

    public int solution(int[][] board) {
        int[][] square = new int[board.length][board[0].length];
        int max = 0;

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[0].length; j++) {
                square[i][j] = board[i][j];
            }
        }

        for (int i = 1; i < square.length; i++) {
            for (int j = 1; j < square[0].length; j++) {

                if (square[i][j] == 0) square[i][j] = 0;

                else square[i][j] = Math.min(square[i - 1][j], Math.min(square[i - 1][j - 1], square[i][j - 1])) + 1;

                if (square[i][j] > max) max = square[i][j];
            }
        }

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[0].length; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();

        }
        return max * max;
    }

    public int solution2(int[][] board) {

        int[][] square = new int[board.length][board[0].length];
        int max = 0;

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[0].length; j++) {
                if (i == 0) {
                    square[i][j] = board[i][j];
                } else if (j == 0) {
                    square[i][j] = board[i][j];
                } else {
                    square[i][j] = board[i][j] == 0 ? 0 : Math.min(square[i - 1][j], Math.min(square[i - 1][j - 1], square[i][j - 1])) + 1;
                }
                max = Math.max(max, square[i][j]);
            }
        }
        return max * max;
    }

}
