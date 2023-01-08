package a_010_goorm.goormReal.quiz_004_슈퍼로봇대전_002_풀기_정답;

import java.util.Arrays;
import java.util.Scanner;

/*
똑같은 문제 발견

[https://easybrother0103.tistory.com/131](https://easybrother0103.tistory.com/131)

[https://school.programmers.co.kr/learn/courses/30/lessons/49191](https://school.programmers.co.kr/learn/courses/30/lessons/49191)

[https://gom20.tistory.com/178](https://gom20.tistory.com/178)

23.01.06 - 구글링 : “프로그래머스 순위” 로 검색하니깐 나왔다

[https://www.google.co.kr/search?q=프로그래머스+순위](https://www.google.co.kr/search?q=%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4+%EC%88%9C%EC%9C%84)

https://www.acmicpc.net/problem/2458
 */

/*
입력
5 5
4 3
4 2
3 2
1 2
2 5

출력
2

-----------

입력
3 3
1 2
2 3
1 3

출력
3

-----------

입력
2 1
1 2

출력
2
 */

//자세한 설명 : https://nahwasa.com/85

// 아래 풀이 방법 : https://suhyeokeee.tistory.com/184

public class Main5_정답_플로이드워셜_DP {

    // 플로이드워셜 이용
    public int solution(int n, int[][] results) {

        int answer = n;
        int INF = n * n;
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int[] result : results) {
            graph[result[0] - 1][result[1] - 1] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (graph[i][j] == INF && graph[j][i] == INF) {
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main5_정답_플로이드워셜_DP t = new Main5_정답_플로이드워셜_DP();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        int[][] arr = new int[m][2]; // m인것 조심하자

        for (int i = 0; i < m; i++) { // m까지이다 조심하자
//            System.out.println("i : " + i);
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
//            System.out.println("i : " + i);
        }

//        System.out.println(arr.length);

//        for (int i = 0; i < m; i++) {
//            System.out.println(arr[i][0] + " - " + arr[i][1]);
//        }
//
//        System.out.println(Arrays.deepToString(arr));

        System.out.println(t.solution(n, arr));
    }
}
