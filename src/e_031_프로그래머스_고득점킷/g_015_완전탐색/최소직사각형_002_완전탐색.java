package e_031_프로그래머스_고득점킷.g_015_완전탐색;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/86491

[[60, 50], [30, 70], [60, 30], [80, 40]]
정답 : 4000

[[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]
정답 : 120

[[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]
정답 : 133


4
60 50
30 70
60 30
80 40

정답 : 4000

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Solution
public class 최소직사각형_002_완전탐색 {

    public static int solution(int[][] sizes) {

        int answer = 0;

        int max_row = 0; // 가로의 최대 길이
        int max_col = 0; // 세로의 최대 길이

        for (int i = 0; i < sizes.length; i++) { // 긴 부분을 가로로 재배치
            if (sizes[i][0] < sizes[i][1]) { // 세로가 더 길 경우 세로와 가로를 바꿔준다.
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }

            if (max_row < sizes[i][0]) max_row = sizes[i][0]; // 최대값
            if (max_col < sizes[i][1]) max_col = sizes[i][1]; // 최대값
        }

        answer = max_col * max_row;

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] sizes = new int[n][2];

        for (int i = 0; i < sizes.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sizes[i][0] = Integer.parseInt(st.nextToken());
            sizes[i][1] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.deepToString(rectangle));

        System.out.println(solution(sizes));
    }
}
