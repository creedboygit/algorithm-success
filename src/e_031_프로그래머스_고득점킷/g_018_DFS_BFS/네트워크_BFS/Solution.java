package e_031_프로그래머스_고득점킷.g_018_DFS_BFS.네트워크_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]

3
1 1 0
1 1 0
0 0 1

답
2
 */

public class Solution {

    boolean[] visited;

    public void bfs(int node, int[][] computers) { // 모든 컴퓨터를 돌면서 방문

        Queue<Integer> q = new LinkedList<>();

        q.offer(node);
        visited[node] = true;

        while (!q.isEmpty()) {

            int now = q.poll();

            for (int i = 0; i < computers.length; i++) {

                // 방문하지 않았고, 연결되어 있고, 자기 자신이 아닌 경우
                if (!visited[i] && computers[now][i] == 1 && now != i) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

//    public int solution(int n, int[][] computers) {
    public int solution(int n, int[][] computers) {

        int answer = 0;

        visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) { // 방문하지 않은 컴퓨터가 있다면

                bfs(i, computers); // 방문하러 가기
                answer++; // 연결되지 않은 네트워크가 존재한다는 것이므로 +1 (bfs를 몇 번 돌았느냐가 답)
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Solution sol = new Solution();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] computers = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                computers[i][j] = sc.nextInt();
            }
        }

//        System.out.println(Arrays.deepToString(computers));

        System.out.println(sol.solution(n, computers));
//        System.out.println(sol.solution());
    }
}
