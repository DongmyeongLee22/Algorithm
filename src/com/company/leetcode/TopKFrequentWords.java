package com.company.leetcode;

import java.util.*;

public class TopKFrequentWords {
    class Solution {

        public List<String> topKFrequent(String[] words, int k) {
            List<String> ret = new ArrayList<>();
            Map<String, Word> map = new HashMap<>();

            for (String word : words) {
                if (map.containsKey(word)) {
                    map.get(word).count++;
                } else {
                    map.put(word, new Word(word));
                }
            }

            PriorityQueue<Word> pq = new PriorityQueue<>(k, (a, b) -> a.count != b.count
                    ? a.count - b.count : b.word.compareTo(a.word));

            for (Word word : map.values()) {
                pq.offer(word);
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            while (!pq.isEmpty()) {
                Word word = pq.poll();
                ret.add(0, word.word);
            }

            return ret;

        }

        public class Word {

            String word;
            int count;

            public Word(String word) {
                this.word = word;
                this.count = 1;
            }
        }
    }
}
