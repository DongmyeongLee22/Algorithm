package leetcode;

import java.util.*;

public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        PriorityQueue<Word> pq = new PriorityQueue<>((a, b) -> {
            if (a.count == b.count) {
                return b.word.compareTo(a.word);
            } else {
                return a.count - b.count;
            }
        });

        for (String word : map.keySet()) {
            pq.add(new Word(word, map.get(word)));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ret = new ArrayList<>();

        while (!pq.isEmpty()) {
            ret.add(0, pq.poll().word);
        }

        return ret;
    }

    static class Word {
        String word;
        int count;

        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
