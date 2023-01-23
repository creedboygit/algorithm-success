package c_010_인프런.i_002_Array_1_2차원배열.i_002_005_소수_에라토스테네스_체;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72722?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/02-05

/*
i_002_005_소수_에라토스테네스_체

설명

자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.

만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.


입력
첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.


출력
첫 줄에 소수의 개수를 출력합니다.
*/

/*
입력
20

출력
8
*/

    public int solution(int n) {

        int answer = 0;

        int ch[] = new int[n + 1]; // +1 해주는거 까먹지 말자
        for (int i = 2; i <= n; i++) { // i <= n -> n도 포함이라는 거 까먹지 말자
//            System.out.print(ch[i]);
            if (ch[i] == 0) {
                answer++;

                System.out.println("iii = " + i);

                for (int j = i; j <= n; j = j + i) {
//                    System.out.println(ch[i] + " " + ch[j]);
//                    System.out.println("i = " + i + " / j = " + j);

                    ch[j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        String str = sc.next();

        System.out.println(t.solution(n));
    }

}
