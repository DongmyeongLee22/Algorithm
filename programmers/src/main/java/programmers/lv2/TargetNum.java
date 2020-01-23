package programmers.lv2;

public class TargetNum {
    public int solution(int[] numbers, int target) {
        return getTargetNumber(numbers, target, 0, 0);
    }

    private int getTargetNumber(int[] numbers, int target, int index, int cur) {

        if (index == numbers.length && cur == target) {
            return 1;
        }

        if (index >= numbers.length) {
            return 0;
        }

        return getTargetNumber(numbers, target, index + 1, cur + numbers[index])
                + getTargetNumber(numbers, target, index + 1, cur - numbers[index]);

    }
}
