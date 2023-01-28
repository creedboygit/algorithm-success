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
public class 구명보트_003_그리디_while {

    public static int solution(int[] people, int limit) {

        int answer = 0;

        // people 오름차순 정렬
        Arrays.sort(people);

        // 왼쪽과 오른쪽
        int left = 0;
        int right = people.length - 1;

        // 서로 만날때까지 반복
        while (left <= right) {

            // 가장 작은 사람 + 가장 큰 사람이 제한보다 작으면
            if (people[left] + people[right] <= limit)
                // 작은사람이 탄 것으로 간주
                left++;

            // 큰사람은 항상 보트에 탐
            right--;

            // 보트 횟수 증가
            answer++;
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
