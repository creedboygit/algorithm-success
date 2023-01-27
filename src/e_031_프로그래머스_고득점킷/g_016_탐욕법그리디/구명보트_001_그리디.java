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
public class 구명보트_001_그리디 {

    public static int solution(int[] people, int limit) {

        int answer = 0;

        Arrays.sort(people);

        System.out.println(Arrays.toString(people));
        System.out.println("------------------");

        int index = 0;

        for (int i = people.length - 1; i >= index; i--) {

            System.out.println("i : " + i);
            System.out.println("index1 : " + index);

            if (people[i] + people[index] <= limit) {
                index++;
            }

            System.out.println("index2 : " + index);

            answer++;

            System.out.println("answer : " + answer);

            System.out.println("------------------");
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
