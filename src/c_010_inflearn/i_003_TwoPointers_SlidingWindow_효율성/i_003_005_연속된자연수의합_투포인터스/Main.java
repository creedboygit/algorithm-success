package c_010_inflearn.i_003_TwoPointers_SlidingWindow_효율성.i_003_005_연속된자연수의합_투포인터스;

import java.util.Scanner;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72735?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/03-05

/*
i_003_005_연속된자연수의합_투포인터스

5. 연속된 자연수의 합
설명

N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.

만약 N=15이면

7+8=15

4+5+6=15

1+2+3+4+5=15

와 같이 총 3가지의 경우가 존재한다.


입력
첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.


출력
첫 줄에 총 경우수를 출력합니다.



*/

/*
입력
15

출력
3
*/

    public int solution(int n) {

        int answer = 0;
        int sum = 0;
        int lt = 0;

        int tmp = n / 2 + 1;
        int[] arr = new int[tmp];

        for (int i = 0; i < tmp; i++) {
            arr[i] = i + 1;
        }

        for (int rt = 0; rt < tmp; rt++) {

            sum += arr[rt];

            while (sum > n) {
                sum -= arr[lt];
                lt++;
            }

            if (sum == n) answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(t.solution(n));
    }
}
