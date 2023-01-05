package c_010_inflearn.i_008_DFS_BFS_활용.i_008_003_최대점수구하기;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73398?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/08-03

/*
3. 최대점수 구하기(DFS)
설명

이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.

각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.

제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.

(해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)


입력
첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.

두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.


출력
첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.



*/

/*
입력
5 20
10 5
25 12
15 8
6 3
7 4

출력
41
*/
    static int answer = Integer.MIN_VALUE; // 최대값 구해야 하므로 Min
    static int n; // static으로 전역으로 선언해야 함 주의
    static int m; // static으로 전역으로 선언해야 함 주의

    public void DFS(int L, int sum, int time, int[] scoreArr, int[] timeArr) {
        if (time > m) return;

        if (L == n) { // 한 부분집합이 완성되면
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + scoreArr[L], time + timeArr[L], scoreArr, timeArr);
            DFS(L + 1, sum, time, scoreArr, timeArr);
        }
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[] scoreArr = new int[n]; // 꼭 static으로 사용해야 한다
        int[] timeArr = new int[n]; // 꼭 static으로 사용해야 한다

        for (int i = 0; i < n; i++) {
            scoreArr[i] = sc.nextInt();
            timeArr[i] = sc.nextInt();
        }

        t.DFS(0, 0, 0, scoreArr, timeArr);

        System.out.println(answer);
    }
}
