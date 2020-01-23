package reviewCracking.ch1;

public class Pblms {
    public boolean rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int j = first; j < last; j++) {
                int offset = j - first;

                int top = matrix[first][j];

                matrix[first][j] = matrix[last - offset][first];

                matrix[last - offset][first] = matrix[last][last - offset];

                matrix[last][last - offset] = matrix[j][last];

                matrix[j][last] = top;

            }
        }
        return true;
    }

    public void makeZeros(int[][] matrix) {
        boolean isRowZero = false;
        boolean isColZero = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isColZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                isRowZero = true;
                break;
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                makeRowZeros(matrix, i);
            }
        }

        for(int i = 0; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                makeColZeros(matrix, i);
            }
        }

        if (isRowZero){
            makeRowZeros(matrix, 0);
        }

        if (isColZero){
            makeColZeros(matrix, 0);
        }

    }

    private void makeColZeros(int[][] matrix, int i) {
        for(int j = 0 ; j < matrix.length; j++){
            matrix[j][i] = 0;
        }
    }

    private void makeRowZeros(int[][] matrix, int i) {
        for(int j = 0 ; j < matrix[0].length; j++){
            matrix[i][j] = 0;
        }
    }
}
