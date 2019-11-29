package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {
    class Solution {

        public int[][] merge(int[][] intervals) {
            if(intervals.length == 0 || intervals.length == 1) return intervals;

            PriorityQueue<int []> pq = new PriorityQueue<>(10, (a,b) -> a[0] - b[0]);
            List<int []> ret = new ArrayList<>();

            for(int[] num : intervals){
                pq.offer(num);
            }

            while(!pq.isEmpty()){
                if(pq.size() == 1){
                    ret.add(pq.poll());
                }else{
                    int [] a = pq.poll();
                    int [] b = pq.poll();

                    if(a[1] >= b[0]){
                        b[0] = Math.min(a[0], b[0]);
                        b[1] = Math.max(a[1], b[1]);
                    }else{
                        ret.add(a);
                    }
                    pq.offer(b);
                }
            }

            return ret.toArray(new int[ret.size()][2]);
        }
        /* 우선순위 큐를 쓰지 않고 주어진 배열로 바로 구현해보기
        class Solution {

            public int[][] merge(int[][] intervals) {
                if(intervals.length == 0 || intervals.length == 1) return intervals;

                Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

                List<int []> ret = new ArrayList<>();

                for(int i = 1; i < intervals.length; i++){
                    int [] a = intervals[i-1];
                    int [] b = intervals[i];

                    if(a[1] >= b[0]){
                        b[0] = Math.min(a[0], b[0]);
                        b[1] = Math.max(a[1], b[1]);
                    }else{
                        ret.add(a);
                    }
                }

                ret.add(intervals[intervals.length - 1]);

                return ret.toArray(new int[ret.size()][2]);
            }
        }
        */
    }

}
