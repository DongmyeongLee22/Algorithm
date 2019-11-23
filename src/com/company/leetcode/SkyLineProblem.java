package com.company.leetcode;

import java.util.*;

public class SkyLineProblem {
    class Solution {
        public class Point{
            int x;
            int y;
            boolean start;

            Point(int x, int y, boolean start){
                this.x = x;
                this.y = y;
                this.start = start;
            }
        }
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<Point> list = new ArrayList<>();

            for(int [] arr : buildings){
                list.add(new Point(arr[0], arr[2], true));
                list.add(new Point(arr[1], arr[2], false));
            }

            Collections.sort(list, (a, b) -> {
                if(a.x != b.x){
                    return a.x - b.x;
                }
                else if(!a.start && b.start){
                    return 1;
                }else if(a.start && !b.start){
                    return -1;
                }else if(a.start && b.start){
                    return b.y - a.y;
                }else{
                    return a.y - b.y;
                }
            });

            List<List<Integer>> ret = new ArrayList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(5, (a, b) -> b - a);

            pq.offer(0);

            for(Point p : list){
                int max = pq.peek();
                if (p.start){
                    pq.offer(p.y);
                }else {
                    pq.remove(p.y);
                }

                if(max != pq.peek()){
                    List<Integer> value = new ArrayList<>();
                    value.add(p.x);
                    value.add(pq.peek());
                    ret.add(value);
                }
            }

            return ret;
        }
    }
}