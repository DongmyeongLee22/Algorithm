package cracking.array;

import java.util.Arrays;

public class 배열과문자열 {


    String joinWords(String[] words) {
        StringBuilder sentence =
                new StringBuilder();
        for (String word : words) {
            sentence.append(word);
        }
        return sentence.toString();
    }

    // ================================ 1 ===================================//
    boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] isUnique = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (isUnique[c]) {
                return false;
            }
            isUnique[c] = true;
        }
        return true;
    }

    // 비트 벡터를 사용하면 공간을 줄일 수 있다. a~z까지 구성된다고 가정한 문제
    boolean isUniqueChars2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    // ================================ 2 ===================================//
    String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    //문자열 개수 정해져 있을 경우 카운팅으로 해결
    boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[128];

        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            count[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            count[c]--;
            if (count[c] < 0) {
                return false;
            }
        }

        return true;
    }


    // ================================ 3 ===================================//
    void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2; //%20이면 2개의 문자가 더 필요

        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    // ================================ 4 ===================================//
    boolean isPermutaitonOfPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = c - 'a';
            table[x]++;

            if (table[x] % 2 == 1) {
                countOdd++;
            } else {
                countOdd--;
            }
        }
        return countOdd <= 1;
    }

    // ================================ 5 ===================================//
    boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() - second.length() == -1) {
            return oneEditInsert(first, second);
        } else if (first.length() - second.length() == 1) {
            return oneEditInsert(second, first);
        }

        return false;
    }

    private boolean oneEditInsert(String s1, String s2) {
        int shortIndex = 0;
        int longIndex = 0;

        while (shortIndex < s1.length() && longIndex < s2.length()) {
            if (s1.charAt(shortIndex) == s2.charAt(longIndex)) {
                shortIndex++;
                longIndex++;
            } else {
                longIndex++;
                if (longIndex - shortIndex > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean oneEditReplace(String first, String second) {
        boolean isEqual = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (isEqual) {
                    return false;
                }
                isEqual = true;
            }
        }
        return true;
    }

    // ================================ 6 ===================================//
    String compreesBad(String str) {
        StringBuilder ret = new StringBuilder();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            count++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                ret.append(str.charAt(i));
                ret.append(count);
                count = 0;
            }
        }

        return ret.length() > str.length() ? str : ret.toString();
    }

    // ================================ 7 ===================================//
    boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - layer - 1;
            for (int i = first; i < last; i++) {
                int top = matrix[first][i];
                int offset = last - (i - first);

                matrix[first][i] = matrix[offset][first];

                matrix[offset][first] = matrix[last][offset];

                matrix[last][offset] = matrix[i][last];

                matrix[i][last] = top;
            }
        }

        return true;
    }

    // ================================ 8 ===================================//
    void setZeros(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                setRowZeros(matrix, i);
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                setColZeros(matrix, i);
            }
        }

        if (firstRowZero) {
            setRowZeros(matrix, 0);
        }

        if (firstColZero) {
            setColZeros(matrix, 0);
        }

    }

    private void setRowZeros(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private void setColZeros(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    // ================================ 9 ===================================//
    boolean isRotation(String s1, String s2) {
        if (s1.length() > 0 && s1.length() == s2.length()) {
            return isSubstring(s1 + s1, s2);
        }
        return false;
    }

    private boolean isSubstring(String s, String s2) {
        return true;
    }

}
