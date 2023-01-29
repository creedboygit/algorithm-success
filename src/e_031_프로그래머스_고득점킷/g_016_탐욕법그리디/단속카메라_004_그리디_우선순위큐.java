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
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Solution
public class 단속카메라_004_그리디_우선순위큐 {

    public static class Info implements Comparable<Info> {

        int start, end;

        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 끝나는 시간 순서대로 오름차순 정렬
        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.end, o.end);
        }
    }


    public static int solution(int[][] routes) {

        int answer = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>();

        for (int i = 0; i < routes.length; i++) {
            pq.offer(new Info(routes[i][0], routes[i][1]));
        }

        Info ii = pq.poll(); // 맨 처음 초기화
        int right = ii.end; // 맨 처음 초기화
        answer++; // 일단 카메라 한 대 설치하고 시작 - 맨 처음 초기화

        while (!pq.isEmpty()) {

            ii = pq.poll();

            int cameraLeft = ii.start;
            int cameraRight = ii.end;

            if (right < cameraLeft) {
                right = cameraRight;
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
