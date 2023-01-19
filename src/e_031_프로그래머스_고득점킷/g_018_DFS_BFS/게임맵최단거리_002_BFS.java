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

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//게임맵최단거리_001_BFS
public class 게임맵최단거리_002_BFS {

    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int n, m;

    static void bfs(int[][] map) {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            int x = now[0];
            int y = now[1];

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i]; // 이동했을 때 위치
                int ny = y + dy[i]; // 이동했을 때 위치

//                if (nx < 0 || nx >= map.length) continue;
//                if (ny < 0 || ny >= map[0].length) continue;
//
//                if (visited[nx][ny] != 0) continue;
//                if (map[nx][ny] != 1) continue;

                // 다 통과를 한다면
                if (nx >= 0 && nx < map.length &&
                        ny >= 0 && ny < map[0].length &&
                        visited[nx][ny] == 0 &&
                        map[nx][ny] == 1) {

                    // 방문 체크
                    visited[nx][ny] = visited[x][y] + 1; // visited에 직접 경로의 수를 넣어줌
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static int solution(int[][] map) {

        int answer = 0;

        n = map.length;
        m = map[0].length;

        visited = new int[n][m]; // visited 2차 배열을 0으로 초기화

        visited[0][0] = 1; // 맨 처음을 포함해야 하므로 1로 초기화

//        System.out.println(Arrays.deepToString(visited));

//        visited[0][0] = true; // 시작 위치 방문 체크

        bfs(map);

        answer = visited[map.length - 1][map[0].length - 1];

        if (answer == 0) {
            answer = -1;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

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

        System.out.println(solution(map));
    }
}
