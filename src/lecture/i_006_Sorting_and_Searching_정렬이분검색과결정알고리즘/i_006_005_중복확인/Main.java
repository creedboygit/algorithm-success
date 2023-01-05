package lecture.i_006_Sorting_and_Searching_정렬이분검색과결정알고리즘.i_006_005_중복확인;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72758?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/06-05

/*
5. 중복 확인
설명

현수네 반에는 N명의 학생들이 있습니다.

선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.

만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,

N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 자연수 N(5<=N<=100,000)이 주어진다.

두 번째 줄에 학생들이 적어 낸 N개의 자연수가 입력된다.


출력
첫 번째 줄에 D 또는 U를 출력한다.
*/

/*
입력
8
20 25 52 30 39 33 43 33

출력
D
*/

    public char solution(int n, int[] arr) {

        char answer = 'U';

        Arrays.sort(arr); // 정렬하는거 까먹지 말자

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) return 'D';
        }

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

        System.out.println(t.solution(n, arr));
    }
}
