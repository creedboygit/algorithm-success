package c_010_inflearn.i_002_Array_1_2차원배열.i_002_006_뒤집은소수;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72723?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/02-06

/*
i_002_006_뒤집은소수

설명

N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.

예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.

첫 자리부터의 연속된 0은 무시한다.


입력
첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.

각 자연수의 크기는 100,000를 넘지 않는다.


출력
첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
*/

/*
입력
9
32 55 62 20 250 370 200 30 100

출력
23 2 73 2 3
*/

// 1번째 방법
//    // 소수인지 아닌지 판별하는 공식
//    public boolean isPrime(int num) {
//
////        System.out.println(num);
//
//        if (num == 1) return false;
//
//        for (int i = 2; i < num; i++) {
////            System.out.println(num + " % " + i + " : " + num % i);
//
//            if (num % i == 0) return false;
//        }
//
////        System.out.println("----------");
//
//        return true;
//    }
//
//    public ArrayList<Integer> solution(int n, int[] nums) {
//
//        ArrayList<Integer> answer = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            int tmp = nums[i];
//            int res = 0;
//            while (tmp > 0) {
//                int t = tmp % 10;
////                System.out.println("tmp : " + tmp + " " + t);
//                res = res * 10 + t;
////                System.out.println("res : " + res);
//                tmp = tmp / 10;
//            }
//
//            if (isPrime(res)) answer.add(res);
////            System.out.println("-----------");
//        }
//
//
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
//        int[] nums = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//
////        System.out.println(t.solution(n, nums));
//
//        for (int x : t.solution(n, nums)) {
//            System.out.print(x + " ");
//        }
//    }

// 2번째 방법

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        String[] strArr = new String[num];
        for (int i = 0; i < num; i++) {
            strArr[i] = sc.next();
        }

        for (String s : strArr) {
            int answer = check(reverse(s));
            if (answer != 0) {
                System.out.print(answer + " ");
            }
        }
    }

    public static int reverse(String str) {
        String result = new StringBuilder(str).reverse().toString();
        return Integer.valueOf(result);
    }

    public static int check(int num) {
        if (num == 1) {
            return 0;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return 0;
        }

        return num;
    }
}
