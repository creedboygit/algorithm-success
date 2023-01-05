package a_010_goorm.goormReal.quiz_002_놀러와요구름의숲_002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
H.........
..........
..........
..........
..........
..........
..........
..........
..........
R........M

위 답 : 17

..........
..........
..........
..H.......
..........
.....R....
..........
..........
.....M....
..........

위 답 : 7

..........
..........
....M.....
..........
..........
....R.....
..........
..........
....H.....
..........

위 답 : 7

*/

public class Main {

    static final int MAX_N = 20; // 충분히 많이 잡아주기

    static String[][] arr = new String[MAX_N][MAX_N];

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int row, col, dist;

        Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    static int bfs(int startRow, int startCol, int endRow, int endCol) {

        System.out.println("시작 : " + startRow + " " + startCol);
        System.out.println("끝 : " + endRow + " " + endCol);

        boolean[][] visited = new boolean[MAX_N][MAX_N];

        Queue<Point> queue = new LinkedList<>();
        visited[startRow][startCol] = true; // 방문 체크 배열 초기화
        queue.offer(new Point(startRow, startCol, 0)); // 큐 맨 처음 add될 것 초기화

        while (!queue.isEmpty()) {

            Point curr = queue.poll();
            if (curr.row == endRow && curr.col == endCol) {
                return curr.dist - 1; // 도착지 미포함 - 벤 나무의 갯수만 구하므로 -1
            }

            for (int i = 0; i < 4; i++) {

                int nr = curr.row + dx[i];
                int nc = curr.col + dy[i];

                if (nr < 0 || nr > 9 || nc < 0 || nc > 9) continue; // nr > 9 -> 9인것 주의
                if (visited[nr][nc]) continue; // continue 적극 활용하기
                if (arr[nr][nc].equals("R")) { // equals 비교인 것 주의
                    System.out.println("장애물 : " + nr + " - " + nc);
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new Point(nr, nc, curr.dist + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

        int n = 10;

        // String 2중 for문 2차 배열 만드는 방법 숙지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {

            String[] a = br.readLine().split("");

            for (int j = 0; j < n; j++) {
                arr[i][j] = a[j];
            }
        }

        int startRow = 0, startCol = 0, endRow = 0, endCol = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (arr[i][j].equals("H")) { // String이므로 equals인 것 숙지
                    startRow = i;
                    startCol = j;
                } else if (arr[i][j].equals("M")) { // String이므로 equals인 것 숙지
                    endRow = i;
                    endCol = j;
                }
            }
        }

//        System.out.println(startRow + " " + startCol);
//        System.out.println(endRow + " " + endCol);

        System.out.println(bfs(startRow, startCol, endRow, endCol));
    }
}
