package craking;

public class Case17 {


    void rotate(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length != matrix.length)
            System.out.println("It does't matrix!!");
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - layer - 1;


            for (int i = first; i < last; i++) {
                int offset = i - first;
                int lastOffset = last - offset;
                int top = matrix[first][i];

                matrix[first][i] = matrix[lastOffset][first];

                matrix[lastOffset][first] = matrix[last][lastOffset];

                matrix[last][lastOffset] = matrix[i][last];

                matrix[i][last] = top;

            }
        }


    }

    public static void main(String[] args) {
        int[][] matrix = {
                {11, 22, 33, 44},
                {55, 66, 77, 88},
                {99, 10 ,35, 12},
                {13, 14, 15 ,16}
        };

        for(int i = 0 ; i < matrix.length; i ++){
            for(int j = 0 ; j < matrix.length; j ++){
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println("");
        }


        Case17 case17 = new Case17();
        case17.rotate(matrix);
        System.out.println("");

        for(int i = 0 ; i < matrix.length; i ++){
            for(int j = 0 ; j < matrix.length; j ++){
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println("");
        }

    }

}
