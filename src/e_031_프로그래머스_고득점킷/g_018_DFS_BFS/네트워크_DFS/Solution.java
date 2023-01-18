package e_031_프로그래머스_고득점킷.g_018_DFS_BFS.네트워크_DFS;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/43162

3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]

3
1 1 0
1 1 0
0 0 1

답
2
 */

import java.util.*;

public class Solution {

    boolean[] visited;

    public void dfs(int node, int[][] computers) { // 모든 컴퓨터를 돌면서 방문
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) { // 컴퓨터를 모두 탐색하면서
            if (!visited[i] && computers[node][i] == 1) { // 연결되어 있으면서 방문하지 않았으면 방문 체크하면서 계속 탐색
                dfs(i, computers);
            }
        }
    }

//    public int solution(int n, int[][] computers) {
    public int solution(int n, int[][] computers) {

        int answer = 0;

        visited = new boolean[n];

        for (int i = 0; i < computers.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) { // 방문하지 않은 컴퓨터가 있다면
                answer++; // 연결되지 않은 네트워크가 존재한다는 것이므로 +1 (dfs를 몇 번 돌았느냐가 답)
                dfs(i, computers); // 방문하러 가기
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
