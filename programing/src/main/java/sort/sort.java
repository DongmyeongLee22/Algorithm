package sort;

public class sort {

    private static int[] data = {29, 14, 37, 10, 19};
    private static int n = data.length;

    private static void selectsort() {
        for (int i = n - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (data[i] < data[j]) {
                    int tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }

        }

    }

    private static void BubbleSort() {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }

        }

    }

    // 29, 14, 37, 10, 19

    // 14 29 37 10 19
    // 109  14   29   37
    private static void InsertSort() {
        int j;
        for (int i = 1; i < n; i++) {
            int tmp = data[i];
            for (j = i - 1; j >= 0 && tmp < data[j] ; j--) {
                    data[j + 1] = data[j];
            }
            data[j + 1] = tmp;
        }

    }

    //9 8 7 6 5 4 3 2 1
    // 8 9 7 6 5 4 3 2 1

    public static void main(String[] args) {
        InsertSort();
        for (int i = 0; i < n; i++)
            System.out.print(data[i] + " ");
    }


}
