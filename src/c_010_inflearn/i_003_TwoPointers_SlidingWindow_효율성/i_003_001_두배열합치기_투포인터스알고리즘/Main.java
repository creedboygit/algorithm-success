package c_010_inflearn.i_003_TwoPointers_SlidingWindow_효율성.i_003_001_두배열합치기_투포인터스알고리즘;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72731?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/03-01

/*
i_003_001_두배열합치기_투포인터스알고리즘

설명

오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.

두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.

세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.

네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.

각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.


출력
오름차순으로 정렬된 배열을 출력합니다.



*/

/*
입력
3
1 3 5
5
2 3 6 7 9

출력
1 2 3 3 5 6 7 9
*/

    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {

        ArrayList<Integer> answer = new ArrayList<Integer>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {

            if (a[p1] < b[p2]) {
//                answer.add(a[p1]);
//                p1++;

                answer.add(a[p1++]);
            } else {
//                answer.add(b[p2]);
//                p2++;

                answer.add(b[p2++]);
            }
        }

        while (p1 < n) {
//            answer.add(a[p1]);
//            p1++;

            answer.add(a[p1++]);
        }

        while (p2 < m) {
//            answer.add(b[p2]);
//            p2++;

            answer.add(b[p2++]);
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

//        System.out.println(Arrays.toString(a));

        int m = sc.nextInt();

        int[] b = new int[m];

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

//        System.out.println(Arrays.toString(b));

        for (int x : t.solution(n, m, a, b)) {
            System.out.print(x + " ");
        }
    }
}
