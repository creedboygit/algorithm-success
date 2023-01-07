package c_010_inflearn.i_002_Array_1_2차원배열.i_002_004_피보나치수열;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72721?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/02-04

/*
i_002_004_피보나치수열

설명

1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.

2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.


입력
첫 줄에 총 항수 N(3<=N<=45)이 입력된다.


출력
첫 줄에 피보나치 수열을 출력합니다.
*/

/*
입력
10

출력
1 1 2 3 5 8 13 21 34 55
*/

// 해법 01 (배열 이용)
//    public int[] solution(int n) {
//
//        int[] answer = new int[n];
//
//        answer[0] = 1;
//        answer[1] = 1;
//
//        for (int i = 2; i < n; i++) {
//            answer[i] = answer[i - 2] + answer[i - 1];
//        }
//
//        return answer;
//    }
//
//    public static void main(String[] args) throws Exception {
//
//        Main9 t = new Main9();
//
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        String str = br.readLine();
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
////        String str = sc.next();
//
////        System.out.println(t.solution(str));
//
//        for (int x : t.solution(n)) {
//            System.out.print(x + " ");
//        }
//    }

// 해법 02 (손코딩 - 바로 출력)

    public static void main(String[] args) throws Exception {
        Main t = new Main();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a = 1;
        int b = 1;

        System.out.print(a + " " + b + " ");

        int c;
        for (int i = 2; i < n; i++) {
            c = a + b;

            System.out.print(c + " ");

            a = b;
            b = c;
        }

    }

}
