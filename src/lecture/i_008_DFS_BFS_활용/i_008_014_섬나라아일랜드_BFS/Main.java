package lecture.i_008_DFS_BFS_활용.i_008_014_섬나라아일랜드_BFS;

import java.util.*;

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73409?tab=curriculum

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73408?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/08-13

/*
13. 섬나라 아일랜드
설명

N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.

각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.

섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.

Image1.jpg

만약 위와 같다면 섬의 개수는 5개입니다.


입력
첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.

두 번째 줄부터 격자판 정보가 주어진다.


출력
첫 번째 줄에 섬의 개수를 출력한다.



*/

/*
입력
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0

출력
5
*/

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n;
//    static int[][] board;
    static int answer = 0;

    static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};

    public void BFS(int x, int y, int[][] board) {
        Queue<Point> Q = new LinkedList<>();

        Q.offer(new Point(x, y));
        while (!Q.isEmpty()) {
            Point pos = Q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) { // 육지를 만났을 때 && 밖으로 벗어나지 않았을 때
                    board[nx][ny] = 0; // 바다로 만들어라
                    Q.add(new Point(nx, ny));
                }
            }
        }
    }

    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0; // 육지를 바다로 일단 만들기 (초기화)
                    BFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[][] board = new int[n][n]; // board는 static으로 만들면 안된다

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        t.solution(board);

        System.out.println(answer);
    }
}
