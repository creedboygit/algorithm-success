package a_010_goorm.goormReal.quiz_004_슈퍼로봇대전_002_풀기_정답;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

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

public class Main7_정답_플로이드워셜_DP_BufferedReader {

    final static int INF = 1000000;

    // 플로이드워셜 이용
    public int solution(int n, int[][] results) {

        int[][] table = new int[n + 1][n + 1];

        for (int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];

            table[win][lose] = 1;
            table[lose][win] = -1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (table[i][k] == 1 && table[k][j] == 1) {
                        table[i][j] = 1;
                    } else if (table[i][k] == -1 && table[k][j] == -1) {
                        table[i][j] = -1;
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;

            for (int j = 1; j <= n; j++) {
                if (table[i][j] != 0) { // 갱신된 순위가 아니라면 (이기고 진 것이 확실한 거라면)
                    cnt++;
                }
            }

            if (cnt == n - 1)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main7_정답_플로이드워셜_DP_BufferedReader t = new Main7_정답_플로이드워셜_DP_BufferedReader();

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][2];

        for (int i = 0; i < m; i++) { // m까지이다 조심하자

            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(arr.length);

//        for (int i = 0; i < m; i++) {
//            System.out.println(arr[i][0] + " - " + arr[i][1]);
//        }
//
//        System.out.println(Arrays.deepToString(arr));

        System.out.println(t.solution(n, arr));
    }

    @Test
    public void test() {
        Assertions.assertEquals(2, solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}
