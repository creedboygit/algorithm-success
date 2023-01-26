package e_031_프로그래머스_고득점킷.g_016_탐욕법그리디;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42883

1924 2
정답 : 94

1231234 3
정답 : 3234

4177252841 4
정답 : 775841
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Solution
public class 큰수만들기_001_그리디 {

    public static int solution(int num, int n) {

        int answer = 0;



        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        System.out.println(solution(num, n));
    }
}
