package lecture.i_003_TwoPointers_SlidingWindow_효율성_On2_On.i_003_003_최대매출_슬라이딩윈도우;

import java.util.Scanner;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72733?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/03-03

/*
i_003_003_최대매출_슬라이딩윈도우

설명

현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.

만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면

12 1511 20 2510 20 19 13 15

연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.

여러분이 현수를 도와주세요.


입력
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.

두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.


출력
첫 줄에 최대 매출액을 출력합니다.



*/

/*
입력
10 3
12 15 11 20 25 10 20 19 13 15

출력
56
*/

    public int solution(int n, int k, int[] arr) {

        int answer = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        answer = sum;

        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k]; // 슬라이딩윈도우 : 뒤에 하나를 더하고 i - k에 있는 것을 뺀면서 뒤로 밀린다.
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(t.solution(n, k, arr));
    }
}
