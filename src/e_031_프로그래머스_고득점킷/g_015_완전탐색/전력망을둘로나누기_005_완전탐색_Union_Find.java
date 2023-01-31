package e_031_프로그래머스_고득점킷.g_015_완전탐색;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/86971

9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
4	[[1,2],[2,3],[3,4]]	0
7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	1


9
1 3
2 3
3 4
4 5
4 6
4 7
7 8
7 9


정답 : 3

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//Solution
public class 전력망을둘로나누기_005_완전탐색_Union_Find {

    static int[] parent;

    // bfs에서 연결이 끊긴것을 v1에서 v2로 가는 경우를 제외함으로 해결하였다.
    public static int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;

        parent = new int[n + 1];

        for (int k = 0; k < wires.length; k++) {

            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < wires.length; i++) {
                if (i == k) continue;

                union(wires[i][0], wires[i][1]);
            }

            int size = 0;

            for (int i = 1; i <= n; i++) {
                if (find(parent[i]) != 1) size++;
            }

            answer = Math.min(answer, Math.abs(size - (n - size)));
        }

        return answer;
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fb < fa) {
            int tmp = fa;
            fa = fb;
            fb = tmp;
        }

        if (fa != fb) parent[fb] = fa;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;

        return find(parent[x]);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = n - 1;

        int[][] wires = new int[k][2];

        for (int i = 0; i < k; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, wires));
    }
}