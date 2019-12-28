package BackJon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 문제에 경로 표현까지 추가 한 것
 */
public class DIJKSTRA_BJ1753 {

    private static int[] distance;
    private static List<List<Integer>> listList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        List<List<Node>> lists = new ArrayList<>();
        listList = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            lists.add(new ArrayList<>());
            listList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int adjNode = Integer.parseInt(st.nextToken());
            int weigh = Integer.parseInt(st.nextToken());
            lists.get(node).add(new Node(adjNode, weigh));
        }
        br.close();

        dijktra(lists, K, V);

        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                System.out.println("경로 없음");
            else {
                List<Integer> getInteger = listList.get(i);
                System.out.print("경로 : ");
                for (Integer integer : getInteger) {
                    System.out.print(integer + " -> ");
                }
                System.out.println(i);
                System.out.println("비용 : " + distance[i]);
            }
        }


    }

    private static void dijktra(List<List<Node>> lists, int startNode, int V) {
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNode, 0));
        distance[startNode] = 0;
        while (!pq.isEmpty()) {
            int nowNode = pq.poll().adjNode;

            if (visited[nowNode]) continue;
            visited[nowNode] = true;

            List<Node> getNodes = lists.get(nowNode);

            for (Node node : getNodes) {
                int weigh = node.weigh;
                int adjNode = node.adjNode;

                if (distance[adjNode] > distance[nowNode] + weigh) {
                    distance[adjNode] = distance[nowNode] + weigh;
                    pq.add(new Node(adjNode, distance[adjNode]));
                    listList.get(adjNode).addAll(listList.get(nowNode));
                    listList.get(adjNode).add(nowNode);
                }

            }

        }

    }

}

class Node implements Comparable<Node> {
    int adjNode;
    int weigh;

    Node(int adjNode, int weigh) {
        this.adjNode = adjNode;
        this.weigh = weigh;
    }

    @Override
    public int compareTo(Node o) {
        return this.weigh - o.weigh;
    }
}
