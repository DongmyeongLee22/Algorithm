package com.company.bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prim {

    private static ArrayList<Graph>[] graphList;

    private static boolean[] visited;

    private static int minValue = 0;

    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());

        int E = Integer.parseInt(br.readLine());

        graphList = new ArrayList[V + 1];

        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++)
            graphList[i] = new ArrayList<Graph>();


        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graphList[start].add(new Graph(end, cost));
            graphList[end].add(new Graph(start, cost));
        }


        prim_Mst();
        System.out.println(minValue);
    }

    private static void prim_Mst() {

        PriorityQueue<Graph> pq = new PriorityQueue<>();

        add_Queue(pq, 1);

        while (!pq.isEmpty()) {
            Graph temp_Graph = pq.poll();
            int other = temp_Graph.other;

            if(visited[other]) continue;

            int cost = temp_Graph.cost;
            count++;
            minValue += cost;
            if (count == visited.length)
                break;
            add_Queue(pq, other);

        }
    }

    private static void add_Queue(PriorityQueue<Graph> pq, int v) {
        visited[v] = true;
        for (Graph graph : graphList[v]) {
            pq.offer(graph);
        }
    }

    private static class Graph implements Comparable<Graph> {

        int other;
        int cost;

        Graph(int other, int cost) {
            this.other = other;
            this.cost = cost;
        }

        @Override
        public int compareTo(Graph o) {
            return this.cost - o.cost;
        }

    }
}
