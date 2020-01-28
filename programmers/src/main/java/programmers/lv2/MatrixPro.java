package programmers.lv2;

public class MatrixPro {

    /*

        1 4                 15 15
        3 2      3 3        15 15
        4 1      3 3        15 15

        2 3 2  5 4 3
        4 2 4  2 4 1
        3 1 4  3 1 1


     */

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                for (int z = 0; z < arr2[j].length; z++) {
                    answer[i][z] += arr1[i][j] * arr2[j][z];
                }
            }

        }

        return answer;
    }
}
