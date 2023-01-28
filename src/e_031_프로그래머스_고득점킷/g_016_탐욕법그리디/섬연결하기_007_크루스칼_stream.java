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
import java.util.*;

//Solution
public class 섬연결하기_007_크루스칼_stream {

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
    static int answer;

    public static int find(int a) {
        if (a == parent[a])
            return parent[a];
        else
            return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b, int cost) {
        a = find(a);
        b = find(b);

        parent[a] = b;

        answer += cost;
    }

    public static int solution(int n, int[][] costs) {

        answer = 0;

        ArrayList<Edge> list = new ArrayList<>();

        parent = new int[n];

        for (int i = 0; i < n; i++) {

            parent[i] = i;
        }

//        Arrays.stream(costs).map(e -> new Edge(e[0], e[1], e[2])).forEach(edge -> list.add(edge));
        Arrays.stream(costs).map(e -> new Edge(e[0], e[1], e[2]))
                .forEach(list::add);

        Collections.sort(list);

        list.stream().filter(edge -> find(edge.v1) != find(edge.v2))
                .forEach(edge -> union(edge.v1, edge.v2, edge.cost));

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

//        System.out.println(Arrays.d1eepToString(line));

        System.out.println(solution(n, costs));
    }
}
