package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PossibleBipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[N];
        boolean[] color = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] arr : dislikes) {
            int a = arr[0] - 1;
            int b = arr[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }


        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                boolean ret = bfs(graph, visited, color, i);
                if (!ret) return false;
            }
        }
        return true;
    }

    public boolean bfs(List<List<Integer>> graph, boolean[] visited,
                       boolean[] color, int index) {
        for (int next : graph.get(index)) {
            if (!visited[next]) {
                visited[next] = true;
                color[next] = !color[index];
                boolean ret = bfs(graph, visited, color, next);
                if (!ret) return false;
            } else {
                if (color[next] == color[index])
                    return false;
            }
        }

        return true;
    }
}
