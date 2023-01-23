package c_010_인프런.i_003_TwoPointers_SlidingWindow_효율성.i_003_004_연속부분수열_복합적문제;

import java.util.Scanner;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72734?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/03-05

/*
4. 연속 부분수열
설명

N개의 수로 이루어진 수열이 주어집니다.

이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.

만약 N=8, M=6이고 수열이 다음과 같다면

1 2 1 3 1 1 1 2

합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.


입력
첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.

수열의 원소값은 1,000을 넘지 않는 자연수이다.


출력
첫째 줄에 경우의 수를 출력한다.
*/

/*
입력
8 6
1 2 1 3 1 1 1 2

출력
3
*/

    public int solution(int n, int m, int[] arr) {

        int answer = 0;
        int sum = 0;
        int lt = 0;
//        int rt = 0;

        for (int rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];
//            System.out.println(sum);
            while (sum > m) {
//                System.out.println("sum = " + sum + " / m = " + m);

//                System.out.println("sum = " + sum + " / lt = " + lt + " / arr[lt] = " + arr[lt]);

                sum -= arr[lt];

//                System.out.println("sum = " + sum + " / lt = " + lt + " / arr[lt] = " + arr[lt]);
//                System.out.println("----------------");

                lt++;
            }

//            System.out.println(sum);


            if (sum == m) answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(t.solution(n, m, arr));
    }
}
