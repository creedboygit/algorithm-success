package c_010_인프런.i_003_TwoPointers_SlidingWindow_효율성.i_003_002_공통원소구하기_투포인터스알고리즘;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72732?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/03-02

/*
i_003_002_공통원소구하기_투포인터스알고리즘

설명

A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.

두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.

네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

각 집합의 원소는 1,000,000,000이하의 자연수입니다.


출력
두 집합의 공통원소를 오름차순 정렬하여 출력합니다.



*/

/*
입력
5
1 3 9 5 2
5
3 2 5 7 8

출력
2 3 5
*/

    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {

        ArrayList<Integer> answer = new ArrayList<>();

        Arrays.sort(a); // 일단 오름차순으로 정렬 시켜준다.
        Arrays.sort(b); // 일단 오름차순으로 정렬 시켜준다.

        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m) {
            if (a[p1] == b[p2]) {
                answer.add(a[p1]);
                p1++;
                p2++;
            } else if (a[p1] < b[p2]) {
                p1++;
            } else {
                p2++;
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

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        int[] b = new int[m];

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        for (int x : t.solution(n, m, a, b)) {
            System.out.print(x + " ");
        }
    }
}
