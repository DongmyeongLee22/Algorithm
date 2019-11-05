package com.company.bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kruskal {


    private static int[] parent;

    private static int min_Weight = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());

        int E = Integer.parseInt(br.readLine());

        Graph[] graph = new Graph[E];

        parent = new int[E + 1];

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            graph[i] = new Graph(st.nextToken(), st.nextToken(), st.nextToken());

        }

        Arrays.sort(graph);

        for (int i = 0; i < E; i++) {

            int x = find_root(graph[i].x);
            int y = find_root(graph[i].y);

            if (x == y) {
            } else {
                weighted_Union(x, y);
                min_Weight += graph[i].cost;
            }
        }

        System.out.println(min_Weight);
    }

    private static int find_root(int x) {
        if (parent[x] == x)
            return x;
        else {
            parent[x] = find_root(parent[x]);
            return parent[x];
        }
    }

    private static void weighted_Union(int u, int v) {

        int x = find_root(u);
        int y = find_root(v);

        parent[x] = y;

    }

    private static class Graph implements Comparable<Graph> {

        int x;
        int y;
        int cost;

        Graph(String x, String y, String cost) {
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
            this.cost = Integer.parseInt(cost);
        }

        @Override
        public int compareTo(Graph o) {
            return this.cost - o.cost;
        }
    }
}
