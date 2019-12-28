package recursion;

public class Powerset {


    private static char[] data = {'a', 'b', 'c', 'd'};
    private static int n = data.length;
    private static boolean[] include = new boolean[n];
    private static boolean bool = false;

    private static void powerset(int k) {
        if (k == n) {
            for (int i = 0; i < n; i++) {
                if (include[i]) {
                    System.out.print(data[i] + " ");
                    bool = true;
                }
            }
            if (bool)
                System.out.println("");
            else
                System.out.println("공집합");
        } else {
            include[k] = false;
            powerset(k + 1);
            include[k] = true;
            powerset(k + 1);
        }
    }


    public static void main(String[] args) {

        powerset(0);
    }

}
