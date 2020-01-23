package programmers.hash1;

public class StrungZip {

    public static void main(String[] args) {
        solution("ababcdcdababcdcd");
    }

    public static int solution(String s) {
        int length = s.length();
        int answer = length;

        // abc abc ded e
        for (int i = 0; i < length / 2; i++) {
            int strSize = i + 1;
            int count = 0;
            int sameCount = 0;

            String original = s.substring(0, strSize);

            String cur = "";
            for (int j = strSize; j <= length; j += strSize) {

                if (j + strSize > length) {
                    cur = s.substring(j, length);
                    continue;
                }

                cur = s.substring(j, j + strSize);

                if (original.equals(cur)) {
                    sameCount++;
                    continue;
                }

                count += original.length();

                if (sameCount != 0) {
                    count += 1;
                }

                original = cur;

            }

            count += sameCount != 0 ? 1 + cur.length() : cur.length();

            answer = Math.min(count, answer);
        }

        return answer;
    }
}
