package cracking.recursionanddynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindPath {
    class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "경로 : row = " + row + " col = " + col;
        }
    }

    List<Point> getPath(boolean[][] maze) {
        if (maze.length < 0 || maze[0].length < 0) {
            return null;
        }
        List<Point> ret = new ArrayList<>();
        HashSet<Point> box = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, ret, box)) {
            return ret;
        }

        return null;
    }

    private boolean getPath(boolean[][] maze, int row, int col, List<Point> ret, HashSet<Point> box) {
        if (row < 0 || col < 0) {
            return false;
        }
        Point point = new Point(row, col);
        if (box.contains(point)) {
            return false;
        }
        boolean flag = (row == 0) && (col == 0);

        if (flag || getPath(maze, row - 1, col, ret, box) || getPath(maze, row, col - 1, ret, box)) {
            ret.add(point);
            return true;
        }

        box.add(point);
        return false;
    }

    int magicIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > i) {
                return -1;
            } else if (arr[i] == i) {
                return i;
            }
        }

        return -1;
    }

    int magicIndex2(int[] arr) {
        return magicIndex2(arr, 0, arr.length - 1);
    }

    private int magicIndex2(int[] arr, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (end + start) / 2;
        if (mid == arr[mid]) {
            return mid;
        } else if (mid > arr[mid]) {
            return magicIndex2(arr, mid + 1, end);
        } else {
            return magicIndex2(arr, start, mid - 1);
        }
    }

    // 중복값 생각한 것
    int magicIndex3(int[] arr) {
        return magicIndex3(arr, 0, arr.length - 1);
    }

    private int magicIndex3(int[] arr, int start, int end) {
        if (end < start) {
            return -1;
        }
        int midIndex = (end + start) / 2;
        int midValue = arr[midIndex];

        if (midValue == midIndex) {
            return midIndex;
        }

        int left = Math.min(midIndex, midValue);
        int ret = magicIndex3(arr, start, midIndex);
        if (ret > 0) return ret;

        int right = Math.max(midIndex, midValue);
        ret = magicIndex3(arr, midIndex, end);
        return ret;
    }

    List<List<Integer>> findGroup(List<Integer> val, int index) {
        List<List<Integer>> ret;
        if (val.size() == index) {
            ret = new ArrayList<>();
            ret.add(new ArrayList<>());
        } else {
            ret = findGroup(val, index + 1);
            int item = val.get(index);
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> i : ret) {
                List<Integer> newList = new ArrayList<>(i);
                newList.add(item);
                temp.add(newList);
            }
            ret.addAll(temp);
        }
        return ret;
    }

    List<List<Integer>> findg(List<Integer> val, int index) {

        List<List<Integer>> ret;

        if (val.size() == index) {
            ret = new ArrayList<>();
            ret.add(new ArrayList<>());
        } else {
            ret = findg(val, index + 1);
            List<List<Integer>> cur = new ArrayList<>();
            int item = val.get(index);
            for (List<Integer> integerList : ret) {
                List<Integer> value = new ArrayList<>(integerList);
                value.add(item);
                cur.add(value);
            }

            ret.addAll(cur);
        }

        return ret;
    }

    int multiply(int x, int y) {
        int bigger = Math.max(x, y);
        int smaller = Math.min(x, y);
        return productHelper(smaller, bigger);
    }

    private int productHelper(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        }
        if (smaller == 1) {
            return bigger;
        }

        int s = smaller >> 1;
        int slid1 = productHelper(s, bigger);
        int slide2 = slid1;
        if (smaller % 2 == 1){
            slide2 = productHelper(smaller - 1, bigger);
        }

        return slid1 + slide2;

    }

    int multiply2(int x, int y){
        int bigger = Math.max(x, y);
        int smaller = Math.min(x, y);
        int memo[] = new int [smaller + 1];
        return productHelper(smaller, bigger, memo);
    }

    private int productHelper(int smaller, int bigger, int[] memo) {
        if (smaller == 0) return 0;
        if (smaller == 1) return bigger;
        if (memo[smaller] != 0) return memo[smaller];

        int s = smaller >> 1;
        int slide1 = productHelper(s, bigger, memo);
        int slide2 = slide1;

        if (smaller % 2 == 1){
            slide2 = slide2 + bigger;
        }
        memo[smaller] = slide1 + slide2;
        return memo[smaller];
    }
}
