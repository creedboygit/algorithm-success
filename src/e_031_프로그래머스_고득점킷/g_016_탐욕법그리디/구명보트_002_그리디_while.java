package e_031_프로그래머스_고득점킷.g_016_탐욕법그리디;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42885

[70, 50, 80, 50] 100
정답 : 3

[70, 80, 50] 100
정답 : 3

4
70 50 80 50
100
정답 : 3

3
70 80 50
100
정답 : 3
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Solution
public class 구명보트_002_그리디_while {

    public static int solution(int[] people, int limit) {

        int answer = 0;

        // 무게순으로 정렬
        Arrays.sort(people);

        int min_index = 0; // 가장 가벼운 사람 위치
        int max_index = people.length - 1; // 가장 무거운 사람 위치

        /*
		 양 끝부터 탐색을 시작해 가장 무거운 사람과 가장 가벼운 사람의 무게 합이
		 limit를 넘지 않으면 정답 카운트 +하고, 인덱스를 한칸씩 안쪽으로 이동
		 limit를 넘으면 정답 카운트 +, max_index만 이동
		 모든 원소를 탐색할 때 까지 반복
		 */
        while (min_index <= max_index) {
            if (people[min_index] + people[max_index] <= limit) {
                answer++;
                min_index++;
                max_index--;
            } else {
                answer++;
                max_index--;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] people = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {

            people[i] = Integer.parseInt(st.nextToken());
        }

        int limit = Integer.parseInt(br.readLine());

        System.out.println(solution(people, limit));
    }
}
