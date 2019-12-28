package leetcode;

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


        /*
        class Solution {
            class Word implements Comparable<Word> {
                public String word;
                public int frequency;
                public Word(String word, int frequency) {
                    this.word = word;
                    this.frequency = frequency;
                }

                public int compareTo(Word other) {
                    if (this.frequency != other.frequency) {
                        return other.frequency - this.frequency;
                    } else {
                        return this.word.compareTo(other.word);
                    }
                }
            }

            public List<String> topKFrequent(String[] words, int k) {

                Map<String, Word> dict = new HashMap<>();
                for (String s : words) {
                    if (!dict.containsKey(s)) {
                        dict.put(s, new Word(s, 1));
                    } else {
                        Word word = dict.get(s);
                        word.frequency++;
                    }
                }

                Queue<Word> pq = new PriorityQueue<>();
                for (String word : dict.keySet()) {
                    pq.add(dict.get(word));
                }

                List<String> result = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    result.add(pq.poll().word);
                }

                return result;
            }
        }
        */
    }
}
