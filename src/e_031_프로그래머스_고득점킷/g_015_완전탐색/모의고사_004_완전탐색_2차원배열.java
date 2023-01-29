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
public class 모의고사_004_완전탐색_2차원배열 {

    public static int[] solution(int[] question) {

        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] hit = new int[3];

        for (int i = 0; i < hit.length; i++) {
            for (int j = 0; j < question.length; j++) {
                if (patterns[i][j % patterns[i].length] == question[j]) hit[i]++;
            }
        }

        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < hit.length; i++)
            if (max == hit[i]) list.add(i + 1);

        int[] answer = new int[list.size()];
        int cnt = 0;
        for (int num : list)
            answer[cnt++] = num;

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
