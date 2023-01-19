package e_031_프로그래머스_고득점킷.g_018_DFS_BFS.게임맵최단거리_001_BFS;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/1844

[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1

5 5
1 0 1 1 1
1 0 1 0 1
1 0 1 1 1
1 1 1 0 1
0 0 0 0 1
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_Node_BufferedReader {

    static class Node { // static class로 선언해줘야 한다.

        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int n, m;

    static int bfs(int x, int y, int[][] map) {

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(x, y, 1));
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if (now.x == map.length - 1 && now.y == map[0].length - 1) return now.cost;

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {

                int nx = now.x + dx[i]; // 이동했을 때 위치
                int ny = now.y + dy[i]; // 이동했을 때 위치

                // 범위를 벗어나면 continue
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) { // && 아니다 || 이다 주의!!!
                    continue;
                }

                // 갈 수 있는 길이면
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true; // 방문 체크
                    queue.offer(new Node(nx, ny, now.cost + 1)); // 큐에 넣기
                }
            }
        }

        return -1;
    }

    public int solution(int[][] map) {

        int answer = 0;

        n = map.length;
        m = map[0].length;

        visited = new boolean[n][m];

//        System.out.println(Arrays.deepToString(visited));

//        visited[0][0] = true; // 시작 위치 방문 체크

        answer = bfs(0, 0, map);

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Solution_Node_BufferedReader sol = new Solution_Node_BufferedReader();

        Scanner sc = new Scanner(System.in);

        int nn = sc.nextInt();
        int mm = sc.nextInt();

//        int[][] map = new int[n][m];
        int[][] map = new int[nn][mm];

        for (int i = 0; i < nn; i++) {
            for (int j = 0; j < mm; j++) {
                map[i][j] = sc.nextInt();
            }
        }

//        System.out.println(Arrays.deepToString(map));

        System.out.println(sol.solution(map));
    }
}
