package programmers.lv1;

public class StringZip {


    public  int solution(String s) {
        int length = s.length();
        int answer = length;

        // abc abc ded e
        for (int i = 0; i < length / 2; i++) {
            int strSize = i + 1;
            int count = strSize;
            int sameCount = 1;

            String original = s.substring(0, strSize);


            for (int j = strSize; j < length; j += strSize) {

                if (j + strSize > length) {
                    count += length - j;
                    continue;
                }

                String cur = s.substring(j, j + strSize);

                if (original.equals(cur)) {
                    sameCount++;
                    continue;
                }


                if (sameCount != 1) {
                    count += (int) Math.log10(sameCount) + 1;
                    sameCount = 1;
                }

                count += strSize;
                original = cur;

            }

            if (sameCount != 1){
                count += (int) Math.log10(sameCount) + 1;
            }

            answer = Math.min(count, answer);
        }

        return answer;
    }
}
