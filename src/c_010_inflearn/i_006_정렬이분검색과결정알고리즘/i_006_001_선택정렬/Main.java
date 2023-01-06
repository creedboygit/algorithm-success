package c_010_inflearn.i_006_정렬이분검색과결정알고리즘.i_006_001_선택정렬;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72754?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/06-01

/*
1. 선택 정렬
설명

N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.

정렬하는 방법은 선택정렬입니다.


입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.

두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.


출력
오름차순으로 정렬된 수열을 출력합니다.
*/

/*
입력
6
13 5 11 7 23 15

출력
5 7 11 13 15 23
*/

    public int[] solution(int n, int[] arr) {

        int[] answer = new int[n];

//        for (int i = 0; i < n; i++) {
        for (int i = 0; i < n - 1; i++) {
            int idx = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[idx]) idx = j;
            }

//            System.out.println(idx);

            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;

//            System.out.println(Arrays.toString(arr));
        }

        answer = arr;

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

//        System.out.println(t.solution(n, arr));

        for (int x : t.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
