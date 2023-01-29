package e_031_프로그래머스_고득점킷.g_016_탐욕법그리디;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42884

[[-20,-15], [-14,-5], [-18,-13], [-5,-3]]
정답 : 2

4
-20 -15
-14 -5
-18 -13
-5 -3

정답 : 2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Solution
public class 단속카메라_003_그리디 {

    public static int solution(int[][] routes) {

        // 끝나는 시간 순서대로 오름차순 정렬
//        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        int location = routes[0][1]; // 초기화
        int answer = 1; // 초기화

        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > location) {
                answer++;
                location = routes[i][1];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] routes = new int[n][2];

        for (int i = 0; i < routes.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            routes[i][0] = Integer.parseInt(st.nextToken());
            routes[i][1] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.deepToString(routes));

        System.out.println(solution(routes));
    }
}
