package c_010_인프런.i_010_다이나믹프로그래밍_동적계획법.i_010_001_계단오르기;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73421?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/10-01

/*
1. 계단오르기
설명

철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는

1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.

그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?

Image1.jpg


입력
첫째 줄은 계단의 개수인 자연수 N(3≤N≤35)이 주어집니다.


출력
첫 번째 줄에 올라가는 방법의 수를 출력합니다.



*/

/*
입력
7

출력
21
*/

    static int[] dy;

    public int solution(int n) {

        int answer = 0;

        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        answer = dy[n];

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dy = new int[n + 1]; // 계단이 1번부터 시작하므로 인덱스 + 1을 잡아야 한다.

        System.out.println(t.solution(n));
    }
}
