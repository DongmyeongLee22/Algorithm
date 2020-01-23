package programmers.lv2;

import java.util.Arrays;

// 기능개발
public class ProductDev {

    // pogr 앞부터 배포 가능
    // 95 / 4 라면 2일 뒤다.

    // [93,30,55]	[1,30,5]	[2,1]
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[100];

        int count = -1;

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];

            // 0 94 95 96 97 98 99 100
            while (progress + speed * count < 100) {
                count++;
            }

            days[count]++;
        }


        return Arrays.stream(days).filter(i -> i!=0).toArray();
    }

    public int[] solutiontest(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}
