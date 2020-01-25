package programmers.lv2;

public class KakaoBook {

    public int[] solution(int m, int n, int[][] picture) {

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int flag = picture[i][j];
                if (flag == 0 || flag == -1) continue;

                int count = countArea(picture, flag, i, j);
                if (count > 0) numberOfArea++;
                if (count > maxSizeOfOneArea) maxSizeOfOneArea = count;
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private int countArea(int[][] picture, int flag, int row, int col) {

        if (row < 0 || row >= picture.length
                || col < 0 || col >= picture[0].length) return 0;

        int now = picture[row][col];

        if (now != flag) return 0;
        picture[row][col] = -1;


        return  countArea(picture,flag, row - 1, col) +
                countArea(picture,flag, row, col - 1) +
                countArea(picture,flag, row + 1, col) +
                countArea(picture,flag, row, col + 1) +
                1;
    }

}
