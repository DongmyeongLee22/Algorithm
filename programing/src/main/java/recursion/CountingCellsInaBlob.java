package recursion;

public class CountingCellsInaBlob {
    private static int BACKGROUND_COLOR = 0;
    private static int IMAGE_COLOR = 1;
    private static int COUNTED_COLOR = 2;

    private static int N = 8;
    private static int[][] grid = {
            {1, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 1, 1},
    };


    private static int countBlob(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N)
            return 0;
        else if (grid[x][y] != IMAGE_COLOR) {
            return 0;
        } else {
            grid[x][y] = COUNTED_COLOR;
            return 1 + countBlob(x - 1, y) + countBlob(x - 1, y + 1)
                    + countBlob(x, y + 1) + countBlob(x + 1, y + 1)
                    + countBlob(x + 1, y) + countBlob(x + 1, y - 1)
                    + countBlob(x, y - 1) + countBlob(x - 1, y - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(countBlob(3, 5));
    }
}
