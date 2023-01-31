package e_031_프로그래머스_고득점킷.g_015_완전탐색;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/87946

80	[[80,20],[50,40],[30,10]]	3


3
80
80 20
50 40
30 10

정답 : 3

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Solution
public class 피로도_001_완전탐색_DFS {

    static int answer = 0;
    static boolean[] visit;

    public static int solution(int k, int[][] dungeons) {

        answer = 0;

        visit = new boolean[dungeons.length];

        dfs(k, dungeons, 0); // k는 현재 피로도

        return answer;

//        System.out.println(Arrays.deepToString(dungeons));
    }

    public static void dfs(int k, int[][] dungeons, int depth) {

        answer = Math.max(answer, depth); // dfs를 돌 때마다 최대값 계산 // for문 앞에 있어도 되고 뒤에 있어도 된다?

        for (int i = 0; i < dungeons.length; i++) {

            if (!visit[i] && dungeons[i][0] <= k) {

                visit[i] = true;
                dfs(k - dungeons[i][1], dungeons, depth + 1);
                visit[i] = false; // 백트래킹
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] dungeons = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dungeons[i][0] = Integer.parseInt(st.nextToken());
            dungeons[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(k, dungeons));
    }
}