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
public class 전력망을둘로나누기_003_완전탐색_BFS_인접리스트 {

    static ArrayList<Integer>[] list;

    // bfs에서 연결이 끊긴것을 v1에서 v2로 가는 경우를 제외함으로 해결하였다.
    public static int solution(int n, int[][] wires) {

        int answer = 100;

        // 인접리스트 초기화
        list = new ArrayList[n + 1];

        // 인접리스트 초기화
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        // 인접리스트 양방향 연결
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            list[v1].add(v2);
            list[v2].add(v1);
        }

        // 전력망을둘로나누기_004_완전탐색_BFS_인접리스트
        for (int[] wire : wires) {
            int b1 = bfs(wire[0], wire[1], n);
//            int b2 = bfs(wire[1], wire[0], n);

//            answer = Math.min(answer, Math.abs(b1 - b2));
//            answer = Math.min(answer, Math.abs(n - (2 * b1)));

            // 한 쪽만 구해서 나머지와의 차이를 비교한다.
            answer = Math.min(answer, Math.abs(b1 - (n - b1)));
        }

        return answer;
    }

    public static int bfs(int v1, int v2, int n) {

        Queue<Integer> queue = new LinkedList<>();

        boolean[] visit = new boolean[n + 1];

        int cnt = 0;

        queue.add(v1);
        visit[v1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;

            for (int next : list[cur]) {
                if (next != v2 && !visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                }
            }
        }

        return cnt;
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