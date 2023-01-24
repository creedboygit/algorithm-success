package e_031_프로그래머스_고득점킷.g_018_DFS_BFS;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/84021

game board
[[1,1,0,0,1,0],[0,0,1,0,1,0],[0,1,1,0,0,1],[1,1,0,1,1,1],[1,0,0,0,1,0],[0,1,1,1,0,0]]

table
[[1,0,0,1,1,0],[1,0,1,0,1,0],[0,1,1,0,1,1],[0,0,1,0,0,0],[1,1,0,1,1,0],[0,1,0,0,0,0]]

정답 : 14

game board
[[0,0,0],[1,1,0],[1,1,1]]

table
[[1,1,1],[1,0,0],[0,0,0]]

정답 : 0


6 6
1 1 0 0 1 0
0 0 1 0 1 0
0 1 1 0 0 1
1 1 0 1 1 1
1 0 0 0 1 0
0 1 1 1 0 0

1 0 0 1 1 0
1 0 1 0 1 0
0 1 1 0 1 1
0 0 1 0 0 0
1 1 0 1 1 0
0 1 0 0 0 0

정답 : 14
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//Solution
public class 퍼즐조각채우기_001 {

    public static int solution(int[][] board, int[][] table) {

        int answer = 0;

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int[][] table = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(a[j]);
            }
        }

//        System.out.println(Arrays.deepToString(board));

        br.readLine();

        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                table[i][j] = Integer.parseInt(a[j]);
            }
        }

//        System.out.println(Arays.deepToString(table));

        System.out.println(solution(board, table));
    }
}
