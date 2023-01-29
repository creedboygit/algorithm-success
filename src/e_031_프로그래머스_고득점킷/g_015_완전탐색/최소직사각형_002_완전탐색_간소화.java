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
public class 최소직사각형_002_완전탐색_간소화 {

    public static int solution(int[][] sizes) {

        int answer = 0;

        int length = 0, height = 0;

        for (int[] size : sizes) {
            length = Math.max(length, Math.max(size[0], size[1]));
            height = Math.max(height, Math.min(size[0], size[1]));
        }

        answer = length * height;

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
