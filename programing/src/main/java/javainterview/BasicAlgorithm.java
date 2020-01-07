package javainterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BasicAlgorithm {

    public void bubbleSort(int[] arr) {
        boolean numberSwitched;

        for (int i = 0; i < arr.length; i++) {
            numberSwitched = false;

            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    numberSwitched = true;
                }
            }

            if (!numberSwitched) break;
        }
    }


    // 삽입 정렬은 최악의 경우 n^2이나 버블정렬에 비해 값이 정해지면 그 반복분은 종료되므로 조금더 효율적
    // 역순으로 정렬되어 있다면 n시간이 걸린다.
    public List<Integer> insertSort(List<Integer> numbers) {

        List<Integer> ret = new LinkedList<>();

        originalList:
        for (int number : numbers) {
            for (int i = 0; i < ret.size(); i++) {
                if (number < ret.get(i)) {
                    ret.add(i, ret.get(i));
                    continue originalList;
                }
            }
            ret.add(ret.size(), number);
        }

        return ret;

    }

    public List<Integer> quickSort(List<Integer> numbers) {
        if (numbers.size() < 2) {
            return numbers;
        }

        int pivot = numbers.get(0);
        List<Integer> lower = new ArrayList<>();
        List<Integer> higher = new ArrayList<>();

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > pivot) {
                higher.add(numbers.get(i));
            } else {
                lower.add(numbers.get(i));
            }
        }

        List<Integer> sorted = quickSort(lower);
        sorted.add(pivot);
        sorted.addAll(quickSort(higher));

        return sorted;
    }

    public List<Integer> mergeSort(List<Integer> numbers) {

        if (numbers.size() < 2) {
            return numbers;
        }

        List<Integer> left = numbers.subList(0, numbers.size() / 2);
        List<Integer> right = numbers.subList(numbers.size() / 2, numbers.size());

        return merge(mergeSort(left), mergeSort(right));
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        int leftPtr = 0;
        int rightPtr = 0;

        List<Integer> merged = new ArrayList<>(left.size() + right.size());

        while (leftPtr < left.size() && rightPtr < right.size()) {
            if (left.get(leftPtr) > right.get(rightPtr)) {
                merged.add(right.get(rightPtr++));
            } else {
                merged.add(left.get(leftPtr++));
            }
        }

        while (leftPtr < left.size()) {
            merged.add(left.get(leftPtr++));
        }

        while (rightPtr < right.size()) {
            merged.add(right.get(rightPtr++));
        }

        return merged;
    }

    public boolean binarySearch(List<Integer> lists, int value) {

        if (lists.size() == 0){
            return false;
        }

        int midValue = lists.get(lists.size() / 2);
        if (value == midValue){
            return true;
        }

        if (midValue > value) {
            return binarySearch(lists.subList(0, lists.size() / 2), value);
        } else {
            return binarySearch(lists.subList((lists.size() / 2 ) + 1, lists.size()),value);
        }



    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
