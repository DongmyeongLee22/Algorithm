package com.company.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ret = {
                {1, 0},
                {0, 1}
        };
        solution.findOrder(2, ret);
    }

    static class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] ret = new int[numCourses];
            int[] indegree = new int[numCourses];

            List<List<Integer>> adjList = new ArrayList<>();

            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<Integer>());
            }
            // in[1] = 1
            // adj(0).add(1);

            // q = 0;

            for (int[] num : prerequisites) {
                indegree[num[0]]++;
                adjList.get(num[1]).add(num[0]);
            }

            Queue<Integer> q = new LinkedList<>();
            int index = 0;

            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) q.offer(i);
            }

            while (!q.isEmpty()) {
                int node = q.poll();
                ret[index++] = node;
                for (int i : adjList.get(node)) {
                    if (--indegree[i] == 0) q.offer(i);
                }
            }

            return ret;
        }

    }
}
