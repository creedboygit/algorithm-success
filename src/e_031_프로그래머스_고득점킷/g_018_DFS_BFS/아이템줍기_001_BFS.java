package e_031_프로그래머스_고득점킷.g_018_DFS_BFS;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/87694

https://blue-jay.tistory.com/88

[[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]]	1	3	7	8
정답 : 17

[[1,1,8,4],[2,2,4,9],[3,6,9,8],[6,3,7,7]]	9	7	6	1
정답 : 11

[[1,1,5,7]] 1	1	4	7
정답 : 9

[[2,1,7,5],[6,4,10,10]]	3	1	7	10
정답 : 15

1
1 1 5 7
1 1
4 7
정답 : 9

2
2 1 7 5
6 4 10 10
3 1
7 10
정답 : 15
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Solution
public class 아이템줍기_001_BFS {

    static class Point {
        int x;
        int y;
        int depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

//    static int answer;

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        int answer = 0;

//        System.out.println(Arrays.deepToString(rectangle));
//        System.out.println(characterX);
//        System.out.println(characterY);
//        System.out.println(itemX);
//        System.out.println(itemY);

        int m = 105;
        int n = 105;

        int[][] board = new int[n][m];

        int rectangleNum = rectangle.length;

        // 사각형을 1로 채움
        for (int i = 0; i < rectangleNum; i++) {
            int[] r = rectangle[i];
            for (int x = r[0] * 2; x <= r[2] * 2; x++) {
                for (int y = r[1] * 2; y <= r[3] * 2; y++) {
                    board[x][y] = 1;
                }
            }
        }

        // 안쪽을 0으로 채움
        for (int i = 0; i < rectangleNum; i++) {
            int[] r = rectangle[i];

            for (int x = r[0] * 2 + 1; x <= r[2] * 2 - 1; x++) {
                for (int y = r[1] * 2 + 1; y <= r[3] * 2 - 1; y++) {
                    board[x][y] = 0;
                }
            }
        }

//        System.out.println(Arrays.deepToString(board));

        boolean[][] visited = new boolean[n][m];

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Point start = new Point(characterX * 2, characterY * 2, 0);

        Queue<Point> q = new LinkedList<>();

        visited[characterX * 2][characterY * 2] = true;

        q.add(start);

        while (!q.isEmpty()) {
            Point front = q.poll();
            if (front.x == itemX * 2 && front.y == itemY * 2) {
                answer = front.depth;
                break;
            }

            for (int k = 0; k < 4; k++) {
                int nx = front.x + dx[k];
                int ny = front.y + dy[k];

                if (!visited[nx][ny] && board[nx][ny] == 1) {
                    q.add(new Point(nx, ny, front.depth + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return answer / 2;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] rectangle = new int[n][4];

        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            rectangle[i][0] = Integer.parseInt(st1.nextToken());
            rectangle[i][1] = Integer.parseInt(st1.nextToken());
            rectangle[i][2] = Integer.parseInt(st1.nextToken());
            rectangle[i][3] = Integer.parseInt(st1.nextToken());
        }

//        System.out.println(Arrays.deepToString(rectangle));

        StringTokenizer st2 = new StringTokenizer(br.readLine()); // 시작 위치 (캐릭터 위치)
        int characterX = Integer.parseInt(st2.nextToken());
        int characterY = Integer.parseInt(st2.nextToken());

        StringTokenizer st3 = new StringTokenizer(br.readLine()); // 종료 위치 (아이템 위치)
        int itemX = Integer.parseInt(st3.nextToken());
        int itemY = Integer.parseInt(st3.nextToken());

//        System.out.println(characterX);
//        System.out.println(characterY);
//        System.out.println(itemX);
//        System.out.println(itemY);

        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));

        br.close();
    }
}
