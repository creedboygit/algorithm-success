package e_031_프로그래머스_고득점킷.g_015_완전탐색;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42840

[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]


5
1 2 3 4 5

정답 : [1]

5
1 3 2 4 2

정답 : [1, 2, 3]

10
1 2 3 4 5 1 3 2 3 4

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Solution
public class 모의고사_003_완전탐색 {

    public static int[] solution(int[] question) {

        int[] a = {1, 2, 3, 4, 5}; // 5개씩 반복
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5}; // 8개씩 반복
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10개씩 반복

        int[] score = new int[3]; // 각 수포자들의 점수

        // score[] 에 수폽포자별 맞힌 갯수
        for (int i = 0; i < question.length; i++) {
            if (question[i] == a[i % a.length]) score[0]++;
            if (question[i] == b[i % b.length]) score[1]++;
            if (question[i] == c[i % c.length]) score[2]++;
        }

        // 최대 점수 구하기
//        int max = Math.max(score[0], Math.max(score[1], score[2]));
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (score[i] > max) max = score[i];
        }

        // 가장 높은 점수를 받은 사람 수
        int maxCount = 0;
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) maxCount++;
        }

        int[] answer = {};
        answer = new int[maxCount];

        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) answer[idx++] = i + 1;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

//        System.out.println(n);

        int[] question = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < question.length; i++) {

            question[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(4 % 8);

//        System.out.println(solution(question));

        int[] ans = solution(question);

        for (int i = 0; i < solution(question).length; i++) {
            System.out.println(ans[i]);
        }
    }
}
