package a_010_goorm.goormReal.quiz_004_슈퍼로봇대전_002_풀기_정답;

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

public class Main3_정답_플로이드워셜_DP {

    // 플로이드워셜 이용
    public int solution(int n, int[][] results) {

        boolean[][] game = new boolean[n + 1][n + 1];
        int answer = 0;
        for (int i = 0; i < results.length; i++) {
            game[results[i][0]][results[i][1]] = true;
        }

//        System.out.println(Arrays.deepToString(game));

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (game[j][i] && game[i][k]) {
                        game[j][k] = true;
                    }
                }
            }
        }

//        System.out.println(Arrays.deepToString(game));

        for (int i = 1; i <= n; i++) {
            int cnt = 0;

            for (int j = 1; j <= n; j++) {
                if (game[i][j] || game[j][i]) { // i가 j를 이기거나 i가 j한테 지거나 하는 결과가 있으면 cnt를 ++ 한다.
                    cnt++;
                }
            }

            if (cnt == n - 1) { // 본인을 제외한 게임의 수가 n보다 1(본인) 작으면 순위가 확정된 것이다.
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main3_정답_플로이드워셜_DP t = new Main3_정답_플로이드워셜_DP();

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
