package com.company.BackJon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1260 {

    static int V, E, S;

    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        V = Integer.parseInt(tokenizer.nextToken());
        E = Integer.parseInt(tokenizer.nextToken());
        S = Integer.parseInt(tokenizer.nextToken());

        graph = new ArrayList[V+1];


        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        dfs();
        bfs();
        bfs_Shortest(3);

    }

    private static void dfs() {
        boolean [] visited = new boolean[V+1];
        DFS_get(S, visited);

    }

    private static void DFS_get(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for(int i : graph[s]){
            if(!visited[i]){
                DFS_get(i,visited);
            }
        }
    }

    private static void bfs_Shortest(int n){
        Queue<Integer> queue = new LinkedList<>();
        int [] short_Path = new int [V+1];

        for(int i = 0 ; i < short_Path.length; i++)
            short_Path[i] = -1;

        short_Path[S] = 0;
        queue.add(S);

        while(!queue.isEmpty()){
            int q = queue.poll();
            for(int i : graph[q]){
                if(short_Path[i] == -1){
                    short_Path[i] = short_Path[q] +1;
                    queue.add(i);
                }
            }
        }

        System.out.println(n + "의 최단 경로 : " + short_Path[n]);

    }

    private static void bfs() {
        System.out.println("");
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[V+1];
        queue.add(S);
        visited[S] = true;

        while (!queue.isEmpty()) {
            int q = queue.poll();
            System.out.print(q + " ");

            for (int i : graph[q]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}
