package programmers.lv2;

import java.util.Arrays;

public class Lifeboat {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int left = 0, right = people.length - 1;

        while (left < right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            }else{
                right--;
            }
            answer++;
        }

        return answer;
    }
}
