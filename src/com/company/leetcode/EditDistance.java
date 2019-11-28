package com.company.leetcode;

public class EditDistance {
    class Solution {
        public int minDistance(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();

            int[][] ret = new int[len1 + 1][len2 + 1];

            for (int i = 0; i <= len1; i++) {
                ret[i][0] = i;
            }
            //   a c
            // a 0 1
            // c 1 1
            for (int i = 0; i <= len2; i++) {
                ret[0][i] = i;
            }

            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        ret[i][j] = ret[i - 1][j - 1];
                    } else {
                        ret[i][j] = Math.min(ret[i - 1][j - 1], Math.min(ret[i - 1][j], ret[i][j - 1])) + 1;
                    }
                }
            }

            return ret[len1][len2];
        }
    }
}
