package lecture.i_010_다이나믹프로그래밍_동적계획법.i_010_002_돌다리건너기;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73422?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/10-02

/*
2. 돌다리 건너기
설명

철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다.

철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.

철수가 개울을 건너는 방법은 몇 가지일까요?

Image1.jpg


입력
첫째 줄은 돌의 개수인 자연수 N(3≤N≤35)이 주어집니다.


출력
첫 번째 줄에 개울을 건너는 방법의 수를 출력합니다.



*/

/*
입력
7

출력
34
*/
    static int[] dy;

    public int solution(int n) {

        int answer = 0;

        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n + 1; i++) { // 개울을 건너야 완성이므로 +2 해준다

            dy[i] = dy[i - 2] + dy[i - 1];
        }

        answer = dy[n + 1]; // 개울을 건너야 완성이므로 n + 1

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dy = new int[n + 2]; // 계단 오르기가 아니라 개울까지 건너야 하므로 +2 해준다 (인덱스 번호까지 포함해서)

        System.out.println(t.solution(n));
    }
}
