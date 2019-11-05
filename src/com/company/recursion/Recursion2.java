package com.company.recursion;

public class Recursion2 {

    //문자열 길이 구하기
    //문자열 프린트
    //문자열 뒤집어서 프린트
    //2진수로 변환하여 출력

    private void printBinary(int x) {

        if (x < 2)
            System.out.print(x);
        else {
            printBinary(x / 2);
            System.out.print(x % 2);
        }
    }

    private int arrSum(int n, int[] data) {
        if (n == 0)
            return 0;
        else
            return data[n - 1] + arrSum(n - 1, data);
    }

    private int search(int[] data, int begin, int end, int target) {
        if (begin > end)
            return -1;
        else if (data[begin] == target)
            return begin;
        else
            return search(data, begin + 1, end, target);
    }


    private int searchMiddle(int[] data, int begin, int end, int target) {
        //중간에서 부터 찾는 이진탐색 해보기
        if (begin > end) {
            return -1;
        } else {
            int middle = (begin + end) / 2;
            if (data[middle] == target) {
                return middle;
            } else {
                int index = searchMiddle(data, begin, middle - 1, target);
                if (index == -1) {
                    return searchMiddle(data, middle + 1, end, target);
                } else {
                    return index;
                }
            }
        }
    }

    //Math.max 이용해서 최대값 찾기 , 중간부터 찾기
    //다시 해보기
    private int findMax(int begin, int end, int[] data) {
        if (begin == end)
            return data[begin];
        else {
            return Math.max(data[begin], findMax(begin + 1, end, data));
        }

    }

    private int findMaxMiddle(int begin, int end, int[] data) {

        if (begin == end)
            return data[begin];
        else {
            int middle = (begin + end) / 2;
            int max1 = findMaxMiddle(begin, middle, data);
            int max2 = findMaxMiddle(middle + 1, end, data);
            return Math.max(max1, max2);
        }
    }

    //이진검색 해보기
    private int SearchBinary(String[] data, String target, int begin, int end) {
        if (begin > end)
            return -1;
        else {
            int middle = (begin + end) / 2;
            int compare = data[middle].compareTo(target);
            if (compare == 0)
                return middle;
            else if (compare == -1)
                return SearchBinary(data, target, begin, middle - 1);
            else
                return SearchBinary(data, target, middle + 1, end);
        }
    }

    public static void main(String[] args) {
        Recursion2 recursion2 = new Recursion2();
        recursion2.printBinary(10);
    }
}
