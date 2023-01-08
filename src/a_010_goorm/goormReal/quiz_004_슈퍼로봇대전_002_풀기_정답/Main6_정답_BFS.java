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

//자세한 설명 : https://nahwasa.com/85

//아래 풀이 방법 : https://maetdori.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%88%9C%EC%9C%84-JAVA
//BFS 이용


class Node {
    int win;
    int defeat;
}

public class Main6_정답_BFS {

    static List<Integer>[] adj;
    static Node[] nodes;
    static int N;

    // 플로이드워셜 이용
    public int solution(int n, int[][] results) {

        adj = new ArrayList[n + 1];
        nodes = new Node[n + 1];
        N = n;

        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
            nodes[i] = new Node();
        }

        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];

            adj[winner].add(loser);
        }

        nodeUpdate();
        return hasRank();
    }

    private void nodeUpdate() {
        for (int i = 1; i < N + 1; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];

            visited[i] = true;
            queue.offer(i);

            while (!queue.isEmpty()) {
                int winner = queue.poll();

                for (int loser : adj[winner]) {
                    if (visited[loser]) continue;
                    visited[loser] = true;
                    queue.offer(loser);
                    nodes[i].win++;
                    nodes[loser].defeat++;
                }
            }
        }
    }

    private int hasRank() {
        int count = 0;
        for (Node node : nodes) {
            if (node.win + node.defeat == N - 1) count++;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {

        Main6_정답_BFS t = new Main6_정답_BFS();

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
