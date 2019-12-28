package leetcode;

import java.util.*;

public class CourseSchedule {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] indegree = new int[numCourses];
            List<List<Integer>> ret = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                ret.add(new ArrayList<Integer>());
            }

            for (int[] num : prerequisites) {
                indegree[num[0]]++;
                ret.get(num[1]).add(num[0]);
            }

            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) q.offer(i);
            }
            Set<Integer> hashSet = new HashSet<>();

            while (!q.isEmpty()) {
                int val = q.poll();
                List<Integer> list = ret.get(val);
                hashSet.add(val);

                for (Integer i : list) {
                    if (--indegree[i] == 0) q.offer(i);
                }
            }

            return numCourses == hashSet.size();
        }
    }
}
