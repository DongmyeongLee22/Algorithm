package BackJon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class graphtest {

    static int S,V,E;
    static ArrayList<Integer> [] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        V = Integer.parseInt(tokenizer.nextToken());
        E = Integer.parseInt(tokenizer.nextToken());
        S = Integer.parseInt(tokenizer.nextToken());

        graph = new ArrayList[V+1];

        Arrays.fill(graph, new ArrayList<Integer>());

        for(int i = 0 ; i < E ; i ++){
            tokenizer = new StringTokenizer(reader.readLine());
            int firstNode = Integer.parseInt(tokenizer.nextToken());
            int secondNode = Integer.parseInt(tokenizer.nextToken());

            graph[firstNode].add(secondNode);
            graph[secondNode].add(firstNode);
        }

        for(int i = 1; i < graph.length;i ++){
            Collections.sort(graph[i]);
        }

        dfs();
        bfs();

    }

    private static void bfs() {
        System.out.println("");
        boolean [] visited = new boolean[V+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(S);
        visited[S] = true;

        while(!queue.isEmpty()){
            int q = queue.poll();
            System.out.print(q + " ");
            for(int i : graph[q]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    private static void dfs() {
        boolean [] visited = new boolean[V+1];
        dfs_Traversal(S, visited);
    }

    private static void dfs_Traversal(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for(int i : graph[s]){
            if(!visited[i]){
                dfs_Traversal(i,visited);
            }
        }
    }
}
