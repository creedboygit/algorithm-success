package a_010_goorm.goormReal.quiz_004_슈퍼로봇대전_002_풀기_정답;

import java.util.*;

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

public class Main9 {

    public int solution(int n, int[][] results) {

        int answer = 0;

        ArrayList<ArrayList<Integer>> win = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> lose = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n + 1; i++) {
            win.add(new ArrayList<Integer>());
            lose.add(new ArrayList<Integer>());
        }

        for (int[] i : results) {
            int a = i[0];
            int b = i[1];

            win.get(a).add(b);
            lose.get(b).add(a);
        }

        int ans = 0;

        for (int i = 1; i < n + 1; i++) {
            if (BFS(win, i, n) + BFS(lose, i, n) == n - 1) {
                ans++;
            }
        }
        return ans;
    }

    int BFS(ArrayList<ArrayList<Integer>> graph, int start, int n) {

        boolean[] visited = new boolean[n + 1];
        visited[start] = true;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);

        int a = -1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            a++;

            for (int i : graph.get(cur)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        return a;
    }

    public static void main(String[] args) throws Exception {

        Main9 t = new Main9();

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
