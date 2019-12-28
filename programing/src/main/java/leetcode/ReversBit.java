package leetcode;

import java.util.*;

public class ReversBit {
    public static void main(String[] args) {
        ReversBit main = new ReversBit();

        /**
        List<String> strings = main.generateParenthesis(3);

        for (String string : strings) {
            System.out.println(string);
        }**/
        main.reverseBits(100);

    }
    public int reverseBits(int n) {

        int ret = 0;
        /*
        for(int i = 0; i < 32; i++){
            ret |= (n & 1) << (31 - i);
            n = n >> 1;
        }*/

        int a = 1 << 31;;
        int b = 1;

        for(int i = 0; i < 16; i++){
            ret |= ((n & a) >> (31 - i)) | ((n & b) << (31 - i));
            a = a >> 1;
            b = b << 1;
        }
        return ret;

    }

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        process(n, 0, 0, new char[n + n], 0, ret);
        return ret;
    }

    public void process(int n, int numOpen, int numClosed, char[] arr,int index, List<String> ret) {


        if (numOpen == n && numClosed == n) {
            ret.add(new String(arr));
            return;
        }

        if (numOpen < n) {
            arr[index++] = '(';
            process(n, numOpen + 1, numClosed, arr, index, ret);
        }

        if (numClosed < numOpen) {
            arr[index++] = ')';
            process(n, numOpen, numClosed + 1, arr, index, ret);
        }


    }
}
