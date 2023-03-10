package e_031_프로그래머스_고득점킷.g_018_DFS_BFS;

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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//Solution
public class 게임맵최단거리_001_BFS_Node_BufferedReader {

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

    public static int solution(int[][] map) {

        int answer = 0;

        n = map.length;
        m = map[0].length;

        visited = new boolean[n][m];

        answer = bfs(0, 0, map);

        return answer;
    }

    public static void main(String[] args) throws Exception {

//        게임맵최단거리_001_BFS_Node_BufferedReader sol = new 게임맵최단거리_001_BFS_Node_BufferedReader();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nn = Integer.parseInt(st.nextToken());
        int mm = Integer.parseInt(st.nextToken());

        int[][] map = new int[nn][mm];

        for (int i = 0; i < nn; i++) {

            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int j = 0; j < mm; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

//        System.out.println(Arrays.deepToString(map));

        System.out.println(solution(map));
    }
}
