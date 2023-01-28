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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//Solution
public class 섬연결하기_002_크루스칼 {

    static int[] parent;

    public static int solution(int n, int[][] costs) {

        int answer = 0;

        // 크루스칼 알고리즘을 사용하기 위해 가중치 기준 오름차순 정렬
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] - c2[2]);

        // Union & Find를 사용하기 위해 parent 배열 선언
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i; // 처음에는 자기 자신으로 부모를 초기화 (집합을 초기화)
        }

        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            int fromParent = findParent(from);
            int toParent = findParent(to);

            // 부모노드가 같으면 (같은 집합이면) (두 노드가 같은 그래프 집합에 속하면)
            // 해당 간선은 선택하지 않는다. (회로 싸이클이 되므로)
            if (fromParent == toParent) continue;

            answer += cost; // 아니면 최소이므로 answer에 값을 합해준다.
            parent[toParent] = fromParent; // 간선을 연결해 두 노드를 같은 집합으로 만든다. (부모 노드를 갱신)
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
