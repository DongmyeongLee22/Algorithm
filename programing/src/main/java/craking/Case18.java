package craking;

public class Case18 {

    void setZeros(int [][] matrix){
        boolean [] row = new boolean [matrix.length];
        boolean [] col = new boolean [matrix[0].length];

        for(int i = 0 ; i < row.length; i ++){
            for(int j = 0 ; j < col.length; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0 ; i < row.length; i ++) {
            if (row[i])
                rowSetZeros(matrix,i);
        }


        for(int i = 0 ; i < col.length; i ++) {
            if (col[i])
                colSetZeros(matrix,i);
        }
    }

    private void rowSetZeros(int[][] matrix, int row) {
        for(int i = 0 ; i < matrix[0].length;i ++){
            matrix[row][i] = 0;
        }
    }

    private void colSetZeros(int[][] matrix, int col) {
        for(int i = 0 ; i < matrix.length ; i ++){
            matrix[i][col] = 0;
        }
    }

    void setasdada(int [][] matrix){
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for(int i = 0 ; i  < matrix.length ; i++){
            if(matrix[i][0] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for(int i = 0 ; i < matrix[0].length; i++){
            if(matrix[0][i] == 0 ) {
                firstColZero = true;
                break;
            }
        }


        for(int i = 0 ; i < matrix.length; i ++){
            for(int j = 0 ; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1 ; i < matrix.length; i++){
            if(matrix[i][0] == 0 )
                rowSetZeros(matrix,i);
        }

        for(int i = 1 ; i < matrix[0].length; i ++){
            if(matrix[0][i] == 0 )
                colSetZeros(matrix,i);
        }

        if(firstColZero)
            rowSetZeros(matrix,0);

        if(firstRowZero)
            colSetZeros(matrix,0);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {11, 22, 33, 44},
                {55, 66, 77, 88},
                {99, 10 ,35, 12},
                {0, 14, 15 ,16}
        };

        for(int i = 0 ; i < matrix.length; i ++){
            for(int j = 0 ; j < matrix.length; j ++){
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println("");
        }


        Case18 case18 = new Case18();
        case18.setasdada(matrix);
        System.out.println("");

        for(int i = 0 ; i < matrix.length; i ++){
            for(int j = 0 ; j < matrix.length; j ++){
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println("");
        }

    }


}
