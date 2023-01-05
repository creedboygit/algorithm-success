package c_010_inflearn.i_002_Array_1_2차원배열.i_002_001_큰수출력하기;

import java.util.*;
import java.io.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72718?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/02-01

/*
i_002_001_큰수출력하기

설명

N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.

(첫 번째 수는 무조건 출력한다)


입력
첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.


출력
자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
 */

/*
입력
6
7 3 9 5 6 12

출력
7 9 6 12
*/

    public ArrayList<Integer> solution(int n, int[] arr) {

        ArrayList<Integer> answer = new ArrayList<>();

        answer.add(arr[0]); // 맨 앞 수 넣고 초기화

        for (int i = 1; i < n; i++) {

            if (arr[i] > arr[i - 1]) answer.add(arr[i]);
        }

        return answer;
    }

//    public static void main(String[] args) throws Exception {
//
//        Main t = new Main();
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//
//        for (int x : t.solution(n, arr)) {
//            System.out.print(x + " ");
//        }
//    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        br.close();

        String[] tmp = str.split(" ");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        StringBuilder sb = new StringBuilder();
        String result = "";

        for (int x : t.solution(n, arr)) {
//            System.out.print(x + " ");
            result = sb.append(x).append(" ").toString();
        }

        System.out.print(result.trim());
    }
}
