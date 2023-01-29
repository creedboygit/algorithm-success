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
import java.util.Comparator;
import java.util.StringTokenizer;

//Solution
public class 단속카메라_001_그리디 {

    public static int solution(int[][] routes) {

        int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int cam = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (cam < route[0]) {
                // 현재 카메라의 위치가 route의 시작 지점보다 작으면
                // 새로운 cam을 route의 종료 지점에 설치한다.
                cam = route[1];
                answer++;
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
