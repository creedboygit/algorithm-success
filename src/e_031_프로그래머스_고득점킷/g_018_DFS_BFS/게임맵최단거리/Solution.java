package e_031_프로그래머스_고득점킷.g_018_DFS_BFS.게임맵최단거리;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/1844

[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1

5 5
1 0 1 1 1
1 0 1 0 1
1 0 1 1 1
1 1 1 0 1
0 0 0 0 1
 */

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public int solution(int n, int m, int[][] map) {

        int answer = 0;

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Solution sol = new Solution();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

//        System.out.println(Arrays.deepToString(map));

        System.out.println(sol.solution(n, m, map));
    }
}
