package e_031_프로그래머스_고득점킷.g_020_그래프;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/49189

6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3



6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2

정답 : 3

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//Solution
public class 가장먼노드_001_그래프 {

    public static int solution(int n, int[][] edge) {

        int answer = 0;

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] edge = new int[m][2];

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            edge[i][0] = Integer.parseInt(st2.nextToken());
            edge[i][1] = Integer.parseInt(st2.nextToken());
        }

//        System.out.println(Arrays.deepToString(edge));

        System.out.println(solution(n, edge));
    }
}
