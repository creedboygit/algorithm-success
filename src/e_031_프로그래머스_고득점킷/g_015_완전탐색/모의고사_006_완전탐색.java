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
import java.util.List;
import java.util.StringTokenizer;

//Solution
public class 모의고사_006_완전탐색 {

    public static int[] solution(int[] question) {

        int[] a = {1, 2, 3, 4, 5}; // 5개씩 반복
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5}; // 8개씩 반복
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10개씩 반복

        int aa = 0, bb = 0, cc = 0;

        for (int i = 0; i < question.length; i++) {
            if (question[i] == a[i % a.length]) aa++;
            if (question[i] == b[i % b.length]) bb++;
            if (question[i] == c[i % c.length]) cc++;
        }

        int max = Math.max(aa, Math.max(bb, cc));

        List<Integer> list = new ArrayList<>();

        if (max == aa) list.add(1);
        if (max == bb) list.add(2);
        if (max == cc) list.add(3);

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
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
