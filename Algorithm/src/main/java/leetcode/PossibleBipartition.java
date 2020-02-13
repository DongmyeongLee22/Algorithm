package leetcode;

import java.util.*;

public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0 ; i < N; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] nums : dislikes){
            int first = nums[0] - 1;
            int second = nums[1] - 1;
            adjList.get(first).add(second);
            adjList.get(second).add(first);
        }

        boolean[] visited = new boolean[N];
        boolean[] color = new boolean[N];

        for(int i = 0 ; i < N; i++){
            if(visited[i]) continue;
            if(!dfs(adjList, i, visited, color)) return false;
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adjList, int index, boolean[] visited, boolean[] color){
        visited[index] = true;
        for(int adj : adjList.get(index)){
            if(!visited[adj]){
                color[adj] = !color[index];
                if(!dfs(adjList, adj, visited, color)) return false;
            }else{
                if(color[adj] == color[index]) return false;
            }
        }

        return true;
    }
}
