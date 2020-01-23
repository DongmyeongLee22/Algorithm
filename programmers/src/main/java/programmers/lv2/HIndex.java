package programmers.lv2;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 1;

        for (int i = 0; i < citations.length; i++) {

            // 인용 수
            int quotation = citations[i];

            // 인용된 논문 수
            int paper = citations.length - i;

            if (quotation > paper) {

                hIndex = Math.max(hIndex, paper);

            } else {
                hIndex = Math.min(paper, quotation);
            }
        }
        return hIndex;

    }
}
