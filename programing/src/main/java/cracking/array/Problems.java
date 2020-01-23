package cracking.array;

public class Problems {

    boolean isDuplicate(String stringArr) {

        char[] chars = stringArr.toCharArray();

        boolean[] aski = new boolean[128];

        for (char c : chars) {
            if (aski[c]) {
                return false;
            }
            aski[c] = true;
        }

        return true;
    }

    boolean isPermutation(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int[] count = new int[128];

        for (char c : chars1) {
            count[c]++;
        }

        for (char c : chars2) {
            count[c]--;
            if (count[c] < 0) {
                return false;
            }
        }
        return true;
    }

    void changeToStrubg(char[] chars, int length) {
        int empty = 0;

        for (char c : chars) {
            if (c == ' ') {
                empty++;
            }
        }

        int index = length + empty * 2;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[index - 1] = '0';
                chars[index - 2] = '2';
                chars[index - 3] = '%';
                index -= -3;
            } else {
                chars[index - 1] = chars[i];
                index--;
            }
        }

    }

    // abcdcba 홀수개면 카운팅이 한개인게 딱 하나고 나머진 다 두개(짝수)여야 한다.
    // abccba 짝수개면 카운트값이 두개인거 뿐이다/
    boolean isPermutation2(char[] chars) {
        int[] count = new int[128];

//        for (char c : chars) {
//            count[c]++;
//        }
//
//        boolean isOdd = chars.length % 2 == 0;
        int oneChar = 0;

        for (char c : chars) {
            count[c]++;
            if (count[c] % 2 != 0) {
                oneChar++;
            } else {
                oneChar--;
            }
        }
        return oneChar <= 1;
    }

    boolean isOneTime(char[] chars1, char[] chars2) {
        if (chars1.length == chars2.length) {
            return sameLength(chars1, chars2);
        } else if (chars1.length + 1 == chars2.length) {
            return isDiffLength(chars1, chars2);
        } else if (chars2.length + 1 == chars1.length) {
            return isDiffLength(chars2, chars1);
        }

        return false;
    }

    private boolean isDiffLength(char[] chars1, char[] chars2) {
        int longindex = 0;
        int shortindex = 0;


        while (shortindex < chars1.length && longindex < chars2.length) {
            if (chars1[shortindex] != chars2[longindex]) {
                longindex++;
                if (longindex - shortindex > 1){
                    return false;
                }
            } else {
                longindex++;
                shortindex++;
            }
        }

        return true;
    }

    private boolean sameLength(char[] chars1, char[] chars2) {
        boolean isOnediff = false;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                if (isOnediff) {
                    return false;
                }
                isOnediff = true;
            }
        }
        return true;
    }


}

