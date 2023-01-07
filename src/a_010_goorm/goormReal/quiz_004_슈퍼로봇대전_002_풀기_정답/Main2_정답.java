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

public class Main2_정답 {

    // 플로이드워셜 이용
    public int solution(int n, int[][] results) {

        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];

//        System.out.println(Arrays.deepToString(results));
//        System.out.println(Arrays.deepToString(graph));

        for (int i = 0; i < results.length; i++)
            graph[results[i][0]][results[i][1]] = 1; // 이김

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int z = 0; z <= n; z++) {
                    if (graph[j][i] == 1 && graph[i][z] == 1)
                        graph[j][z] = 1;
                }
            }
        }

//        System.out.println(Arrays.deepToString(graph));

        for (int i = 1; i <= n; i++) {

            int game = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1 || graph[j][i] == 1) // 자신이 이겼거나 자신을 이겼거나
                    game++;
            }

            if (game == n - 1) // 자신을 제외한 이기고 진 게임이 꽉 찼다면 순위가 확정된 사람
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main2_정답 t = new Main2_정답();

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
