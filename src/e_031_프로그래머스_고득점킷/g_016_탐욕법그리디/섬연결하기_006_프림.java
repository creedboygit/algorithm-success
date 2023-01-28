package e_031_프로그래머스_고득점킷.g_016_탐욕법그리디;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42861

4
[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]
정답 : 4


4
5
0 1 1
0 2 2
1 2 5
1 3 1
2 3 8

정답 : 4
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Solution
public class 섬연결하기_006_프림 {

    public static class Edge implements Comparable<Edge> {

        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }


        // 오름차순 정렬
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] parent;

    public static int find(int a) {
        if (a == parent[a])
            return parent[a];
        else
            return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        parent[a] = b;
    }

    public static int solution(int n, int[][] costs) {

        int answer = 0;

//        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((a, b) -> (a.cost - b.cost));
        parent = new int[n];

        for (int i = 0; i < n; parent[i] = i++) {
        }

        for (int i = 0; i < costs.length; i++) {

            int v1 = costs[i][0];
            int v2 = costs[i][1];
            int cost = costs[i][2];

            pq.offer(new Edge(v1, v2, cost));
        }

        int cnt = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (find(edge.v1) == find(edge.v2)) continue;

            union(edge.v1, edge.v2);
            answer += edge.cost;

            if (cnt == n - 1) return answer; // 간선은 무조건 노드 개수 -1 한 것이므로 간선의 개수만큼만 돌아서 시간 복잡도를 아낀다.
        }

        return answer;
    }

    // 부모 노드가 같은지 확인 (같은 집합인지 확인)
    private static int findParent(int node) {
        if (parent[node] == node) return node;
        else return parent[node] = findParent(parent[node]);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 노드
        int m = Integer.parseInt(br.readLine()); // 간선

        int[][] costs = new int[m][3];

        for (int i = 0; i < m; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.deepToString(line));

        System.out.println(solution(n, costs));
    }
}
