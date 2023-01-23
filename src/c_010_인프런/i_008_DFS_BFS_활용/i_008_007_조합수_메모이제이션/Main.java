package c_010_인프런.i_008_DFS_BFS_활용.i_008_007_조합수_메모이제이션;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73402?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/08-07

/*
7. 조합의 경우수(메모이제이션)
설명

Image1.jpg로 계산합니다.

하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.

Image1.jpg


입력
첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.


출력
첫째 줄에 조합수를 출력합니다.



*/

/*
입력1
5 3

출력1
10

입력2
33 19

출력2
818809200
*/
    int[][] dy = new int[35][35]; // 메모이제이션을 위해 - 문제에서 33개까지라고 했으니까 넉넉하게 35로 잡는다

    public int DFS(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r]; // 메모이제이션 활용
        if (n == r || r == 0) return 1;
        else {
            return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r); // 메모이제이션에 넣어놓는다
        }
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.print(t.DFS(n, r));

    }
}
