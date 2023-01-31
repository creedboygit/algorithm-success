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
import java.util.Arrays;
import java.util.StringTokenizer;

//Solution
public class 전력망을둘로나누기_001_완전탐색 {

    public static int solution(int n, int[][] lines) {

        int answer = 0;

//        System.out.println(Arrays.deepToString(lines));


        return answer;
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = n - 1;

        int[][] lines = new int[k][2];

        for (int i = 0; i < k; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, lines));
    }
}