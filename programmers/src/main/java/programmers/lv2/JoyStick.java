package programmers.lv2;

public class JoyStick {

    // N 보다 작으면 \ 65 - 카운트
    // 91 - \
    //
    public int solution(String name) {
        char[] chars = name.toCharArray();
        int answer = getCharCount(chars[0]);
        chars[0] = 'A';

        int count = diffCount(chars);
        int cur = 0;

        while (count != 0) {
            Value val = getJumpCount(chars, cur);
            answer += val.jump + getCharCount(chars[val.index]);
            chars[val.index] = 'A';
            cur = val.index;
            count--;
        }
        return answer;
    }

    private int diffCount(char[] chars) {
        int ret = 0;
        for (char aChar : chars) {
            if (aChar != 'A') ret++;
        }
        return ret;
    }

    public int getCharCount(char c) {
        return c <= 'N' ? c - 65 : 91 - c;
    }

    public Value getJumpCount(char[] chars, int now) {
        int jump = 1;
        int length = chars.length;
        for (int i = 1; i < length; i++) {
            int rightIndex = (now + i) % length;
            int leftIndex = (now - i + length) % length;

            if (chars[rightIndex] != 'A') {
                return new Value(rightIndex, jump);
            }
            if (chars[leftIndex] != 'A') {
                return new Value(leftIndex, jump);
            }

            jump++;
        }
        throw new IllegalArgumentException();
    }

    class Value {
        int index;
        int jump;

        public Value(int index, int jump) {
            this.index = index;
            this.jump = jump;
        }
    }

}
