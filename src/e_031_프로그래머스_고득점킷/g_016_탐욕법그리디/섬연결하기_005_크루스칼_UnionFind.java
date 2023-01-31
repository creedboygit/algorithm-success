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
import java.util.StringTokenizer;

//Solution
public class 섬연결하기_005_크루스칼_UnionFind {

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

        parent = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; // 집합 배열 초기화
        }

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        int cnt = 0;

        for (int[] i : costs) {
            int a = find(i[0]);
            int b = find(i[1]);

            if (a != b) { // 연결되어 있지 않으면
                answer += i[2]; // 최소 비용을 더해준다.
                union(i[0], i[1]);

                if (cnt == n - 1) return answer; // 간선은 무조건 노드 개수 -1 한 것이므로 간선의 개수만큼만 돌아서 시간 복잡도를 아낀다.
            }
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
