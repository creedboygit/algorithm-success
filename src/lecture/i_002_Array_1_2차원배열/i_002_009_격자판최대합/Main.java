package lecture.i_002_Array_1_2차원배열.i_002_009_격자판최대합;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72726?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/02-09

/*
i_002_009_격자판최대합

설명

5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.

Image1.jpg

N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.


입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)

두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


출력
최대합을 출력합니다.
*/

/*
입력
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19


출력
155
*/

    public int solution(int n, int[][] arr) {

        int answer = Integer.MIN_VALUE;

        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < n; i++) {

            sum1 = 0;
            sum2 = 0;

            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j]; // 행의 합
                sum2 += arr[j][i]; // 열의 합
            }

            answer = Math.max(answer, sum1); // 괄호안, 괄호밖 주의
            answer = Math.max(answer, sum2); // 괄호안, 괄호밖 주의
        }

        sum1 = 0;
        sum2 = 0;

        for (int i = 0; i < n; i++) {

            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }

        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(t.solution(n, arr));
    }
}
