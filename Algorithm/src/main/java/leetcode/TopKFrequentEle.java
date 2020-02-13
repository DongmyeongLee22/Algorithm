package leetcode;

import java.util.*;

public class TopKFrequentEle {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Value> pq = new PriorityQueue<>((a, b) -> a.count == b.count ? b.val - a.val : a.count - b.count);

        for (int num : map.keySet()) {
            pq.add(new Value(num, map.get(num)));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> ret = new ArrayList<>();
        while (!pq.isEmpty()) {
            ret.add(0, pq.poll().val);
        }

        return ret;
    }

    static class Value {
        int val;
        int count;

        Value(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
